;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 299)
(include sci.sh)
(use Main)
(use eRS)
(use Print)
(use System)

(public
	rm299 0
)

(local
	[local0 200]
	[local200 4]
)

(procedure (localproc_0 param1 param2 param3 param4)
	(Display param1 dsCOORD param2 param3 dsALIGN alCENTER dsFONT 3 dsCOLOR 7 dsWIDTH param4)
)

(instance rm299 of PQRoom
	(properties
		noun 1
		picture 99
	)

	(method (init)
		(super init:)
		(gLongSong number: 162 loop: -1 flags: -1 play:)
		(self setScript: startUp)
	)
)

(instance startUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gGame setCursor: 996)
				(gTheIconBar disable:)
				(SetFlag 1)
				(= global250 996)
				(= seconds 2)
			)
			(1
				(if (Message msgGET 299 1 0 0 (++ register) @local0)
					(TextSize @local200 @local0 3)
					(localproc_0
						@local0
						(- 160 (/ [local200 3] 2))
						(- 100 (/ [local200 2] 2))
						[local200 3]
					)
					(= seconds 6)
				else
					(+= state 2)
					(= cycles 1)
				)
			)
			(2
				(= seconds 5)
			)
			(3
				(Graph grFILL_BOX 0 0 189 319 1 0 -1 -1)
				(Graph grUPDATE_BOX 0 0 189 319 1)
				(-= state 3)
				(= cycles 2)
			)
			(4
				(gLongSong fade: self)
			)
			(5
				(= gQuit 1)
			)
		)
	)
)

(instance endGame of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(repeat
					(switch
						(Print
							mode: 1
							addButton: 1 1 0 4 0 10 0 200 ; "Restore"
							addButton: 2 1 0 39 0 70 0 200 ; "Restart"
							addButton: 3 1 0 5 0 135 0 200 ; "Quit"
							init:
						)
						(1
							(gGame restore:)
						)
						(2
							(gGame restart: 1)
						)
						(3
							(= gQuit 1)
							(break)
						)
					)
				)
			)
		)
	)
)

