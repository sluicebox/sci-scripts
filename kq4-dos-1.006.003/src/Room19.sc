;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 19)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Inventory)
(use Actor)
(use System)

(public
	Room19 0
)

(local
	local0
	local1
	local2
)

(instance wave1 of Prop
	(properties)
)

(instance wave2 of Prop
	(properties)
)

(instance wave3 of Prop
	(properties)
)

(instance waves of List
	(properties)
)

(instance fallSound of Sound
	(properties)
)

(instance Room19 of Rm
	(properties
		picture 19
	)

	(method (init)
		(= north 13)
		(= south 25)
		(= east 20)
		(= west 31)
		(= horizon 104)
		(= gIndoors 0)
		(gEgo edgeHit: EDGE_NONE)
		(super init:)
		(if gNight
			(gCurRoom overlay: 119)
		)
		(= local2 (+ (* (- global160 global213) 60) (- global159 global214)))
		(if (and ((Inv at: 9) ownedBy: 203) (>= local2 3)) ; Lute
			(= gMinstrelRoom (/ (= gMinstrelRoom (Random 1 30)) 10))
		)
		(if (== gMinstrelRoom 3)
			(= gMinstrelActor (Act new:))
			(gMinstrelActor
				view: 174
				loop: 2
				setCel: 0
				illegalBits: 0
				posn: 293 116
				setPri: 14
				init:
			)
		)
		(self setRegions: 516 503 501 504) ; regMinstrel, beachReg, waterReg, Gull_Region
		(Load rsVIEW 174)
		(Load rsVIEW 17)
		(Load rsVIEW 33)
		(wave1
			view: 666
			loop: 0
			cel: 0
			posn: 183 73
			setPri: 0
			ignoreActors:
			cycleSpeed: 3
			init:
		)
		(wave2
			view: 666
			loop: 1
			cel: 0
			posn: 188 107
			setPri: 0
			ignoreActors:
			cycleSpeed: 3
			init:
		)
		(wave3
			view: 666
			loop: 2
			cel: 0
			posn: 189 152
			setPri: 0
			ignoreActors:
			cycleSpeed: 3
			init:
		)
		(waves add: wave1 wave2 wave3)
		(wave1 setScript: waveActions)
		(Load rsVIEW 2)
		(Load rsVIEW 17)
		(Load rsVIEW 33)
		(if (== (gEgo view:) 2)
			(= global105 0)
		else
			(= global107 0)
		)
		(gEgo illegalBits: -16384)
		(switch global105
			(0
				(switch gPrevRoomNum
					(25
						(if (> (gEgo x:) 210)
							(gEgo x: 293 y: 188)
							(gEgo illegalBits: -32768 setPri: 14)
							(= global107 11)
						else
							(gEgo x: 212 y: 188)
							(= global107 0)
						)
					)
					(13
						(if (< (gEgo x:) 245)
							(= global107 0)
							(gEgo x: 215 y: (+ horizon (gEgo yStep:) 1))
						else
							(gEgo x: 286 y: (+ horizon (gEgo yStep:) 1))
							(gEgo setPri: 14 illegalBits: -32768)
							(= global107 11)
						)
					)
					(20
						(gEgo setPri: 14 illegalBits: -32768)
						(= global107 11)
						(= global105 0)
						(if (< (gEgo y:) horizon)
							(gEgo x: 318 y: (+ horizon 2))
						else
							(gEgo x: 318)
						)
					)
					(else
						(= global107 11)
						(gEgo x: 318 y: 160)
						(gEgo illegalBits: -32768)
						(gEgo setPri: 14)
					)
				)
			)
			(1
				(switch gPrevRoomNum
					(25
						(= global107 0)
						(gEgo x: 151 y: 188)
					)
					(13
						(= global107 0)
						(gEgo x: 180 y: (+ horizon (gEgo yStep:) 1))
					)
				)
			)
			(2
				(switch gPrevRoomNum
					(25
						(= global107 0)
						(gEgo x: 88 y: 188)
					)
					(13
						(= global107 0)
						(gEgo x: 152 y: (+ horizon (gEgo yStep:) 1))
					)
				)
			)
			(3
				(switch gPrevRoomNum
					(25
						(= global107 0)
						(gEgo x: 31 y: 188)
					)
					(13
						(= global107 0)
						(gEgo x: 128 y: (+ horizon (gEgo yStep:) 1))
					)
				)
			)
			(4
				(switch gPrevRoomNum
					(25
						(gEgo x: 5 y: 188)
					)
					(13
						(gEgo x: 104 y: (+ horizon (gEgo yStep:) 1))
					)
					(31
						(if (< (gEgo y:) horizon)
							(gEgo x: 1 y: (+ 1 horizon))
						else
							(gEgo x: 1)
						)
					)
				)
			)
		)
		(gEgo init:)
		(= local0 (gEgo viewer:))
	)

	(method (dispose)
		(waves dispose:)
		(gEgo setPri: -1)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(if (gCast contains: gMinstrelActor)
			(= global213 global160)
			(= global214 global159)
		)
		(if (!= global105 10)
			(gEgo setPri: -1 illegalBits: -32768)
			(super newRoom: newRoomNumber)
		)
	)

	(method (doit &tmp temp0)
		(super doit:)
		(if (== global107 11)
			(cond
				((gEgo inRect: 254 104 316 115)
					(gEgo setPri: 12)
				)
				((and (!= global105 10) (== (gEgo edgeHit:) EDGE_NONE))
					(gEgo setPri: 14)
				)
			)
		)
		(if
			(and
				(== (gCurRoom script:) 0)
				(== global107 11)
				(& (= temp0 (gEgo onControl: 0)) $31d4)
			)
			(doFall doit:)
			(self
				setScript:
					(cond
						((& temp0 $2000) fallLmagenta)
						((& temp0 $1000) fallLred)
						((& temp0 $0100) fallGrey)
						((& temp0 $0080) fallLgrey)
						((& temp0 $0010) fallRed)
						((& temp0 $0040) fallBrown)
						((& temp0 $0004) fallGreen)
					)
			)
		)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if (and (== (event type:) evSAID) (Said 'look>'))
			(cond
				((Said '/grass')
					(Print 19 0) ; "A pretty meadow leads eastward."
				)
				((Said '/cliff')
					(Print 19 1) ; "Better be careful around the cliffs!"
				)
				((Said '[<around][/room]')
					(Print 19 2) ; "Wistfully, you stare out over the ocean, wishing you could go home and see your family again. Unfortunately, reality sets in, and you remember your difficult situation. Turning your head, you look eastward toward a meadowland covered with wildflowers, and heave a big sigh of sadness."
				)
			)
		)
	)
)

(instance fallLmagenta of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= global105 10)
				(gEgo
					viewer: 0
					illegalBits: 0
					setPri: 11
					yStep: 10
					setLoop: 1
					cel: 0
					view: 17
					posn: (gEgo x:) (- (gEgo y:) 4)
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 40) self
				)
			)
			(1
				(gEgo view: 33 setLoop: 0 cel: 0)
				(Animate (gCast elements:) 0)
				(ShakeScreen 10 ssUPDOWN)
				(= seconds 5)
			)
			(2
				(Print 19 3) ; "You really should be more careful, Rosella!"
				(= gDeathFlag 1)
			)
		)
	)
)

(instance fallLred of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= global105 10)
				(gEgo
					viewer: 0
					setPri: 13
					yStep: 10
					setLoop: 1
					cel: 0
					view: 17
					illegalBits: 0
					setCycle: Fwd
					posn: (- (gEgo x:) 12) (gEgo y:)
					setMotion: MoveTo 222 170 self
				)
			)
			(1
				(gEgo view: 33 setLoop: 0 cel: 0)
				(Animate (gCast elements:) 0)
				(ShakeScreen 10 ssUPDOWN)
				(= seconds 5)
			)
			(2
				(Print 19 4) ; "That last step was a doozy!"
				(= seconds 5)
			)
			(3
				(= gDeathFlag 1)
			)
		)
	)
)

(instance fallGrey of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= global105 10)
				(gEgo
					viewer: 0
					illegalBits: 0
					setPri: 13
					yStep: 10
					setLoop: 1
					cel: 0
					view: 17
					setCycle: Fwd
					posn: (- (gEgo x:) 8) (gEgo y:)
					setMotion: MoveTo 263 173 self
				)
			)
			(1
				(gEgo view: 33 setLoop: 0 cel: 0)
				(Animate (gCast elements:) 0)
				(ShakeScreen 10 ssUPDOWN)
				(= seconds 5)
			)
			(2
				(Print 19 5) ; "Watch where you're going, Rosella!"
				(= seconds 5)
			)
			(3
				(= gDeathFlag 1)
			)
		)
	)
)

(instance fallLgrey of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= global105 10)
				(gEgo
					viewer: 0
					illegalBits: 0
					setPri: 13
					yStep: 10
					xStep: 8
					setLoop: 1
					cel: 0
					view: 17
					setCycle: Fwd
					posn: (gEgo x:) (- (gEgo y:) 5)
					setMotion: MoveTo 270 173 self
				)
			)
			(1
				(gEgo view: 33 setLoop: 0 cel: 0)
				(Animate (gCast elements:) 0)
				(ShakeScreen 10 ssUPDOWN)
				(= seconds 5)
			)
			(2
				(Print 19 4) ; "That last step was a doozy!"
				(= seconds 5)
			)
			(3
				(= gDeathFlag 1)
			)
		)
	)
)

(instance fallRed of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= global105 10)
				(gEgo
					viewer: 0
					illegalBits: 0
					setPri: 13
					yStep: 10
					xStep: 8
					setLoop: 1
					cel: 0
					view: 17
					setCycle: Fwd
					posn: (gEgo x:) (- (gEgo y:) 5)
					setMotion: MoveTo (gEgo x:) 178 self
				)
			)
			(1
				(gEgo view: 33 setLoop: 0 cel: 0)
				(Animate (gCast elements:) 0)
				(ShakeScreen 10 ssUPDOWN)
				(= seconds 5)
			)
			(2
				(Print 19 4) ; "That last step was a doozy!"
				(= seconds 5)
			)
			(3
				(= gDeathFlag 1)
			)
		)
	)
)

(instance fallBrown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= global105 10)
				(gEgo
					viewer: 0
					illegalBits: 0
					setPri: 14
					yStep: 10
					setLoop: 1
					cel: 0
					view: 17
					setCycle: Fwd
					posn: (- (gEgo x:) 8) (gEgo y:)
					setMotion: MoveTo 239 187 self
				)
			)
			(1
				(gEgo view: 33 setLoop: 0 cel: 0)
				(Animate (gCast elements:) 0)
				(ShakeScreen 10 ssUPDOWN)
				(= seconds 3)
			)
			(2
				(Print 19 6) ; "That last step was a real doozy!"
				(= seconds 5)
			)
			(3
				(= gDeathFlag 1)
			)
		)
	)
)

(instance fallGreen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= global105 10)
				(gEgo
					viewer: 0
					illegalBits: 0
					setPri: 14
					yStep: 10
					setLoop: 1
					cel: 0
					view: 17
					setCycle: Fwd
					posn: (- (gEgo x:) 8) (gEgo y:)
					setMotion: MoveTo 240 219 self
				)
			)
			(1
				(gEgo view: 33 setLoop: 0 cel: 0)
				(Animate (gCast elements:) 0)
				(ShakeScreen 10 ssUPDOWN)
				(= seconds 5)
			)
			(2
				(Print 19 7) ; "Oops, you slipped!"
				(= seconds 5)
			)
			(3
				(= gDeathFlag 1)
			)
		)
	)
)

(instance waveActions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(for ((= local1 0)) (< local1 (waves size:)) ((++ local1))
					((View new:)
						view: ((waves at: local1) view:)
						loop: ((waves at: local1) loop:)
						cel: 0
						setPri: 0
						ignoreActors:
						x: ((waves at: local1) x:)
						y: ((waves at: local1) y:)
						init:
						addToPic:
						yourself:
					)
				)
				(= local1 0)
				(if global223
					(self changeState: 1)
				else
					(waves eachElementDo: #addToPic)
				)
			)
			(1
				((waves at: local1) cel: 0 show: setCycle: End self)
			)
			(2
				((waves at: local1) hide:)
				(if (< local1 (- (waves size:) 1))
					(++ local1)
				else
					(= local1 0)
				)
				(waveActions changeState: 1)
			)
		)
	)
)

(instance doFall of Code
	(properties)

	(method (doit)
		(gSounds eachElementDo: #stop 0)
		(fallSound number: 51 play:)
		(if (gCast contains: gMinstrelActor)
			(gMinstrelActor setCycle: 0)
		)
	)
)

