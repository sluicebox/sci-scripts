;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 610)
(include sci.sh)
(use Main)
(use BalloonTalker)
(use Print)
(use ForwardCounter)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm610 0
	pTalker 1
	ljTalker 2
)

(local
	local0
	local1
	local2
)

(instance rm610 of Rm
	(properties)

	(method (init)
		(gTheIconBar disable:)
		(SetFlag 2)
		(super init: &rest)
		(Graph grFILL_BOX 0 0 192 320 2 0)
		(gCurRoom overlay: 610)
		(Load rsVIEW 610)
		(gLongSong number: 941 setLoop: 1 play:)
		(flag init: stopUpd:)
		(if
			(and
				global108
				(not
					(OneOf gPrevRoomNum 380 382 370 390 410 400 360 350 250 212) ; Maze
				)
			)
			(= gPrevRoomNum 380)
		)
		(if (not global199)
			(= global199 8)
		)
		(if (OneOf gPrevRoomNum 210 250 350 360 212 370 380 400 410 382) ; Maze
			(cond
				((== gPrevRoomNum 380)
					(switch global199
						(8
							(= local0 370)
						)
						(10
							(= local0 390)
						)
						(11
							(= local0 390)
						)
						(9
							(= local0 370)
						)
						(else
							(= local0 380)
						)
					)
				)
				((== gPrevRoomNum 410)
					(= local0 400)
				)
				(else
					(= local0 gPrevRoomNum)
				)
			)
		)
		(gCurRoom setScript: animationScr)
	)
)

(instance flag of Prop
	(properties
		x 158
		y 114
		view 610
		priority 14
		signal 16
	)
)

(instance pepperGal of Actor
	(properties
		x 85
		y 146
		view 611
		priority 15
		signal 16
	)
)

(instance dogie of Actor
	(properties
		x 196
		y 147
		view 611
		loop 1
		priority 15
		signal 16
	)
)

(instance animationScr of Script
	(properties)

	(method (init)
		(super init: &rest)
		(if local0
			(= register local0)
		)
	)

	(method (doit)
		(super doit:)
		(cond
			((and (== (gLongSong prevSignal:) 10) (not local1))
				(= local1 1)
				(self cue:)
			)
			((and (== (gLongSong prevSignal:) 20) (not local2))
				(= local2 1)
				(self cue:)
			)
		)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
			)
			(1
				(flag cycleSpeed: 8 setCycle: End)
			)
			(2
				(pepperGal init: setCycle: End self)
				(dogie init: setCycle: End self)
			)
			(3)
			(4
				(flag stopUpd: forceUpd:)
				(= cycles 2)
			)
			(5
				(gMessager say: 1 0 global199 1 2 self)
			)
			(6
				(pepperGal view: 613 setLoop: 0 cel: 0 setCycle: End self)
				(dogie view: 612 setLoop: 0 cel: 0 setCycle: End self)
			)
			(7)
			(8
				(pepperGal setLoop: 1 cel: 0 setCycle: Beg self)
				(dogie setLoop: 1 cel: 0)
				(gMessager say: 1 0 global199 3 self)
			)
			(9)
			(10
				(dogie setCycle: ForwardCounter 2)
				(gMessager say: 1 0 global199 4 self)
			)
			(11
				(pepperGal stopUpd:)
				(dogie setCycle: 0 stopUpd:)
				(= ticks 60)
			)
			(12
				(gGame setCursor: 999 1)
				(SetCursor 96 32)
				(repeat
					(switch
						(= temp0
							((Print new:)
								x: 54
								y: 11
								width: 200
								font: gUserFont
								addText: {Select your destination...}
								addButton: 1 {Try again!} 0 12
								addButton: 2 {Restore} 70 12
								addButton: 3 {Quit} 125 12
								init:
							)
						)
						(1
							(= cycles 1)
						)
						(2
							(if (gGame restore:)
								(-- state)
								(= cycles 2)
							)
						)
						(3
							(= gQuit 1)
							(self dispose:)
						)
					)
					(if temp0
						(break)
					)
				)
			)
			(13
				(gTheIconBar enable:)
				(ClearFlag 2)
				(gCurRoom newRoom: register)
			)
		)
	)
)

(instance pTalker of BalloonTalker
	(properties
		x 135
		y 70
		talkWidth 155
	)
)

(instance ljTalker of BalloonTalker
	(properties
		x 195
		y 100
		talkWidth 95
		font 61
	)
)

