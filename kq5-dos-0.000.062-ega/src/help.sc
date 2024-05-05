;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 753)
(include sci.sh)
(use Interface)
(use System)

(public
	help 0
)

(local
	[local0 13] = [{\n_____________________WAIT\n\nThe WAIT cursor will appear on the screen anytime that the game is at a stage where it will not respond to any of your commands. During this time you will not be able to move Graham nor will you have access to the icon bar. } {\n_____________________HOLD\n\nThe HOLD cursor will appear on the screen anytime that Graham is not under your control, but the game will still respond to other commands that don't involve moving Graham. The icon bar and most of its functions will still be available to you during this time. } {\n_____________________WALK\n\nChoose WALK when you want to move Graham from place to place onscreen. A walking Graham will move until he encounters an obstacle in his path, then stop. } {\n____________________TRAVEL\n\nChoose TRAVEL when you want Graham to avoid obstacles in his path without stopping as he travels longer distances. } {\n____________________LOOK\n\nChoose LOOK when you want Graham to look at something onscreen. } {\n____________________ACTION\n\nChoose ACTION when you want Graham to perform an action on an object (Example: getting a drink from a pond, jumping onto a rock, etc.) } {\n____________________TALK\n\nChoose TALK when you want to initiate a conversation between Graham and another game character. } {\n____________________ITEM\n\nChoose ITEM when you want Graham to use that item in the game. An image of the most recently selected inventory item will appear inside the frame. } {\n_________________INVENTORY\n\nChoose INVENTORY when you want to see and select from the items you are currently carrying. } {\n________________SAVE/RESTORE\n\nChoose SAVE/RESTORE when you want to save your game, or restore a previously saved game. } {\n____________PAUSE/RESTART/QUIT\n\nChoose PAUSE/RESTART/QUIT when you want to pause the game, quit playing, or restart the game from the beginning. } {\n___________________CONTROLS\n\nChoose CONTROLS when you want to adjust Graham's walking speed, the sound volume, and/or the game detail level. } {\n________________INFORMATION\n\nChoose INFORMATION when you want to see the version number of the game or need to be reminded of what the various game functions are. }]
)

(instance help of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(= temp0 0)
		(repeat
			(cond
				((== temp0 0)
					(= temp1
						(Print
							[local0 temp0]
							82
							947
							0
							temp0
							0
							81
							{Next}
							1
							81
							{Exit}
							0
						)
					)
				)
				((< temp0 12)
					(= temp1
						(Print
							[local0 temp0]
							82
							947
							0
							temp0
							0
							81
							{Next}
							1
							81
							{Previous}
							2
							81
							{Exit}
							0
						)
					)
				)
				(else
					(= temp1
						(Print
							[local0 temp0]
							82
							947
							0
							temp0
							0
							81
							{Exit}
							0
							81
							{Previous}
							2
						)
					)
				)
			)
			(switch temp1
				(0
					(break)
				)
				(1
					(++ temp0)
				)
				(2
					(-- temp0)
				)
			)
		)
		(DisposeScript 753)
	)
)

