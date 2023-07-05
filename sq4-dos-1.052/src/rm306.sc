;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 306)
(include sci.sh)
(use Main)
(use Interface)
(use butte)
(use eRS)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Motion)
(use System)

(public
	rm306 0
)

(instance rm306 of SQRoom
	(properties
		picture 306
		horizon 15
		north 299
		east 310
	)

	(method (init)
		(LoadMany rsVIEW 0 300)
		(if (> (butte policeLanded:) 0)
			(Load rsVIEW 305)
			(Load rsPIC 300)
		else
			(LoadMany rsVIEW 7 5)
		)
		(self setRegions: 703 setFeatures: theRoom) ; butte
		(gEgo
			illegalBits: 0
			setPri:
				(cond
					((== gPrevRoomNum north) 4)
					((> (gEgo y:) 115) 15)
					(else 8)
				)
			init:
		)
		(switch gPrevRoomNum
			(north
				(HandsOff)
				(self setScript: enterScript style: 42)
			)
			(east
				(HandsOff)
				(self style: 40 setScript: enterScript)
			)
			(else
				(HandsOn)
				(gEgo posn: 181 135)
			)
		)
		(super init:)
		(butte junctioned: 0)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 202 0 252 52 189 101 193 114 136 109 88 67 148 0
					yourself:
				)
				((Polygon new:)
					type: PNearestAccess
					init: 111 0 112 37 95 46 82 71 95 99 74 118 82 124 93 124 125 141 202 143 253 149 283 140 301 139 319 135 319 189 0 189 0 0
					yourself:
				)
				((Polygon new:)
					type: PNearestAccess
					init: 319 52 319 94 269 99 255 124 197 115 197 105 268 48
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 319 124 274 115 272 101 319 103
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 285 0 319 0 319 22 285 14
					yourself:
				)
		)
		(if
			(or
				(== (butte curPolice1Room:) 306)
				(== (butte curPolice2Room:) 306)
			)
			(butte junctioned: 1)
			(copEnters start: 3)
			((ScriptID 703 4) ; cop
				posn: 132 131
				setCycle: Walk
				init:
				setScript: copEnters
			)
		else
			(butte junctioned: 0)
		)
	)

	(method (doit &tmp temp0)
		(cond
			(script)
			((and (== script fallScript) (== (gEgo edgeHit:) 3)) 0)
			((and (not script) (== (gEgo edgeHit:) 1))
				(HandsOff)
				(self setScript: exitScript)
			)
		)
		(super doit:)
		(= temp0 (gEgo onControl: 1))
		(cond
			(script)
			((and (butte junctioned:) (not ((ScriptID 703 4) script:))) ; cop
				((ScriptID 703 4) setScript: copEnters) ; cop
			)
			(
				(or
					(& temp0 $0010)
					(& temp0 $0020)
					(& temp0 $0040)
					(& temp0 $0080)
					(& temp0 $0100)
					(& temp0 $0002)
				)
				(HandsOff)
				(self setScript: fallScript 0 temp0)
			)
		)
		(cond
			(script)
			((and (< (gEgo x:) 167) (< (gEgo y:) 67))
				(gEgo setPri: 4)
			)
			((and (> (gEgo x:) 270) (> (gEgo y:) 113))
				(gEgo setPri: 11)
			)
			(else
				(gEgo setPri: 8)
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
					((& register $0002)
						(gEgo setPri: 15)
					)
					((& register $0010) 0)
					((& register $0020)
						(gEgo setPri: 3)
					)
					((& register $0040)
						(gEgo setPri: 2)
					)
					((& register $0080)
						(gEgo x: (- (gEgo x:) 7) setPri: 1)
					)
					((& register $0100)
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
				(cond
					((== gPrevRoomNum 299)
						(if (< (gEgo x:) 190)
							(gEgo x: 120 y: 30 setMotion: MoveTo 99 50 self)
						else
							(gEgo
								x: (gEgo x:)
								y: -5
								setMotion: MoveTo (+ (gEgo x:) 23) 30 self
							)
						)
					)
					((< 75 (gEgo y:) 110)
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
							setMotion: MoveTo 283 99 self
						)
					)
					(else
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
				)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance exitScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo (gEgo x:) -3 self)
			)
			(1
				(gCurRoom newRoom: (gCurRoom north:))
			)
		)
	)
)

(instance copEnters of Script
	(properties)

	(method (doit)
		(if
			(and
				(< ((ScriptID 703 4) distanceTo: gEgo) 80) ; cop
				(not (gCurRoom script:))
				state
			)
			((ScriptID 703 4) setScript: (ScriptID 703 5)) ; cop, shootEgoScript
			(self dispose:)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== (butte oldPoliceRoom:) 299)
					((ScriptID 703 4) posn: 121 50) ; cop
				)
				((ScriptID 703 4) ; cop
					setPri: 4
					init:
					illegalBits: 0
					setCycle: Walk
					setMotion: PolyPath 101 57 self
				)
			)
			(1
				((ScriptID 703 4) setPri: 8 setMotion: PolyPath 97 78 self) ; cop
			)
			(2
				((ScriptID 703 4) setMotion: PolyPath 132 131 self) ; cop
			)
			(3
				((ScriptID 703 4) ; cop
					setMotion: PolyPath (gEgo x:) (gEgo y:) self
				)
			)
		)
	)
)

(instance theRoom of Feature
	(properties
		nsBottom 200
		nsRight 320
		description {buttes}
		lookStr {You're surrounded by spires of sand and rock.  Over the years, the ravages of wind, water and time have exposed strata in the butte which seem to serve nicely as steps.   Far below, the serene and tempting Sea of Estros beckons to you.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Talk
				((ScriptID 703 6) doVerb: theVerb) ; theRoom
			)
			(1 ; Look
				(Print 306 0) ; "You're surrounded by spires of sand and rock. Over the years, the ravages of wind, water and time have exposed strata in the butte which seem to serve nicely as steps.  Far below, the serene and tempting Sea of Estros beckons to you."
			)
			(else
				(super doVerb:)
			)
		)
	)
)

