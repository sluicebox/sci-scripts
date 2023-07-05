;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 310)
(include sci.sh)
(use Main)
(use butte)
(use MoveToY)
(use eRS)
(use Sq4Feature)
(use PolyPath)
(use Polygon)
(use LoadMany)
(use Motion)
(use System)

(public
	rm310 0
)

(instance rm310 of SQRoom
	(properties
		picture 310
		horizon 15
		north 300
		east 315
		south 320
		west 306
	)

	(method (init)
		(LoadMany rsVIEW 0 300)
		(if (> (butte policeLanded:) 0)
			(Load rsVIEW 305)
			(Load rsPIC 300)
		else
			(LoadMany rsVIEW 7 5)
		)
		(switch gPrevRoomNum
			(north
				(HandsOff)
				(self setScript: enterScript style: 13)
			)
			(south
				(HandsOff)
				(self setScript: enterScript style: 14)
				(gEgo illegalBits: 0 setPri: 6)
			)
			(east
				(self setScript: enterScript style: 11)
				(gEgo
					setPri: 13
					cel: 4
					x: 305
					y:
						(if (< (gEgo y:) 103)
							103
						else
							(gEgo y:)
						)
				)
			)
			(west
				(if (< (gEgo y:) 110)
					(gEgo setPri: 12)
				else
					(gEgo setPri: 14)
				)
				(self style: 12 setScript: enterScript)
			)
			(else
				(gEgo illegalBits: 0 posn: 155 92 setPri: 6)
				(HandsOn)
			)
		)
		(if
			(and
				(== gPrevRoomNum 300)
				(not (butte sawGirlShadow:))
				(not (IsFlag 32))
			)
			(shadow init: setScript: shadowMoves)
		)
		(gEgo init:)
		(super init:)
		(if (or (== gPrevRoomNum 300) (== gPrevRoomNum 320))
			(self
				addObstacle:
					((Polygon new:)
						type: PNearestAccess
						init: 157 0 157 11 128 13 124 30 89 49 60 78 69 94 109 107 195 175 199 189 0 189 0 0
						yourself:
					)
					((Polygon new:)
						type: PNearestAccess
						init: 319 0 319 189 273 189 259 173 265 150 236 105 185 76 185 46 225 41 278 12 280 0
						yourself:
					)
			)
			(theBridge init:)
			(theRoom init:)
		else
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 0 102 34 105 32 115 0 123
						yourself:
					)
					((Polygon new:)
						type: PNearestAccess
						init: 319 189 0 189 0 129 20 123 44 121 55 112 54 104 21 95 0 94 0 43 17 41 57 21 167 0 319 0 319 100 272 103 260 106 196 116 180 128 162 136 155 145 213 141 236 152 226 159 259 158 287 154 285 149 227 145 226 135 288 123 319 120
						yourself:
					)
			)
			(theStairs init:)
			(theRoom init:)
			(gEgo illegalBits: -32768)
		)
		(cond
			((== (butte curPolice1Room:) 310)
				(butte junctioned: 1)
				((ScriptID 703 4) ; cop
					loop: 1
					setPri: 13
					posn: 240 120
					init:
					setScript:
						(cond
							((or (== gPrevRoomNum 300) (== gPrevRoomNum 320)) copOnLedge)
							((== gPrevRoomNum 306) egoOnLedge)
							(else copEnters)
						)
				)
			)
			((== (butte curPolice2Room:) 310)
				(butte junctioned: 1)
				((ScriptID 703 4) ; cop
					posn: 136 70
					setPri: 8
					init:
					loop: (if (== (butte oldPoliceRoom:) 320) 3 else 2)
					setScript:
						(if (or (== gPrevRoomNum 300) (== gPrevRoomNum 320))
							copEnters
						else
							copOnStairs
						)
				)
			)
			(else
				(butte junctioned: 0)
			)
		)
		(self setRegions: 703) ; butte
	)

	(method (doit &tmp temp0)
		(cond
			(script)
			((== (gEgo edgeHit:) 1)
				(HandsOff)
				(self setScript: exitNorthScript)
			)
		)
		(super doit:)
		(= temp0 (gEgo onControl: 1))
		(cond
			(
				(and
					(== script (ScriptID 703 1)) ; butteFallScript
					(== (gEgo edgeHit:) 3)
					(< (gEgo x:) 160)
					(> (gEgo y:) 38)
				)
				(butte egoSwims: 1)
				(HandsOff)
				(self setScript: exitScript)
			)
			(script)
			((== (gEgo edgeHit:) 3)
				(HandsOff)
				(self setScript: exitScript)
			)
			((and (butte junctioned:) (not ((ScriptID 703 4) script:))) ; cop
				(cond
					((== (butte curPolice1Room:) 310)
						(cond
							((or (== gPrevRoomNum 300) (== gPrevRoomNum 320))
								((ScriptID 703 4) ; cop
									posn: 325 120
									setPri: 13
									init:
									setScript: copOnLedge
								)
							)
							((== gPrevRoomNum 306)
								((ScriptID 703 4) ; cop
									posn: 325 120
									setPri: 13
									init:
									setScript: egoOnLedge
								)
							)
							(else
								(cond
									((== (butte oldPoliceRoom:) 300)
										((ScriptID 703 4) posn: 177 0) ; cop
									)
									((== (butte oldPoliceRoom:) 315)
										((ScriptID 703 4) posn: 325 110) ; cop
									)
									((== (butte oldPoliceRoom:) 320)
										((ScriptID 703 4) posn: 195 250) ; cop
									)
								)
								((ScriptID 703 4) init: setScript: copEnters) ; cop
							)
						)
					)
					((== (butte curPolice2Room:) 310)
						(butte junctioned: 1)
						(if (or (== gPrevRoomNum 300) (== gPrevRoomNum 320))
							(cond
								((== (butte oldPoliceRoom:) 300)
									((ScriptID 703 4) posn: 177 0) ; cop
								)
								((== (butte oldPoliceRoom:) 315)
									((ScriptID 703 4) posn: 325 110) ; cop
								)
								((== (butte oldPoliceRoom:) 320)
									((ScriptID 703 4) posn: 195 250) ; cop
								)
							)
							((ScriptID 703 4) init: setScript: copEnters) ; cop
						else
							(cond
								((== (butte oldPoliceRoom:) 300)
									((ScriptID 703 4) posn: 177 0) ; cop
								)
								((== (butte oldPoliceRoom:) 320)
									((ScriptID 703 4) posn: 195 200) ; cop
								)
							)
							((ScriptID 703 4) init: setScript: copOnStairs) ; cop
						)
					)
				)
			)
			(
				(or
					(& temp0 $0002)
					(& temp0 $0004)
					(& temp0 $0040)
					(& temp0 $0080)
					(& temp0 $0008)
				)
				(if (or (== gPrevRoomNum 300) (== gPrevRoomNum 320))
					(HandsOff)
					(self setScript: fallScript 0 temp0)
				)
			)
			(
				(and
					(or
						(& temp0 $0010)
						(& temp0 $0100)
						(& temp0 $2000)
						(& temp0 $0020)
					)
					(or (== gPrevRoomNum 306) (== gPrevRoomNum 315))
				)
				(HandsOff)
				(self setScript: fallScript 0 temp0)
			)
		)
		(cond
			(script)
			((and (== gPrevRoomNum 315) (> (gEgo y:) 150))
				(gEgo setPri: 14)
			)
			((and (== gPrevRoomNum 315) (gEgo setPri: 13)))
			((and (== gPrevRoomNum 306) (> (gEgo y:) 110))
				(gEgo setPri: 14)
			)
			((and (== gPrevRoomNum 306) (gEgo setPri: 12)))
			(else 0)
		)
	)
)

(instance fallScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(cond
					((& register $0100)
						(gEgo setPri: (- (gEgo priority:) 3))
					)
					((& register $0002)
						(gEgo
							posn: (+ (gEgo x:) 7) (- (gEgo y:) 5)
							setPri: (- (gEgo priority:) 3)
						)
					)
					((& register $0004)
						(gEgo
							x: (+ (gEgo x:) 10)
							setPri: (- (gEgo priority:) 3)
						)
					)
					((& register $0040)
						(gEgo x: (- (gEgo x:) 10))
					)
					((& register $0080)
						(gEgo
							x: (- (gEgo x:) 7)
							setPri: (- (gEgo priority:) 3)
						)
					)
					((& register $0010)
						(if (< (gEgo y:) 150)
							(gEgo setPri: (- (gEgo priority:) 1))
						else
							(gEgo setPri: 15)
						)
					)
					((& register $2000)
						(gEgo
							x: (+ (gEgo x:) 6)
							setPri: (- (gEgo priority:) 1)
						)
					)
					((& register $0008)
						(gEgo
							posn: (+ (gEgo x:) 4) (- (gEgo y:) 5)
							setPri: (- (gEgo priority:) 3)
						)
					)
					((& register $0020)
						(gEgo setPri: 9)
					)
				)
				(gCurRoom setScript: (ScriptID 703 1)) ; butteFallScript
				(self dispose:)
			)
		)
	)
)

(instance exitScript of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(if (not (butte egoSwims:))
					(gEgo setHeading: 180 self)
				else
					(self cue:)
				)
			)
			(1
				(= temp0
					(CelHigh (gEgo view:) (gEgo loop:) (gEgo cel:))
				)
				(gEgo setMotion: MoveToY (+ 189 temp0) self)
			)
			(2
				(gCurRoom newRoom: (gCurRoom south:))
			)
		)
	)
)

(instance exitNorthScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (or (== gPrevRoomNum 300) (== gPrevRoomNum 320)))
					(butte onLedgeFlag: 1)
					(gEgo illegalBits: 0 setMotion: MoveTo 133 -2 self)
				else
					(gEgo
						illegalBits: 0
						setMotion: MoveTo (gEgo x:) -2 self
					)
				)
			)
			(1
				(gCurRoom newRoom: (gCurRoom north:))
			)
		)
	)
)

(instance enterScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((== gPrevRoomNum 300)
						(if (butte onLedgeFlag:)
							(butte onLedgeFlag: 0)
							(= gPrevRoomNum 306)
							(gEgo
								illegalBits: 0
								setPri: 9
								posn: (gEgo x:) 0
								setMotion: MoveTo (- (gEgo x:) 50) 17 self
							)
						else
							(gEgo
								view: 0
								illegalBits: 0
								setPri: 6
								x:
									(if (<= (gEgo x:) 203)
										(gEgo x:)
									else
										203
									)
								y: 48
								setMotion: MoveTo 180 49 self
							)
						)
					)
					((== gPrevRoomNum 320)
						(gEgo
							posn:
								(if (> (gEgo x:) 190)
									(- (gEgo x:) 5)
								else
									(+ (gEgo x:) 5)
								)
								189
							setMotion: MoveTo 192 140 self
						)
					)
					((and (== gPrevRoomNum 306) (< 75 (gEgo y:) 110))
						(gEgo
							x:
								(+
									0
									(/
										(CelWide
											(gEgo view:)
											(gEgo loop:)
											(gEgo cel:)
										)
										2
									)
								)
							setMotion: MoveTo 21 99 self
						)
					)
					((== gPrevRoomNum 315)
						(gEgo
							x:
								(-
									319
									(/
										(CelWide
											(gEgo view:)
											(gEgo loop:)
											(gEgo cel:)
										)
										2
									)
								)
						)
						(= cycles 1)
					)
					(else
						(gEgo
							x:
								(+
									0
									(/
										(CelWide
											(gEgo view:)
											(gEgo loop:)
											(gEgo cel:)
										)
										2
									)
								)
						)
						(= cycles 1)
					)
				)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance copOnStairs of Script
	(properties)

	(method (doit)
		(if (and (not (gCurRoom script:)) (== state 0))
			(self cue:)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0 0)
			(1
				((ScriptID 703 4) setCycle: Walk setMotion: MoveTo 136 70 self) ; cop
			)
			(2
				(if (== ((ScriptID 703 4) loop:) 2) ; cop
					((ScriptID 703 4) setScript: (ScriptID 703 5)) ; cop, shootEgoScript
					(self dispose:)
				else
					((ScriptID 703 4) setMotion: MoveTo 182 -1 self) ; cop
				)
			)
		)
	)
)

(instance copOnLedge of Script
	(properties)

	(method (doit)
		(if (and (not (gCurRoom script:)) (== state 0))
			(self cue:)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0 0)
			(1
				((ScriptID 703 4) ; cop
					setCycle: Walk
					setMotion: MoveTo 240 ((ScriptID 703 4) y:) self ; cop
				)
			)
			(2
				((ScriptID 703 4) ; cop
					setMotion:
						MoveTo
						((ScriptID 703 4) x:) ; cop
						(- ((ScriptID 703 4) y:) 3) ; cop
				)
				(if (and (< (gEgo y:) 140) (not (gCurRoom script:)))
					(ScriptID 703 3) ; MISSING EXPORT
					((ScriptID 703 4) setScript: (ScriptID 703 5)) ; cop, shootEgoScript
					(self dispose:)
				else
					(= cycles 1)
				)
			)
			(3
				((ScriptID 703 4) ; cop
					setMotion:
						MoveTo
						(- ((ScriptID 703 4) x:) 3) ; cop
						((ScriptID 703 4) y:) ; cop
						self
				)
			)
			(4
				((ScriptID 703 4) ; cop
					setMotion:
						MoveTo
						(+ ((ScriptID 703 4) x:) 3) ; cop
						(- ((ScriptID 703 4) y:) 3) ; cop
				)
				(if (and (< (gEgo y:) 110) (not (gCurRoom script:)))
					(ScriptID 703 3) ; MISSING EXPORT
					((ScriptID 703 4) setScript: (ScriptID 703 5)) ; cop, shootEgoScript
					(self dispose:)
				else
					(= cycles 1)
				)
			)
			(5
				((ScriptID 703 4) ; cop
					setMotion: MoveTo 330 ((ScriptID 703 4) y:) self ; cop
				)
			)
		)
	)
)

(instance egoOnLedge of Script
	(properties)

	(method (doit)
		(if (and (not (gCurRoom script:)) (== state 0))
			(self cue:)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0 0)
			(1
				1
				((ScriptID 703 4) setCycle: Walk setMotion: MoveTo 169 135 self) ; cop
			)
			(2
				2
				(if (not (gCurRoom script:))
					((ScriptID 703 4) setScript: (ScriptID 703 5)) ; cop, shootEgoScript
				)
				(self dispose:)
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
				(< ((ScriptID 703 4) distanceTo: gEgo) 60) ; cop
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
				((ScriptID 703 4) ; cop
					setCycle: Walk
					setMotion: PolyPath (gEgo x:) (gEgo y:) self
				)
			)
		)
	)
)

(instance shadow of Sq4Actor
	(properties
		x 38
		y 187
		view 310
		lookStr 1 ; "A mysterious shadow quickly moves from your view."
	)
)

(instance shadowMoves of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(if
			(and
				(not script)
				(not (gCurRoom script:))
				(== gPrevRoomNum 300)
				(not (butte sawGirlShadow:))
			)
			(butte sawGirlShadow: 1)
			(self cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0 0)
			(1
				1
				(shadow setCycle: End self)
			)
			(2
				2
				(shadow
					setMotion:
						MoveTo
						(-
							(shadow x:)
							(CelWide
								(shadow view:)
								(shadow loop:)
								(shadow cel:)
							)
						)
						(+
							(shadow y:)
							(CelHigh
								(shadow view:)
								(shadow loop:)
								(shadow cel:)
							)
						)
						self
				)
			)
			(3
				3
				(gNarrator say: 2) ; "You get the feeling you're not alone here."
				(shadow dispose:)
				(self dispose:)
			)
		)
	)
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
				(gNarrator say: 3) ; "As you look around at the towering rocks, immense formations carved over millions of years, you can't help but be overwhelmed by a sense of your own insignificance."
			)
			(else
				(super doVerb:)
			)
		)
	)
)

(instance theStairs of Sq4Feature
	(properties
		nsBottom 200
		nsRight 320
		onMeCheck 16384
		lookStr 4 ; "You see a stairway of wind-eroded rock winding its way down to the water below."
	)
)

(instance theBridge of Sq4Feature
	(properties
		nsBottom 200
		nsRight 320
		onMeCheck 2048
		lookStr 5 ; "Looking out across the expanse you see a natural bridge of rock."
	)
)

