# Changelog
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/), and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]
### Added
- LACLI007 - 04/05/2023 - Add the LoginWindow component.
- LACLI007 - 04/05/2023 - Add the ConnectionWindow class.
- LACLI007 - 04/05/2023 - Add the ConnectionFormularyView class.

### Changed
- LACLI007 - 04/05/2023 - Change the formularys to apply new view.

### Fixed

### Removed

## [0.2]
### Added
- LACLI006 - 21/04/2023 - Add the exceptions of connections.
- LACLI006 - 21/04/2023 - Add the CommunicatorBase class.
- LACLI006 - 21/04/2023 - Add the AESCommunicator class.
- LACLI006 - 21/04/2023 - Add the RSACommunicator class.
- LACLI006 - 21/04/2023 - Add the PlainCommunicator class.
- LACLI006 - 21/04/2023 - Add the AESGenerator class.
- LACLI006 - 21/04/2023 - Add the EstablishConnection class.
- LACLI006 - 21/04/2023 - Add the AuthInServer class.
- LACLI006 - 21/04/2023 - Add the ConnectionManager class.
- LACLI006 - 24/04/2023 - Add the RequesterManager class.
- LACLI003 - 24/04/2023 - Add the Getter and MainView class.
- LACLI003 - 25/04/2023 - Add the MonitoringGetter and MonitoringView class.
- LACLI003 - 25/04/2023 - Add the PartitionGetter and PartitionView class.
- LACLI003 - 26/04/2023 - Add the UserGetter and UserView class.
- LACLI003 - 26/04/2023 - Add the EventGetter and EventView class.
- LACLI003 - 26/04/2023 - Add the ProcessGetter and ProcessView class.
- LACLI003 - 26/04/2023 - Add the ApplicationView class.
- LACLI003 - 26/04/2023 - Add the ApplicationGetter class.
- LACLI003 - 26/04/2023 - Add the ActionsView class.
- LACLI004 - 27/04/2023 - Add the FormularyView class.
- LACLI004 - 27/04/2023 - Add the UserFormularyView class.
- LACLI004 - 27/04/2023 - Add the FormularyWindow class.
- LACLI004 - 27/04/2023 - Add the EventFormularyView class.
- LACLI007 - 28/04/2023 - Add the LoginWindow class.

### Changed
- LACLI003 - 25/04/2023 - Add forgotten things in Getter and MainView class.
- LACLI003 - 26/04/2023 - Change the ApplicationPanel to addapt in ApplicationView class.
- LACLI003 - 26/04/2023 - Implements views in the WindowMain class.
- LACLI004 - 30/04/2023 - Change in the location of actions in the formularys.
- LACLI004 - 30/04/2023 - Implements the formularys in the user and event views.
- LACLI004 - 30/04/2023 - Implements the formularys in the user and event views.
- LACLI003 - 01/05/2023 - Polish details on data collection and handling.
- LACLI002 - 01/05/2023 - Support JDialogs in header.
- LACLI003 - 01/05/2023 - Implements the actions of applications.
- LACLI002 - 01/05/2023 - Change WaitPanel to JDialog.
- LACLI003 - 02/05/2023 - Implements WaitWindow in ApplicationView.
- LACLI003 - 02/05/2023 - Refactor RequestManager and implements it.

### Fixed
- LACLIUCF - 29/04/2023 - Quit client file.
- LACLI006 - 29/04/2023 - Fix close the streams of socket.
- LACLI003 - 29/04/2023 - Unnecessary object.
- LACLI002 - 29/04/2023 - Bad scaled in graph.
- LACLI002 - 29/04/2023 - Bad scaled in RAMPanel.
- LACLI002 - 29/04/2023 - Bad scaled in OSPanel.
- LACLI002 - 01/05/2023 - Can't see selected row when reloading.
- LACLI003 - 01/05/2023 - Edit or delete no selected row.

### Removed
- LACLI002 - 25/04/2023 - Delete the ContainserBase component.

## [0.1]
### Added
- LACLI001 - 12/04/2023 - Add the RoundButton component.
- LACLI001 - 13/04/2023 - Add Buttons with predefined styles.
- LACLI001 - 13/04/2023 - Add the RoundPanel component.
- LACLI001 - 14/04/2023 - Add the ChangeColorFactory class.
- LACLI001 - 14/04/2023 - Add the MenuLabel component.
- LACLI001 - 15/04/2023 - Add the CircleGraphic component.
- LACLI001 - 15/04/2023 - Add the CircleGraphicRAM component.
- LACLI001 - 16/04/2023 - Add the input components.
- LACLI002 - 16/04/2023 - Add the entities.
- LACLI001 - 16/04/2023 - Add the boolean circle component.
- LACLI002 - 16/04/2023 - Add the CPUPanel component.
- LACLI002 - 17/04/2023 - Add the RAMPanel component.
- LACLI002 - 17/04/2023 - Add the GPUPanel component.
- LACLI002 - 18/04/2023 - Add the DistroImageDetector component.
- LACLI002 - 18/04/2023 - Add the OSPanel component.
- LACLI002 - 18/04/2023 - Add the PartitionPanel component.
- LACLI002 - 18/04/2023 - Add the Row component.
- LACLI002 - 18/04/2023 - Add the EventRow component.
- LACLI002 - 19/04/2023 - Add the UserRow component.
- LACLI002 - 19/04/2023 - Add the ProcessRow component.
- LACLI002 - 19/04/2023 - Add the RowContainer component.
- LACLI002 - 20/04/2023 - Add the PanelContainer component.
- LACLI002 - 20/04/2023 - Add the ContainserBase component.
- LACLI002 - 20/04/2023 - Add the ApplicationPanel component.
- LACLI002 - 20/04/2023 - Add the Menu component.
- LACLI002 - 20/04/2023 - Add the Header component.
- LACLI002 - 21/04/2023 - Add the WaitApplicationPanel component.
- LACLI003 - 21/04/2023 - Add the WindowMain component.

### Changed
- LACLI001 - 14/04/2023 - Add the DrawFactory to not to repeat code.
- LACLI001 - 17/04/2023 - Minimun changes in the colors palete.
- LACLI002 - 19/04/2023 - Change Row component in the contain object.
- LACLI002 - 20/04/2023 - Change ContainerBase component in the add container.
- LACLI002 - 21/04/2023 - Changes in the paint complex components.

### Fixed
- LACLI001 - 14/04/2023 - Fix bug when change color of component.
- LACLI001 - 16/04/2023 - Fix bug of scaling shape components.

[Unreleased]: https://github.com/Lagatrix/Lagatrix-Client.git
[0.2]: https://github.com/Lagatrix/Lagatrix-Client.git/releases/tag/0.2
[0.1]: https://github.com/Lagatrix/Lagatrix-Client.git/releases/tag/0.1
