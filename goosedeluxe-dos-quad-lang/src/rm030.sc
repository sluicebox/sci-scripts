;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 30)
(include sci.sh)
(use Main)
(use MGRoom)
(use MoveProp)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Actor)
(use System)

(public
	rm030 0
)

(instance rm030 of MGRoom
	(properties
		picture 30
		north 23
		east 31
		west 29
		edgeN 43
		edgeS 255
	)

	(method (init)
		(= global305 outCode)
		(Load rsVIEW 163)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 95 94 94 129 92 141 91 169 93 175 98 175 111 185 123 196 129 243 129 315 127 315 196 0 196
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 315 115 228 114 233 99 315 71
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 136 40 40 49 0 57 0 0 136 0
					yourself:
				)
		)
		(proc0_1)
		((MoveProp new:) init: 163 0 72 115 13 yourself:)
		((MoveProp new:) init: 163 1 71 127 13 yourself:)
		((MoveProp new:) init: 163 2 112 144 13 yourself:)
		((MoveProp new:) init: 163 3 114 126 13 yourself:)
		((MoveProp new:) init: 163 4 238 150 13 yourself:)
		((MoveProp new:) init: 163 5 181 142 13 yourself:)
		(if
			(and
				(!= [global200 gCurRoomNum] 45)
				(!= [global200 gCurRoomNum] 44)
				(!= global130 45)
				(!= global130 44)
				(not global523)
			)
			(dummyProp init: setScript: cricketOrBirdScript)
		)
		(switch gPrevRoomNum
			(north
				(gEgo posn: (proc0_13 150 (gEgo x:) (gCurRoom edgeE:)) 40)
				(self setScript: gStdClimbIn)
			)
			(west
				(gEgo posn: 36 (proc0_13 66 (gEgo y:) 96))
				(self setScript: gStdWalkIn)
			)
			(east
				(gEgo
					posn: 231 (proc0_13 54 (proc0_14 92 (gEgo y:) 115) 131)
				)
				(self setScript: gStdWalkIn)
			)
			(45 ; mapRoom
				(gEgo init:)
				(gGame handsOn:)
			)
			(else
				(gEgo posn: 150 90 init:)
				(gGame handsOn:)
			)
		)
		(proc0_8 110 60)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((== (gEgo edgeHit:) EDGE_TOP)
				(if global523
					(vDialog init:)
					(hsDialogArea init:)
					(gEgo
						y: (+ (self edgeN:) 1)
						setMotion: PolyPath (gEgo x:) (+ (self edgeN:) 2) 0 0
					)
				else
					(self setScript: gStdClimbOut 0 1)
				)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(self setScript: gStdWalkOut 0 (gEgo edgeHit:))
			)
		)
	)

	(method (dispose &tmp temp0)
		(super dispose:)
	)
)

(instance dummyProp of Prop
	(properties
		x -10
		y -10
		view 895
		cel 7
	)
)

(instance hsDialogArea of Feature
	(properties
		nsRight 320
		nsBottom 200
	)

	(method (init)
		(super init: &rest)
		(gMouseDownHandler addToFront: self)
	)

	(method (handleEvent event)
		(event localize: gThePlane)
		(if (and (& (event type:) evMOUSEBUTTON) (self onMe: event))
			(event claimed: 1)
			(vDialog dispose:)
			(gMouseDownHandler delete: self)
			(self dispose:)
		)
		(super handleEvent: event &rest)
	)
)

(instance vDialog of View
	(properties
		x 60
		y 30
		priority 250
		fixPriority 1
		view 923
	)
)

(instance cricketOrBirdSound of Sound
	(properties)
)

(instance cricketOrBirdScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (Random 360 600))
			)
			(1
				(if
					(or
						(not (gUser controls:))
						(gCurRoom script:)
						(!= (DoAudio audPOSITION) -1)
					)
					(= cycles 1)
				else
					(= ticks
						(+
							4
							(cricketOrBirdSound
								number:
									(if (Random 0 1)
										35
									else
										(Random 574 577)
									)
								play:
							)
						)
					)
				)
			)
			(2
				(self init:)
			)
		)
	)
)

(instance outCode of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(switch gTheCursor
			(5
				(= temp0 (proc0_13 164 (gEgo x:) 234))
				(= temp1 43)
			)
			(2
				(= temp0 264)
				(= temp1 (proc0_13 44 (proc0_14 87 (gEgo y:) 116) 128))
			)
			(3
				(= temp0 (proc0_13 106 (gEgo x:) 250))
				(= temp1 134)
			)
			(4
				(= temp0 -1)
				(= temp1 (proc0_13 58 (gEgo y:) 93))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0 0)
	)
)

