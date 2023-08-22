;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 24)
(include sci.sh)
(use Main)
(use Interface)
(use Avoid)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room24 0
)

(synonyms
	(pool pool lake)
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10
	local11
	local12
	local13
)

(instance poofSound of Sound
	(properties
		number 59
	)
)

(instance Room24 of Rm
	(properties
		picture 24
	)

	(method (init)
		(= north 18)
		(= south 30)
		(= west 23)
		(= east 70)
		(= horizon 85)
		(= gIndoors 0)
		(gEgo edgeHit: EDGE_NONE)
		(= global205 0)
		(super init:)
		(if gNight
			(gCurRoom overlay: 124)
		)
		(self setRegions: 501 512 511 508) ; waterReg, riverReg, mountReg, Forest_Region
		(Load rsVIEW 8)
		(if (gEgo has: 10) ; Small_Crown
			(Load rsVIEW 680)
			(Load rsVIEW 370)
			(Load rsVIEW 371)
			(Load rsVIEW 372)
			(Load rsVIEW 377)
		)
		(= local9 (Prop new:))
		(= local10 (Prop new:))
		(if (== global223 2)
			(= local5 (Prop new:))
			(= local8 (Prop new:))
			(local5
				isExtra: 1
				view: 651
				loop: 0
				cel: 2
				posn: 273 30
				setPri: 0
				setCycle: Fwd
				ignoreActors:
				init:
			)
			(local8
				isExtra: 1
				view: 651
				loop: 3
				cel: 2
				posn: 251 100
				setPri: 0
				setCycle: Fwd
				ignoreActors:
				init:
			)
			(= local12 (Prop new:))
			(= local13 (Prop new:))
			(local12
				isExtra: 1
				view: 653
				loop: 1
				cel: 0
				posn: 79 151
				setPri: 0
				setCycle: Fwd
				ignoreActors:
				init:
			)
			(local13
				isExtra: 1
				view: 653
				loop: 2
				cel: 1
				posn: 107 158
				setPri: 0
				setCycle: Fwd
				ignoreActors:
				init:
			)
		)
		(= local6 (Prop new:))
		(local6
			isExtra: 1
			view: 651
			loop: 1
			cel: 3
			posn: 272 57
			setPri: 0
			setCycle: Fwd
			ignoreActors:
			init:
		)
		(= local7 (Prop new:))
		(local7
			isExtra: 1
			view: 651
			loop: 2
			cel: 2
			posn: 268 94
			setPri: 0
			setCycle: Fwd
			ignoreActors:
			init:
		)
		(local9
			isExtra: 1
			view: 651
			loop: 4
			cel: 2
			posn: 262 145
			setPri: 0
			setCycle: Fwd
			ignoreActors:
			init:
		)
		(local10
			isExtra: 1
			view: 651
			loop: 5
			cel: 2
			posn: 249 165
			setPri: 0
			setCycle: Fwd
			ignoreActors:
			init:
		)
		(switch gPrevRoomNum
			(north
				(gEgo view: 2 x: 47 y: (+ horizon (gEgo yStep:) 1))
			)
			(west
				(gEgo view: 2 x: 1)
				(if (<= (gEgo y:) horizon)
					(gEgo y: (+ horizon (gEgo yStep:) 1))
				)
			)
			(south
				(gEgo view: 2 y: 188)
				(if (> (gEgo x:) 214)
					(gEgo x: 214)
				)
			)
			(east
				(gEgo view: 8 loop: 1 posn: 207 159)
			)
			(0
				(gEgo x: 200 y: 188)
			)
		)
		(gEgo init:)
	)

	(method (doit)
		(super doit:)
		(if
			(and
				(& (gEgo onControl: 0) $0010)
				(== (gEgo view:) 8)
				(== (gEgo script:) 0)
			)
			(gEgo setScript: swept)
		)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said 'look>')
					(cond
						((Said '<in/falls')
							(Print 24 0) ; "You can't see through the waterfall."
						)
						((Said '<under/pool,water,falls')
							(if (!= (gEgo view:) 8)
								(Print 24 1) ; "You can't make out many details from here."
							else
								(Print 24 2) ; "You look under the water, but can see nothing."
							)
						)
						((Said '<in,in/water,pool')
							(Print 24 3) ; "You look into the water, but see nothing of interest."
						)
						((Said '<behind/falls')
							(Print 24 4) ; "You think you see something behind the waterfall, but you're not sure what it is."
						)
						((Said '/falls')
							(Print 24 5) ; "This is a magnificent waterfall! It tumbles into a deep pool, which then flows westward as a rushing river."
						)
						((Said '<in/pool')
							(Print 24 6) ; "You peer into the pool of water, but cannot see anything of importance."
						)
						((Said '/pool')
							(Print 24 7) ; "You see a deep pool below the waterfall."
						)
						((Said '[<around][/room]')
							(Print 24 8) ; "You see a beautiful waterfall cascading down the mountain into a deep blue pool. From the pool, a river courses westward. Around you, a dense forest closes in."
						)
					)
				)
				((Said 'enter<behind/falls')
					(Print 24 9) ; "The force of the water is too strong for you to be able to do that."
				)
				((Said 'bathe,dive<under/pool,water,falls')
					(cond
						((== (gEgo view:) 8)
							(Print 24 10) ; "You're not strong enough. The current forces you back!"
						)
						((!= (gEgo view:) 2)
							(Print 24 11) ; "The water isn't deep enough here."
						)
						(else
							(Print 24 12) ; "You'd have to be in the water to do that."
						)
					)
				)
				((Said 'bathe,dive,wade')
					(cond
						((== (gEgo view:) 2)
							(Print 24 13) ; "Just enter the water."
						)
						((== (gEgo view:) 8)
							(Print 24 14) ; "You are already swimming."
						)
						(else
							(Print 24 15) ; "You are already in the water."
						)
					)
				)
				((Said 'wear,place/crown')
					(if (gEgo has: 10) ; Small_Crown
						(if (== (gEgo view:) 2)
							(gEgo setScript: egoFrogActions)
							(egoFrogActions changeState: 1)
							(if (== global200 0)
								(gGame changeScore: 5)
								(= global200 1)
							)
						else
							(Print 24 16) ; "Not while you're IN the water."
						)
					else
						(DontHave) ; "You don't have it."
					)
				)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(gEgo viewer: 0)
		(super newRoom: newRoomNumber)
	)
)

(instance egoFrogActions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(HandsOff)
				(gEgo setMotion: 0)
				(poofSound play:)
				(= local1 (Prop new:))
				(local1
					posn: (gEgo x:) (gEgo y:)
					setPri: (+ (gEgo priority:) 1)
					view: 680
					cel: 0
					loop: 0
					ignoreActors:
					setCycle: CT 5 1 self
					init:
				)
			)
			(2
				(local1 setCycle: End self)
				(gEgo view: 370 setCycle: Fwd setMotion: 0)
			)
			(3
				(Timer setReal: self 3)
				(local1 dispose:)
			)
			(4
				(gEgo view: 372 setCycle: Walk setAvoider: Avoid)
				(gEgo viewer: frogViewer)
				(cond
					(
						(or
							(gEgo inRect: 0 84 54 137)
							(gEgo inRect: 0 84 78 96)
						)
						(gEgo setMotion: MoveTo 38 (gEgo y:) self)
					)
					((gEgo inRect: 53 95 155 115)
						(gEgo setMotion: MoveTo 64 (gEgo y:) self)
					)
					((gEgo inRect: 0 115 229 148)
						(gEgo setMotion: MoveTo 151 (gEgo y:) self)
					)
					((gEgo inRect: 0 137 79 168)
						(gEgo setMotion: MoveTo 63 164 self)
						(self changeState: 10)
					)
					((> (gEgo y:) 171)
						(self changeState: 10)
					)
					(else
						(self changeState: 20)
					)
				)
			)
			(5
				(gEgo setMotion: MoveTo 151 141 self)
			)
			(6
				(gEgo setMotion: MoveTo 193 166 self)
			)
			(7
				(self changeState: 20)
			)
			(10
				(gEgo setMotion: MoveTo 217 182 self)
			)
			(11
				(self changeState: 20)
			)
			(20
				(gEgo setMotion: MoveTo 223 168 self)
			)
			(21
				(gEgo hide:)
				(= global205 1)
				(HandsOn)
				(gCurRoom newRoom: 70)
			)
		)
	)
)

(instance frogViewer of Script
	(properties)

	(method (doit)
		(super doit:)
		(= local4 (= local3 (gEgo onControl: 1)))
		(if (& local3 $0001)
			(gEgo view: 371)
		else
			(gEgo view: 377)
		)
	)
)

(instance swept of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (< (gEgo x:) 255)
					(gEgo
						setLoop: 0
						xStep: 4
						setMotion: MoveTo (- (gEgo x:) 15) (gEgo y:) self
					)
				else
					(gEgo
						setLoop: 3
						illegalBits: 0
						xStep: 4
						yStep: 3
						setMotion:
							MoveTo
							(- (gEgo x:) 5)
							(+ (gEgo y:) 7)
							self
					)
				)
				(= local2 (Timer setReal: self 3))
			)
			(1
				(if (IsObject local2)
					(local2 dispose: delete:)
				)
				(Print 24 17) ; "The force of the water pushes you back."
				(gEgo
					xStep: 3
					yStep: 2
					illegalBits: -32768
					setLoop: -1
					setScript: 0
				)
				(HandsOn)
			)
		)
	)
)

