;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 31)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	Room31 0
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

(instance whaleMusic of Sound
	(properties
		number 36
	)
)

(instance sharkMusic of Sound
	(properties
		number 78
		loop -1
	)
)

(instance Room31 of Rm
	(properties
		style 9
	)

	(method (init)
		(= horizon 75)
		(= gIndoors 0)
		(= local12 4)
		(if global223
			(= local0 (Prop new:))
			(local0
				view: 650
				loop: 1
				cel: 1
				posn: 155 57
				setPri: 0
				ignoreActors:
				setCycle: Fwd
				init:
				hide:
			)
		)
		(self setRegions: 519 504) ; Ocean_Region, Gull_Region
		(Load rsVIEW 8)
		(Load rsVIEW 10)
		(Load rsVIEW 300)
		(Load rsVIEW 84)
		(Load rsVIEW 887)
		(Load rsSOUND 78)
		(if (<= (gEgo y:) (+ global108 2))
			(gEgo y: (- horizon 1))
		)
		(= global108 horizon)
		(switch gPrevRoomNum
			(43
				(if (== (gEgo view:) 312)
					(if gNight
						(gCurRoom drawPic: 131)
					else
						(gCurRoom drawPic: 31)
					)
					(= local2 4)
					(= local1 2)
					(User canControl: 0)
					(= global205 1)
					(gEgo posn: 5 100 setMotion: MoveTo 400 113)
				else
					(= local2 100)
					(= local1 100)
				)
			)
			(44
				(= local2 99)
				(= local1 100)
				(= local4 (View new:))
				(local4 view: 526 loop: 0 cel: 0 posn: 134 54 init:)
				(if (IsObject local0)
					(local0 hide:)
				)
				(if gNight
					(gCurRoom drawPic: 131)
				else
					(gCurRoom drawPic: 31)
				)
				(gEgo setScript: whaleActions)
				(whaleActions changeState: 10)
			)
			(1
				(= local2 4)
				(= local1 0)
			)
			(95
				(= local2 3)
				(= local1 1)
			)
			(13
				(= local2 2)
				(= local1 0)
			)
			(19
				(= local2 1)
				(= local1 0)
			)
			(25
				(= local2 0)
				(= local1 0)
			)
			(32
				(cond
					((<= (gEgo x:) 0)
						(= local2 1)
						(= local1 5)
					)
					((>= (gEgo y:) 189)
						(= local2 1)
						(= local1 3)
					)
					((>= (gEgo x:) 319)
						(= local2 1)
						(= local1 3)
					)
					(else
						(= local2 1)
						(= local1 3)
					)
				)
			)
			(39
				(= local2 2)
				(= local1 5)
			)
			(41
				(= local1 3)
				(= local2 2)
			)
			(36 ; Room_36
				(= local2 3)
				(= local1 5)
			)
			(38
				(= local2 3)
				(= local1 3)
			)
			(33
				(= local2 4)
				(= local1 5)
			)
			(34
				(= local2 4)
				(= local1 4)
			)
			(35
				(= local2 4)
				(= local1 3)
			)
		)
		(= local3 0)
		(= local11 0)
		(if (!= (gEgo view:) 312)
			(if (!= (gEgo view:) 84)
				(gEgo setCycle: Fwd)
				(gEgo view: 8 init: hide: xStep: 2 yStep: 1)
			)
		else
			(gEgo setCycle: Fwd)
			(gEgo init: xStep: 4 yStep: 2)
		)
		(if
			(and
				(== gAct 1)
				(< (Random 1 100) 40)
				(!= global105 14)
				(== global183 0)
				(< local1 30)
				(!= (gEgo script:) sharkActions)
			)
			(gEgo setScript: whaleActions)
		)
		(gEgo edgeHit: EDGE_NONE)
		(super init:)
		(self doit:)
		(= local13 local2)
	)

	(method (handleEvent event &tmp temp0)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said 'look[<around][/room,ocean,ocean,water]')
					(cond
						((and (== local2 99) (== local1 100))
							(Print 31 0) ; "You can see an island in the distance."
						)
						(gNight
							(Print 31 1) ; "You are swimming in a great ocean."
						)
						((== global105 14)
							(Print 31 2) ; "You are riding a dolphin in a great ocean."
						)
						(else
							(Print 31 3) ; "You are swimming in a great ocean. Playful fish leap about you as you swim."
						)
					)
					(if (gCast contains: local9)
						(Print 31 4) ; "There is a hungry shark approaching!!"
					)
				)
				((Said 'mount/dolphin')
					(if (== (gEgo view:) 312)
						(Print 31 5) ; "You ARE riding the dolphin."
					else
						(Print 31 6) ; "You don't see one here."
					)
				)
				((Said '/shark')
					(if (gCast contains: local9)
						(Print 31 7) ; "Just get out of there...fast!!"
					else
						(Print 31 6) ; "You don't see one here."
					)
				)
				((Said 'look/island')
					(if (and (== local2 99) (== local1 100))
						(Print 31 8) ; "It's too far in the distance to see it clearly."
					else
						(Print 31 9) ; "What island?"
					)
				)
				((== (gEgo view:) 312)
					(cond
						((Said 'look/dolphin')
							(Print 31 10) ; "You can feel the dolphin's strong muscles working, as it swims through the ocean with you on its back."
						)
						((Said 'kiss/dolphin')
							(Print 31 11) ; "There is no need for that."
						)
						((Said 'give>')
							(cond
								((Said '/*/fish')
									(Print 31 12) ; "The fish don't want it."
								)
								((Said '/*/bird,gull')
									(Print 31 13) ; "The seagulls have no interest in it."
								)
								(
									(and
										(Said '/*/dolphin>')
										(= temp0 (gInventory saidMe:))
									)
									(if (gEgo has: (gInventory indexOf: temp0))
										(Print 31 14) ; "The dolphin doesn't want anything."
									else
										(DontHave) ; "You don't have it."
									)
								)
							)
						)
						((Said 'talk[/dolphin]')
							(Print 31 15) ; "You speak to the dolphin, and it chatters back."
						)
						((Said 'pat/dolphin')
							(Print 31 16) ; "The dolphin's skin feels smooth and slippery as you pet it."
						)
						(else
							(event claimed: 0)
						)
					)
				)
			)
		)
	)

	(method (dispose)
		(gTimers eachElementDo: #dispose 96)
		(gEgo setLoop: -1)
		(super dispose:)
	)

	(method (doit)
		(super doit:)
		(if (and (not gNight) (== (gCurRoom script:) 0) (== (Random 1 100) 9))
			(gCurRoom setScript: fish3Actions)
		)
		(if
			(and
				(== (gCurRoom script:) 0)
				(not gNight)
				(== (Random 1 100) 10)
			)
			(gCurRoom setScript: fishActions)
		)
		(if (gEgo edgeHit:)
			(++ local3)
			(= global136 local1)
			(= global137 local2)
			(if (!= (gEgo view:) 312)
				(if (and (== local3 1) gNight)
					(= local1 1000)
					(= local2 1000)
				)
				(if (== local3 4)
					(Print 31 17) ; "You are getting very tired, Rosella."
				)
				(if
					(and
						(== local3 local12)
						(!= (gEgo script:) sharkActions)
					)
					(gEgo setScript: drown)
					(drown changeState: 1)
					1
				)
			)
			(cond
				((== (gEgo edgeHit:) EDGE_TOP)
					(if (and (< (++ local2) 10) (> local2 4))
						(= local2 0)
					)
					(gEgo posn: (gEgo x:) 188)
				)
				((== (gEgo edgeHit:) EDGE_BOTTOM)
					(if (< (-- local2) 0)
						(= local2 4)
					)
					(gEgo posn: (gEgo x:) (+ horizon (gEgo yStep:) 2))
				)
				((== (gEgo edgeHit:) EDGE_RIGHT)
					(-- local1)
					(gEgo posn: 1 (gEgo y:))
				)
				((== (gEgo edgeHit:) EDGE_LEFT)
					(++ local1)
					(gEgo posn: 318 (gEgo y:))
				)
			)
			(cond
				((and (== local1 100) (== local2 100))
					(gCurRoom newRoom: 43)
				)
				((and (== local1 1) (== local2 3))
					(gCurRoom newRoom: 95)
				)
				((== local1 0)
					(switch local2
						(4
							(gCurRoom newRoom: 1)
						)
						(2
							(gCurRoom newRoom: 13)
						)
						(1
							(gCurRoom newRoom: 19)
						)
						(0
							(gCurRoom newRoom: 25)
						)
					)
				)
				(
					(and
						(== local2 1)
						(or (== local1 3) (== local1 4) (== local1 5))
					)
					(gCurRoom newRoom: 32)
				)
				((and (== local2 2) (== local1 3))
					(gCurRoom newRoom: 41)
				)
				((and (== local2 2) (== local1 5))
					(gCurRoom newRoom: 39)
				)
				((and (== local2 3) (== local1 3))
					(if (== local13 4)
						(gEgo y: 100)
						(gCurRoom newRoom: 41)
					else
						(gEgo y: 170)
						(gCurRoom newRoom: 35)
					)
				)
				((and (== local2 3) (== local1 5))
					(if (<= (gEgo y:) 120)
						(gCurRoom newRoom: 33)
					else
						(gCurRoom newRoom: 39)
					)
				)
				((and (== local2 4) (== local1 3))
					(if (!= (gEgo view:) 312)
						(gCurRoom newRoom: 35)
					)
				)
				((and (== local2 4) (== local1 4))
					(if (!= (gEgo view:) 312)
						(gCurRoom newRoom: 34)
					)
				)
				((and (== local2 4) (== local1 5) (!= (gEgo view:) 312))
					(gCurRoom newRoom: 33)
				)
			)
			(cond
				((== (gEgo script:) sharkActions)
					(if (gCast contains: local9)
						(cond
							((< (gEgo x:) 10)
								(local9 posn: (- (gEgo x:) 30) (gEgo y:))
							)
							((> (gEgo x:) 300)
								(local9 posn: (+ (gEgo x:) 30) (gEgo y:))
							)
							((< (gEgo y:) (+ horizon 10))
								(local9 posn: (+ (gEgo x:) 20) (gEgo y:))
							)
							((> (gEgo y:) 174)
								(local9 posn: (gEgo x:) (+ (gEgo y:) 30))
							)
							(else
								(local9
									posn:
										(- (gEgo x:) 20)
										(- (gEgo y:) 20)
								)
							)
						)
					)
				)
				(
					(and
						(or
							(and (== local2 0) (> local1 2) (<= local1 5))
							(and
								(== local2 0)
								(<= local1 2)
								(> (Random 1 100) 50)
							)
							(and (!= gNight 0) (<= (Random 100) 40))
							(<= (Random 1 100) 20)
						)
						(!= (gEgo view:) 312)
						(!= (gEgo script:) sharkActions)
						(!= (gEgo script:) whaleActions)
					)
					(gEgo setScript: sharkActions)
				)
			)
			(if (== gNewRoomNum 31)
				(if (gCast contains: local5)
					(local5 dispose:)
					(gCurRoom setScript: 0)
				)
				(if (gCast contains: local6)
					(local6 dispose:)
					(gCurRoom setScript: 0)
				)
				(if
					(and
						(not (and (== local2 99) (== local1 100)))
						(gCast contains: local4)
					)
					(local4 dispose:)
					(if (IsObject local0)
						(local0 show:)
					)
				)
				(if gNight
					(gAddToPics dispose:)
					(gCurRoom drawPic: 131 9)
					(if (gCast contains: local8)
						(gEgo setScript: 0)
						(local8 dispose:)
						(whaleMusic dispose:)
					)
				else
					(gAddToPics dispose:)
					(gCurRoom drawPic: 31 9)
					(if (gCast contains: local8)
						(gEgo setScript: 0)
						(local8 dispose:)
						(whaleMusic dispose:)
					)
				)
				(cond
					((and (== local1 100) (== local2 99))
						(if (not (gCast contains: local4))
							(= local4 (View new:))
							(local4 view: 526 loop: 0 cel: 0 posn: 134 54 init:)
							(if (IsObject local0)
								(local0 hide:)
							)
						)
					)
					((IsObject local0)
						(local0 show:)
					)
				)
				(if (not gNight)
					((View new:)
						view: 671
						cel: (Random 0 9)
						x: (Random 10 319)
						y: (Random 20 30)
						setPri: 0
						ignoreActors:
						init:
						addToPic:
					)
					((View new:)
						view: 671
						cel: (Random 0 9)
						x: (Random 10 319)
						y: (Random 20 30)
						setPri: 0
						ignoreActors:
						init:
						addToPic:
					)
					((View new:)
						view: 671
						cel: (Random 0 9)
						x: (Random 10 319)
						y: (Random 20 30)
						setPri: 0
						ignoreActors:
						init:
						addToPic:
					)
				)
				(if (!= (gEgo view:) 312)
					(gEgo setMotion: 0 show:)
				)
			)
		)
	)
)

(instance fish3Actions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local5 (Act new:))
				(= local10 (Random 5 304))
				(= local7 (Random (+ (gCurRoom horizon:) 10) 179))
				(local5
					view: 300
					loop: 0
					cel: 0
					posn: local10 local7
					setCycle: End self
					init:
				)
				(if (< (local5 distanceTo: gEgo) 30)
					(local5 setCel: 0)
					(fish3Actions changeState: 1)
				)
			)
			(1
				(if (gCast contains: local5)
					(local5 dispose:)
				)
				((ScriptID 0 4) setReal: self 3) ; timer1
			)
			(2
				(gCurRoom setScript: 0)
			)
		)
	)
)

(instance fishActions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local6 (Act new:))
				(= local10 (Random 5 304))
				(= local7 (Random (+ (gCurRoom horizon:) 10) 179))
				(local6
					view: 301
					loop: 0
					cel: 0
					posn: local10 local7
					setCycle: End self
					init:
				)
				(if (< (local6 distanceTo: gEgo) 30)
					(local6 setCel: 0)
					(fishActions changeState: 1)
				)
			)
			(1
				(if (gCast contains: local6)
					(local6 dispose:)
				)
				((ScriptID 0 4) setReal: self 3) ; timer1
			)
			(2
				(gCurRoom setScript: 0)
			)
		)
	)
)

(instance drown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(1
				((ScriptID 0 5) setReal: self 10) ; timer2
			)
			(2
				(HandsOff)
				(gEgo
					view: 10
					setMotion: 0
					loop: 0
					cel: 0
					setCycle: End self
				)
			)
			(3
				(gEgo cel: 0 setCycle: End self)
			)
			(4
				(gEgo cel: 0 setCycle: End self)
			)
			(5
				(gEgo hide:)
				(if gNight
					(Print 31 18 #at -1 20) ; "The ocean confuses you at night! Panicking, you loose control...and drown."
				else
					(Print 31 19 #at -1 20) ; "You're too tired to swim anymore. Your body gives out as you prepare to join Davey Jones in his locker."
				)
				(= gDeathFlag 1)
			)
		)
	)
)

(instance whaleActions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 0 6) setReal: self (Random 2 8)) ; timer3
			)
			(1
				(= local8 (Prop new:))
				(whaleMusic play:)
				(local8
					view: 315
					cel: 0
					loop: 0
					posn: 120 66
					init:
					setCycle: End self
				)
			)
			(2
				(if (gCast contains: local8)
					(local8 loop: 1 setCycle: Fwd)
					((ScriptID 0 6) setReal: self 3) ; timer3
				)
			)
			(3
				(if (gCast contains: local8)
					(local8 loop: 2 cel: 0 setCycle: End self)
				)
			)
			(4
				(if (gCast contains: local8)
					(local8 dispose:)
				)
				((ScriptID 0 6) setReal: self 5) ; timer3
			)
			(5
				(if (> (gEgo y:) 93)
					(HandsOff)
					(gEgo
						view: 84
						setMotion: 0
						cel: 0
						setLoop: 0
						setCycle: End self
					)
				else
					(self changeState: 12)
				)
			)
			(6
				(gEgo hide:)
				(HandsOn)
				(gCurRoom newRoom: 44)
			)
			(10
				((ScriptID 0 6) dispose: delete:) ; timer3
				(gEgo
					view: 84
					setLoop: 1
					cel: 0
					posn: 160 129
					setCycle: End self
					init:
				)
			)
			(11
				(Print 31 20) ; "Again, you find yourself swimming in the ocean."
				(gEgo view: 8 setCycle: Fwd setLoop: -1)
				(HandsOn)
				(gEgo script: 0)
			)
		)
	)
)

(instance sharkActions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 1 5))
			)
			(1
				(sharkMusic play:)
				((= local9 (Act new:))
					ignoreHorizon:
					posn: (Random 100 200) (Random 75 189)
					view: 887
					setCycle: Walk
					ignoreActors:
					xStep: 5
					yStep: 4
					setMotion: Chase gEgo 10 self
					init:
				)
			)
			(2
				(HandsOff)
				(gEgo
					setMotion: 0
					view: 10
					loop: 0
					cel: 6
					setCycle: End self
				)
			)
			(3
				(gEgo hide:)
				(sharkMusic dispose:)
				(if (gCast contains: local9)
					(local9 setMotion: MoveTo -20 100)
				)
				(= seconds 3)
			)
			(4
				(= global204 0)
				(Print 31 21 #at -1 20) ; "You make a tasty morsel for that hungry shark!"
				(= gDeathFlag 1)
			)
		)
	)
)

