;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 601)
(include sci.sh)
(use Interface)
(use System)

(public
	helpText 0
)

(instance helpText of Code
	(properties)

	(method (init)
		(Print 601 0) ; "WAIT The WAIT cursor will appear on the screen anytime that the game is at a stage where it will not respond to any of your commands. During this time you will not be able to move Graham nor will you have access to the icon bar."
		(Print 601 1) ; "HOLD The HOLD cursor will appear on the screen anytime that Graham is not under your control, but the game will still respond to other commands that don't involve moving Graham. The icon bar and most of its functions will still be available to you during this time."
		(Print 601 2) ; "WALK The WALK cursor will move Graham to any location that he is able to reach."
		(Print 601 3) ; "LOOK Choose LOOK when you want Graham to look at something onscreen."
		(Print 601 4) ; "ACTION Choose ACTION when you want Graham to perform an action on an object (Example: getting a drink from a pond, jumping onto a rock, etc.)"
		(Print 601 5) ; "TALK Choose TALK when you want to initiate a conversation between Graham and another game character."
		(Print 601 6) ; "ITEM Choose ITEM when you want Graham to use that item in the game. An image of the most recently selected inventory item will appear inside the frame."
		(Print 601 7) ; "INVENTORY Choose INVENTORY when you want to see and select from the items you are currently carrying."
		(Print 601 8) ; "CONTROLS Choose CONTROLS when you want to adjust Graham's walking speed, the sound volume, and/or the game detail level. Also choose this if you would like to save your current game, restore a previous game, quit playing, or restart from the beginning."
		(Print 601 9) ; "INFORMATION Choose INFORMATION when you would like to know what each individual cursor does. When you click this button, click again on the icon bar, and you will receive a description."
	)
)

