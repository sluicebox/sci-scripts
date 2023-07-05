;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 300)
(include sci.sh)
(use Main)
(use Interface)
(use butte)
(use SQRoom)
(use Polygon)
(use Feature)
(use LoadMany)
(use Motion)
(use Actor)
(use System)

(public
	rm300 0
)

(local
	[local0 12] = [130 52 159 83 115 84 59 95 46 81 46 70]
	[local12 18] = [0 0 319 0 319 65 146 65 136 45 40 65 40 82 23 91 0 92]
	[local30 20] = [319 189 286 189 239 152 221 137 198 133 191 124 176 121 154 95 162 88 319 88]
	[local50 22] = [0 189 0 103 16 96 49 94 61 99 87 99 105 109 98 124 104 133 95 151 129 189]
	[local72 12] = [130 52 140 70 94 78 70 87 46 81 46 70]
)

(instance rm300 of SQRoom
	(properties
		picture 300
		east 305
		south 310
		west 299
	)

	(method (init)
		(LoadMany rsVIEW 0 300)
		(if (not (butte sawShadow:))
			(Load rsVIEW 301)
		)
		(self setRegions: 703 setFeatures: theStairs theRoom) ; butte
		(gEgo setPri: 8)
		(switch gPrevRoomNum
			(south
				(HandsOn)
				(self style: 43 setScript: enterScript)
			)
			(east
				(HandsOn)
				(self style: 40)
				(gEgo
					y:
						(cond
							((< (gEgo y:) 67) 67)
							((> (gEgo y:) 88) 88)
							(else
								(gEgo y:)
							)
						)
					setHeading: 270 self
				)
			)
			(west
				(HandsOff)
				(self style: 41 setScript: enterScript)
			)
			(else
				(HandsOn)
				(gEgo view: 0 illegalBits: 0 posn: 150 79)
			)
		)
		(poly1 points: @local72 size: 6)
		(poly2 points: @local12 size: 9)
		(poly3 points: @local30 size: 10)
		(poly4 points: @local50 size: 11)
		(poly5 points: @local0 size: 6)
		(self addObstacle: poly2 poly3 poly4)
		(gEgo init:)
		(super init:)
		(if (not (butte onLedgeFlag:))
			(gEgo illegalBits: 0)
		)
		(if (< (butte policeLanded:) 0)
			(LoadMany rsVIEW 305 7 5)
			(self addObstacle: poly5)
			(policePod cel: 10 init: stopUpd:)
			(if
				(or
					(== (butte curPolice1Room:) 300)
					(== (butte curPolice2Room:) 300)
				)
				(butte junctioned: 1)
				((ScriptID 703 4) posn: 147 90 init: setScript: copEnters) ; cop
			else
				(butte junctioned: 0)
			)
		else
			(self addObstacle: poly1)
		)
	)

	(method (doit &tmp temp0)
		(cond
			(script 0)
			((== (gEgo edgeHit:) 3)
				(HandsOff)
				(self setScript: exitSouthScript)
			)
			((== (gEgo edgeHit:) 2)
				(HandsOff)
				(self setScript: exitEastScript)
			)
		)
		(super doit:)
		(= temp0 (gEgo onControl: 1))
		(cond
			(script)
			((and (not (butte sawShadow:)) (& temp0 $0800))
				(if (IsObject policePod)
					(policePod setPri: 15)
				)
				(gEgo setPri: 15)
				(butte sawShadow: (+ (butte sawShadow:) 1))
				(HandsOff)
				(gCurRoom overlay: 301 100)
				(self setScript: shadowScript)
			)
			((and (butte junctioned:) (not ((ScriptID 703 4) script:))) ; cop
				(cond
					((== (butte oldPoliceRoom:) 305)
						((ScriptID 703 4) posn: 330 76) ; cop
					)
					((== (butte oldPoliceRoom:) 310)
						((ScriptID 703 4) posn: 179 250) ; cop
					)
					((== (butte oldPoliceRoom:) 299)
						((ScriptID 703 4) posn: 0 95) ; cop
					)
				)
				((ScriptID 703 4) init:) ; cop
				((ScriptID 703 4) setScript: copEnters) ; cop
			)
			(
				(or
					(& temp0 $0004)
					(& temp0 $0200)
					(& temp0 $0010)
					(& temp0 $2000)
					(and (& temp0 $0008) (not (butte onLedgeFlag:)))
					(and (& temp0 $0020) (butte onLedgeFlag:))
				)
				(HandsOff)
				(self setScript: fallScript 0 temp0)
			)
		)
	)
)

(instance fallScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((& register $0200) 0)
					((& register $0010)
						(gEgo setPri: 4)
					)
					((& register $0008)
						(gEgo setPri: 4)
					)
					((& register $0020)
						(gEgo setPri: 13)
					)
					((& register $2000)
						(gEgo
							x:
								(if (> (gEgo x:) 150)
									(+ (gEgo x:) 7)
								else
									(- (gEgo x:) 7)
								)
							setPri: 4
						)
					)
					((& register $0004)
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
						(gEgo posn: 8 94 setMotion: MoveTo 37 94 self)
					)
					((butte onLedgeFlag:)
						(gEgo illegalBits: -32704 setPri: 15)
						(self cue:)
					)
					(else
						(self cue:)
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

(instance exitSouthScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(if (butte onLedgeFlag:)
					(gCurRoom newRoom: (gCurRoom south:))
				else
					(gEgo setMotion: MoveTo 180 250 self)
				)
			)
			(1
				(gCurRoom newRoom: (gCurRoom south:))
			)
		)
	)
)

(instance exitEastScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gEgo setHeading: 90 setMotion: MoveTo 335 (gEgo y:) self)
			)
			(1
				(gCurRoom newRoom: (gCurRoom east:))
			)
		)
	)
)

(instance policePod of View
	(properties
		x 149
		y 83
		description {time pod}
		lookStr {What's this? It looks like we've got company here and it's probably not native. Must be those armed tough guys you met on Magmetheus.}
		view 305
		loop 1
		priority 5
		signal 16400
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
				((ScriptID 703 4) setCycle: Walk setMotion: MoveTo 147 90 self) ; cop
			)
			(2
				((ScriptID 703 4) ; cop
					setMotion: MoveTo (gEgo x:) (gEgo y:) self
				)
			)
		)
	)
)

(instance ptera of Actor
	(properties
		x 200
		y 68
		view 301
		priority 6
		signal 16400
	)
)

(instance shadowScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setHeading: 44)
				(ptera
					illegalBits: 0
					init:
					cycleSpeed: 1
					setMotion: MoveTo 257 97 self
				)
			)
			(1
				(gEgo setHeading: 90)
				(ptera setMotion: MoveTo 314 126 self)
			)
			(2
				(ptera posn: (+ (ptera x:) 50) (ptera y:))
				(ptera dispose:)
				(gEgo setHeading: 136)
				(= cycles 2)
			)
			(3
				(Print 300 0 #at 5 160 #dispose) ; "Whoaahhh! What was that?!"
				(gCurRoom drawPic: 300 100)
				(if (IsObject policePod)
					(policePod setPri: 5)
				)
				(gEgo setPri: 8)
				(= seconds 2)
			)
			(4
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance poly1 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly2 of Polygon
	(properties)
)

(instance poly3 of Polygon
	(properties)
)

(instance poly4 of Polygon
	(properties)
)

(instance poly5 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance theStairs of Feature
	(properties
		nsBottom 200
		nsRight 320
		description {stairs}
		onMeCheck 16384
		lookStr {Sedimentary layers of rock form a stairway which winds its way down below.}
	)
)

(instance theRoom of Feature
	(properties
		nsBottom 200
		nsRight 320
		description {buttes}
		lookStr {From way up here, the view is simply gorges and steep rocky hills.  The giant sun of Estros mercilessly pounds sand all around you, until you can feel the heat through the soles of your boots.}
	)
)

