;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 315)
(include sci.sh)
(use Main)
(use butte)
(use eRS)
(use Sq4Feature)
(use Polygon)
(use LoadMany)
(use Motion)
(use System)

(public
	rm315 0
)

(local
	[local0 14] = [59 0 118 52 120 79 96 91 51 99 0 101 0 0]
	[local14 34] = [0 119 67 119 72 125 116 125 119 129 161 129 220 119 251 109 251 102 267 94 277 89 240 72 192 15 192 0 319 0 319 189 0 189]
)

(instance rm315 of SQRoom
	(properties
		picture 315
		horizon 15
		north 305
		west 310
	)

	(method (init)
		(LoadMany rsVIEW 0 303 300)
		(Load rsSOUND 52)
		(if (> (butte policeLanded:) 0)
			(Load rsVIEW 305)
			(Load rsPIC 300)
		else
			(LoadMany rsVIEW 7 5)
		)
		(self setRegions: 703) ; butte
		(theRoom init:)
		(switch gPrevRoomNum
			(north
				(HandsOn)
				(butte entered315: (+ (butte entered315:) 1))
				(self setScript: enterScript style: 13)
			)
			(west
				(HandsOn)
				(self style: 12)
			)
			(else
				(HandsOn)
				(gEgo view: 0 posn: 155 110)
			)
		)
		(poly1 points: @local0 size: 7)
		(poly2 points: @local14 size: 17)
		(self addObstacle: poly1 poly2)
		(gEgo setPri: 8 init:)
		(super init:)
		(if
			(or
				(== (butte curPolice1Room:) 315)
				(== (butte curPolice2Room:) 315)
			)
			(butte junctioned: 1)
			((ScriptID 703 4) posn: 150 110 init: setScript: copEnters) ; cop
		else
			(butte junctioned: 0)
		)
	)

	(method (doit &tmp temp0)
		(cond
			(script)
			((and (== script fallScript) (== (gEgo edgeHit:) 3)) 0)
			((== (gEgo edgeHit:) 1)
				(HandsOff)
				(self setScript: exitScript)
			)
		)
		(super doit:)
		(= temp0 (gEgo onControl: 1))
		(cond
			(script)
			((and (butte junctioned:) (not ((ScriptID 703 4) script:))) ; cop
				(cond
					((== (butte oldPoliceRoom:) 305)
						((ScriptID 703 4) posn: 150 -5) ; cop
					)
					((== (butte oldPoliceRoom:) 310)
						((ScriptID 703 4) posn: -5 110) ; cop
					)
				)
				((ScriptID 703 4) init:) ; cop
				((ScriptID 703 4) setScript: copEnters) ; cop
			)
			(
				(or
					(& temp0 $0004)
					(& temp0 $0010)
					(& temp0 $0040)
					(& temp0 $0080)
					(& temp0 $0100)
					(& temp0 $0200)
				)
				(HandsOff)
				(self setScript: fallScript 0 temp0)
			)
			((and (butte sawShadow:) (< 48 (gEgo y:) 51) (not (IsFlag 32)))
				(butte beenCaptured: 1)
				(self setScript: pteraDives)
			)
		)
	)
)

(instance fallScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(cond
					((& register $0004)
						(gEgo setPri: 1)
					)
					((& register $0010)
						(gEgo setPri: 6)
					)
					(else
						(gEgo setPri: 3)
					)
				)
				(gCurRoom setScript: (ScriptID 703 1)) ; butteFallScript
				(self dispose:)
			)
		)
	)
)

(instance enterScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					x:
						(cond
							((< (gEgo x:) 112) 112)
							((> (gEgo x:) 214) 214)
							(else
								(gEgo x:)
							)
						)
					y: 50
				)
				(= cycles 1)
			)
			(1
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance exitScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo (gEgo x:) -2 self)
			)
			(1
				(gCurRoom newRoom: (gCurRoom north:))
			)
		)
	)
)

(instance ptera of Sq4Actor
	(properties
		x 220
		y -40
		yStep 15
		view 303
		priority 15
		signal 24592
		xStep 35
		lookStr 1 ; "I don't know what that is, but I see the need for a bunion pad or two. Maybe some pumice would help."
	)
)

(instance pteraDives of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ptera
					x: (+ (gEgo x:) 40)
					init:
					setMotion: pteraChase gEgo 5 self
				)
			)
			(1
				(gLongSong number: 52 loop: -1 vol: 127 flags: 1 playBed:)
				(HandsOff)
				(gEgo hide:)
				(ptera x: (+ (ptera x:) 28) setCel: 1)
				(= cycles 2)
			)
			(2
				(ptera x: (- (ptera x:) 35) setCel: 2)
				(= cycles 2)
			)
			(3
				(ptera xStep: 10 setMotion: MoveTo -20 -60 self)
			)
			(4
				(ptera dispose:)
				(gCurRoom newRoom: 298)
				(client setScript: 0)
			)
		)
	)
)

(class pteraChase of Motion
	(properties
		who 0
		distance 0
	)

	(method (init param1 param2 param3 param4)
		(if (>= argc 1)
			(= client param1)
			(if (>= argc 2)
				(= who param2)
				(if (>= argc 3)
					(= distance param3)
					(if (>= argc 4)
						(= caller param4)
					)
				)
			)
		)
		(super init: client (who x:) (- (who y:) 55) caller)
	)

	(method (onTarget)
		(return
			(and
				(<= (Abs (- (client x:) (who x:))) distance)
				(<= (Abs (- (client y:) (- (who y:) 55))) distance)
			)
		)
	)

	(method (doit)
		(if (self onTarget:)
			(self moveDone:)
		else
			(super doit:)
			(if (== b-moveCnt 0)
				(super init: client (who x:) (- (who y:) 55) caller)
			)
		)
	)
)

(instance copEnters of Script
	(properties)

	(method (doit)
		(if (and (not (gCurRoom script:)) (== state 0))
			(self cue:)
		)
		(if
			(and
				(< ((ScriptID 703 4) distanceTo: gEgo) 80) ; cop
				(not (gCurRoom script:))
			)
			((ScriptID 703 4) setScript: (ScriptID 703 5)) ; cop, shootEgoScript
			(self dispose:)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0 0)
			(1
				((ScriptID 703 4) setCycle: Walk setMotion: MoveTo 150 110 self) ; cop
			)
			(2
				((ScriptID 703 4) ; cop
					setMotion: MoveTo (gEgo x:) (gEgo y:) self
				)
			)
		)
	)
)

(instance poly1 of Polygon
	(properties)
)

(instance poly2 of Polygon
	(properties)
)

(instance theRoom of Sq4Feature
	(properties
		nsBottom 200
		nsRight 320
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				((ScriptID 703 6) doVerb: theVerb) ; theRoom
			)
			(1 ; Look
				(gNarrator say: 2) ; "The hot sun and the butte's seductive curves are strangely exciting. You've reached the "plateau phase" which continues to the west, while the rocky layers climax in a makeshift staircase. In the distance, you can see the beautiful, tranquil Sea of Estros."
			)
			(else
				(super doVerb:)
			)
		)
	)
)

