;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27)
(include sci.sh)
(use Main)
(use Interface)
(use rmnScript)
(use eRS)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use MoveFwd)
(use LoadMany)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm027 0
)

(local
	local0
	local1
	local2
	local3
)

(instance rm027 of PQRoom
	(properties
		picture 27
		east 28
		south -1
		west -1
	)

	(method (init)
		(LoadMany rsVIEW 1 16 25 208 280 281 282 284 285 310)
		(super init:)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 142 253 137 202 128 125 114 80 109 43 110 0 107
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: -100 163 48 147 71 154 92 164 74 179 46 189 -100 195
					yourself:
				)
		)
		(if (IsFlag 6)
			(HandsOff)
			(proc0_17 15)
			(woman init: setScript: motionForABit)
			(= global126 0)
			(ClearFlag 6)
		else
			(= global126 5)
		)
		(picnicker1
			cycleSpeed: 9
			setScript: (if (> (gGame detailLevel:) 2) picnicker1Script else 0)
			init:
		)
		(picnicker2
			cycleSpeed: 9
			setScript: (if (> (gGame detailLevel:) 2) picnicker2Script else 0)
			init:
		)
		(picnicker3
			cycleSpeed: 9
			setScript: (if (> (gGame detailLevel:) 2) picnicker3Script else 0)
			init:
		)
		(picnicker4
			cycleSpeed: 9
			setScript: (if (> (gGame detailLevel:) 2) picnicker4Script else 0)
			init:
		)
		(if (gCast contains: woman)
			(self
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 165 155 1 138 26 117 186 133
						yourself:
					)
			)
		else
			(self
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 165 155 101 147 122 126 186 133
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 75 144 5 139 29 118 93 123
						yourself:
					)
			)
		)
		(switch gPrevRoomNum
			(28
				(HandsOn)
				(gEgo view: 1 posn: 310 159 illegalBits: 0 init:)
				(cond
					((== global134 2)
						(= local0 1)
					)
					((IsFlag 5)
						(ClearFlag 58)
						(nut
							moveSpeed: (gEgo moveSpeed:)
							cycleSpeed: (gEgo cycleSpeed:)
							setCycle: Walk
							loop: 1
							posn: 305 165
							init:
						)
					)
				)
			)
			(else
				(gEgo
					normal: 1
					view: 1
					loop: 6
					posn: 12 160
					setCycle: Walk
					setMotion: PolyPath 14 162
					illegalBits: 0
					init:
				)
			)
		)
		(carDoor init: stopUpd:)
		(car init:)
		(gAddToPics add: car doit:)
		(tables init:)
		(trees init:)
		(sky init:)
		(river init:)
		(grass init:)
		(dirt init:)
		(water1 setCycle: Fwd cycleSpeed: 9 init:)
		(water2 setCycle: Fwd cycleSpeed: 9 init:)
		(water3 setCycle: Fwd cycleSpeed: 9 init:)
		(gLongSong loop: -1 number: 270 flags: 1 init: play:)
	)

	(method (doit)
		(cond
			(script 0)
			((& (gEgo onControl: 0) $0002)
				(HandsOff)
				(self setScript: waterScript)
			)
			((and (IsFlag 5) (not local1) (not (== global134 2)))
				(HandsOff)
				(self setScript: goToCar)
			)
		)
		(super doit:)
	)

	(method (dispose)
		(DisposeScript 951)
		(super dispose:)
	)
)

(instance motionForABit of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 5)
			)
			(1
				(= seconds 3)
				(ShowClock 1)
			)
			(2
				(= cycles 1)
			)
			(3
				(woman cycleSpeed: 8 setCycle: Fwd)
				(= seconds 4)
			)
			(4
				(womanInset init:)
				(= save1 1)
				(Say womanInset 27 0) ; "Oh, Officer, thank God! You've got to stop that man! He's a raving lunatic!"
				(= seconds 7)
			)
			(5
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(ShowClock 0)
				(womanInset dispose:)
				(woman setCycle: 0 stopUpd:)
				(gEgo setMotion: PolyPath 67 149 self)
			)
			(6
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance womanScript of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 67 149 self)
			)
			(1
				(Face gEgo woman)
				(= cycles 1)
			)
			(2
				(iEgo init:)
				(= save1 1)
				(Say iEgo 27 1) ; "Just what seems to be the problem, ma'am?"
				(= seconds 5)
			)
			(3
				(iEgo dispose:)
				(= cycles 1)
			)
			(4
				(womanInset init:)
				(= save1 1)
				(Say womanInset 27 2) ; "There's a madman over there! Why...why he's almost butt naked! Ranting and raving about aliens from outer space. He's going to hurt someone!"
				(= seconds 10)
				(woman loop: 1 cel: 0 setCycle: CT 4 1)
			)
			(5
				(womanInset dispose:)
				(= cycles 1)
			)
			(6
				(= save1 1)
				(iEgo init:)
				(Say iEgo 27 3) ; "Calm down, Ma'am. I'll take care of it."
				(woman cycleSpeed: 9 setCycle: End)
				(= seconds 6)
			)
			(7
				(iEgo dispose:)
				(= cycles 1)
			)
			(8
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(woman stopUpd:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance waterScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Print 27 4) ; "You have no time to go swimming."
				(gEgo heading: 180 setMotion: MoveFwd 10 self)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance goToCar of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(nut setMotion: PolyPath 28 195 self)
				(gEgo setMotion: PolyPath 80 185 self)
			)
			(1 0)
			(2
				(nut loop: 3)
				(= cycles 1)
			)
			(3
				(HandsOn)
				(nut stopUpd:)
				(= local1 1)
				(gCurRoom east: -1)
				(nut setScript: inCarTimer self)
				(self dispose:)
			)
		)
	)
)

(instance inCarTimer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (+ 60 (* gHowFast 20)))
			)
			(1
				(if (gCurRoom script:)
					(-- state)
					(= seconds 3)
				else
					(if gModelessDialog
						(gModelessDialog dispose:)
					)
					(HandsOff)
					(Print 27 5 #at 120 150) ; "After daydreaming, you realize that you have to get him to the station."
					(= cycles 1)
				)
			)
			(2
				(= local2 1)
				(if local0
					(gCurRoom setScript: enterCar)
				else
					(gCurRoom setScript: suspectCar self)
				)
			)
		)
	)
)

(instance suspectCar of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 66 185 self)
			)
			(1
				(carDoor cycleSpeed: 8 setCycle: End self)
				(soundEffects number: 900 loop: 1 play:)
			)
			(2
				(nut
					setLoop: 0
					setPri: 14
					setCycle: SyncWalk
					setMotion: MoveTo 47 179 self
				)
			)
			(3
				(nut
					view: 284
					loop: 0
					cel: 0
					posn: 38 172
					cycleSpeed: 9
					setCycle: End self
				)
			)
			(4
				(carDoor setCycle: Beg self)
			)
			(5
				(soundEffects number: 901 loop: 1 play:)
				(= cycles 1)
			)
			(6
				(Print 27 6) ; "You make sure the deranged man is secured and belted into the front of your patrol car."
				(= cycles 1)
			)
			(7
				(= local0 1)
				(= global134 2)
				(nut setPri: (- (carDoor priority:) 1) stopUpd:)
				(carDoor stopUpd:)
				(if local2
					(gCurRoom setScript: enterCar)
				else
					(HandsOn)
					(self dispose:)
				)
			)
		)
	)
)

(instance suspectOutCar of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 66 185 self)
			)
			(1
				(carDoor cycleSpeed: 8 setCycle: End self)
				(soundEffects number: 900 loop: 1 play:)
			)
			(2
				(nut loop: 0)
				(nut
					view: 284
					cel: (nut lastCel:)
					posn: 38 172
					cycleSpeed: 9
					setCycle: Beg self
				)
			)
			(3
				(nut
					view: 310
					posn: 44 179
					setLoop: 1
					setPri: 14
					setCycle: SyncWalk
					setMotion: MoveTo 28 195 self
				)
			)
			(4
				(carDoor setPri: 14 setCycle: Beg self)
			)
			(5
				(soundEffects number: 901 loop: 1 play:)
				(= cycles 1)
			)
			(6
				(= local0 0)
				(= global134 0)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance friskHim of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(nut view: 285 loop: 1 posn: 26 195 ignoreActors: 1)
				(gEgo setMotion: MoveTo (+ (nut x:) 12) (+ (nut y:) 5) self)
			)
			(1
				(Print 27 7) ; "Searching a wet and nearly naked man like this is particularly unpleasant."
				(= cycles 1)
			)
			(2
				(gEgo
					normal: 0
					ignoreActors: 1
					view: 285
					loop: 0
					cel: 0
					cycleSpeed: 12
					setPri: (+ (gEgo priority:) 1)
					setCycle: End self
				)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(Print 27 8) ; "Nevertheless, you're glad you did when you discover a knife concealed in his briefs."
				(SetScore 108 5)
				(gEgo
					get: 17 ; knife
					normal: 1
					ignoreActors: 0
					view: 1
					cel: 0
					cycleSpeed: (gEgo moveSpeed:)
					setPri: -1
					setCycle: Walk
					setMotion: PolyPath 78 185 self
				)
				(nut view: 310 loop: 3 posn: 28 195)
			)
			(5
				(HandsOn)
				(nut stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance exitCar of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 5)
			)
			(1
				(gEgo
					normal: 0
					view: 16
					loop: 2
					cel: 12
					posn: (- (car x:) 13) (- (car y:) 26)
					setCycle: Beg self
				)
			)
			(2
				(gEgo
					normal: 1
					view: 1
					cel: 0
					cycleSpeed: (gEgo moveSpeed:)
					posn: (- (gEgo x:) 4) (+ (gEgo y:) 2)
					setCycle: Walk
					setMotion: MoveTo 15 160 self
				)
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance enterCar of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 15 163 self)
			)
			(1
				(gEgo
					setPri: 12
					setMotion: MoveTo (- (car x:) 17) (- (car y:) 24) self
				)
			)
			(2
				(soundEffects number: 900 loop: 1 play:)
				(= cycles 1)
			)
			(3
				(gEgo
					normal: 0
					view: 16
					posn: (+ (gEgo x:) 4) (- (gEgo y:) 2)
					loop: 2
					cel: 0
					setCycle: End self
				)
			)
			(4
				(gEgo setPri: -1 dispose:)
				(gLongSong fade:)
				(= cycles 1)
			)
			(5
				(soundEffects number: 901 loop: 1 play:)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(gCurRoom newRoom: 25)
			)
		)
	)
)

(instance picnicker1Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 5 8))
			)
			(1
				(picnicker1 setCycle: End self)
			)
			(2
				(= seconds 3)
			)
			(3
				(picnicker1 setCycle: Beg self)
			)
			(4
				(if (< (gGame detailLevel:) 2)
					(picnicker1 stopUpd:)
					(self dispose:)
				else
					(self init:)
				)
			)
		)
	)
)

(instance picnicker2Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 1 8))
			)
			(1
				(picnicker2 setCycle: End self)
			)
			(2
				(= seconds 5)
			)
			(3
				(picnicker2 setCycle: Beg self)
			)
			(4
				(if (< (gGame detailLevel:) 2)
					(picnicker2 stopUpd:)
					(self dispose:)
				else
					(self init:)
				)
			)
		)
	)
)

(instance picnicker3Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 1 8))
			)
			(1
				(picnicker3 setCycle: End self)
			)
			(2
				(picnicker3 setCycle: Beg self)
			)
			(3
				(if (< (gGame detailLevel:) 2)
					(picnicker3 stopUpd:)
					(self dispose:)
				else
					(self init:)
				)
			)
		)
	)
)

(instance picnicker4Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 10 15))
			)
			(1
				(picnicker4 setCycle: End self)
			)
			(2
				(= seconds (Random 7 15))
			)
			(3
				(picnicker4 setCycle: Beg self)
			)
			(4
				(if (< (gGame detailLevel:) 2)
					(picnicker4 stopUpd:)
					(self dispose:)
				else
					(self init:)
				)
			)
		)
	)
)

(instance talkB4CuffingNut of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= save1 1)
				(cond
					((== register picnicker1)
						(Say register 27 9) ; "DO something, Officer!"
						(= seconds 4)
					)
					((== register picnicker2)
						(Say register 27 10) ; "WE'RE okay. Go get the fruitcake."
						(= seconds 5)
					)
					((== register picnicker3)
						(Say register 27 11) ; "Whaddya want with us? The nutcase is over there by the river!"
						(= seconds 8)
					)
					((== register picnicker4)
						(Say register 27 12) ; "Lock that mad man up before he hurts someone, Officer!"
						(= seconds 6)
					)
					(else
						(Print 27 13) ; "OOPS talkb4CuffingNut doens't work."
					)
				)
			)
			(1
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance talkAfterCuffingNut of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= save1 1)
				(cond
					((== register picnicker1)
						(Say register 27 14) ; "Imagine that kind of behavior going on in our public parks!"
						(= seconds 7)
					)
					((== register picnicker2)
						(Say register 27 15) ; "What is this world coming to!?"
						(= seconds 5)
					)
					((== register picnicker3)
						(Say register 27 16) ; "Good job, Officer. We can always count on our Men In Blue."
						(= seconds 6)
					)
					((== register picnicker4)
						(Say register 27 17) ; "Watch out, dude! He looks pretty squirrely.  Be careful with him!"
						(= seconds 6)
					)
					(else
						(Print 27 18) ; "OOPS talkAfterCuffingNut doens't work."
					)
				)
			)
			(1
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance woman of Actor
	(properties
		x 88
		y 140
		view 280
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 27 19) ; "The woman seems close to hysteria over something."
			)
			(3 ; Do
				(Print 27 20) ; "Smacking her in the face won't help. She's not that hysterical."
			)
			(5 ; Talk
				(if (== local3 0)
					(HandsOff)
					(gCurRoom setScript: womanScript)
					(= local3 1)
				else
					(Print 27 21) ; "The woman is hysterical and won't calm down until you take care of the alleged crazy man."
				)
			)
			(4 ; Inventory
				(switch invItem
					(19 ; wallet
						(Print 27 22) ; "We can SEE that you're a police officer. Now why don't you DO something?"
					)
					(1 ; gun
						(Print 27 23) ; "She obviously ISN'T the perpetrator you were called here to subdue!"
					)
					(else
						(super doVerb: theVerb invItem)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance car of PicView
	(properties
		x 22
		y 195
		description {Car}
		view 208
		cel 1
		priority 13
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 27 24) ; "You look at your car fondly."
			)
			(3 ; Do
				(if (IsFlag 5)
					(if local0
						(HandsOff)
						(gCurRoom setScript: enterCar)
					else
						(Print 27 25) ; "So what are you going to do with him?"
					)
				else
					(gCurRoom setScript: enterCar)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance carDoor of Prop
	(properties
		x 55
		y 173
		z 10
		view 208
		loop 3
		cel 10
		priority 14
		signal 16401
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 27 24) ; "You look at your car fondly."
			)
			(3 ; Do
				(cond
					((== local0 1)
						(HandsOff)
						(gCurRoom setScript: suspectOutCar)
					)
					((IsFlag 5)
						(HandsOff)
						(gCurRoom setScript: suspectCar)
					)
					(else
						(Print 27 26) ; "It is easier to drive from the other side."
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance nut of Actor
	(properties
		x 325
		y 169
		view 310
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 27 27) ; "This guy is definitely unstable."
			)
			(5 ; Talk
				(Print 27 28) ; "This guy's not saying anything that makes sense."
			)
			(3 ; Do
				(cond
					((gEgo has: 17) ; knife
						(Print 27 29) ; "He has already been frisked."
					)
					((== local0 1)
						(Print 27 30) ; "You can't frisk him from out there."
					)
					(else
						(HandsOff)
						(gCurRoom setScript: friskHim)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (doit)
		(if (== (gCurRoom script:) goToCar)
			(nut
				cycleSpeed: (gGame egoMoveSpeed:)
				moveSpeed: (gGame egoMoveSpeed:)
			)
		)
		(super doit:)
	)
)

(instance picnicker1 of Prop
	(properties
		x 154
		y 150
		description {the picnickers}
		view 282
		signal 16384
		detailLevel 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(if (IsFlag 5)
					(Print 27 31) ; "These folks look relieved now that you have this nut under control."
				else
					(Print 27 32) ; "Something has disturbed the picnickers."
				)
			)
			(5 ; Talk
				(HandsOff)
				(if (IsFlag 5)
					(gCurRoom setScript: talkAfterCuffingNut 0 self)
				else
					(gCurRoom setScript: talkB4CuffingNut 0 self)
				)
			)
			(3 ; Do
				(Print 27 33) ; "The picnickers haven't done anything wrong."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance picnicker2 of Prop
	(properties
		x 34
		y 106
		description {the picnickers}
		view 282
		loop 1
		priority 10
		signal 16400
		detailLevel 2
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 27 32) ; "Something has disturbed the picnickers."
			)
			(5 ; Talk
				(HandsOff)
				(if (IsFlag 5)
					(gCurRoom setScript: talkAfterCuffingNut 0 self)
				else
					(gCurRoom setScript: talkB4CuffingNut 0 self)
				)
			)
			(else
				(picnicker1 doVerb: theVerb invItem)
			)
		)
	)
)

(instance picnicker3 of Prop
	(properties
		x 37
		y 121
		description {the picnickers}
		view 282
		loop 2
		priority 10
		signal 16400
		detailLevel 2
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(5 ; Talk
				(HandsOff)
				(if (IsFlag 5)
					(gCurRoom setScript: talkAfterCuffingNut 0 self)
				else
					(gCurRoom setScript: talkB4CuffingNut 0 self)
				)
			)
			(else
				(picnicker1 doVerb: theVerb invItem)
			)
		)
	)
)

(instance picnicker4 of Prop
	(properties
		x 137
		y 132
		description {the picnickers}
		view 282
		loop 3
		priority 11
		signal 16400
		detailLevel 2
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(5 ; Talk
				(HandsOff)
				(if (IsFlag 5)
					(gCurRoom setScript: talkAfterCuffingNut 0 self)
				else
					(gCurRoom setScript: talkB4CuffingNut 0 self)
				)
			)
			(else
				(picnicker1 doVerb: theVerb invItem)
			)
		)
	)
)

(instance water1 of Prop
	(properties
		x 154
		y 101
		view 283
		cel 2
		detailLevel 2
	)

	(method (doVerb theVerb invItem)
		(river doVerb: theVerb invItem)
	)
)

(instance water2 of Prop
	(properties
		x 198
		y 86
		view 283
		loop 1
		detailLevel 2
	)

	(method (doVerb theVerb invItem)
		(river doVerb: theVerb invItem)
	)
)

(instance water3 of Prop
	(properties
		x 304
		y 116
		view 283
		loop 2
		cel 5
		detailLevel 2
	)

	(method (doVerb theVerb invItem)
		(river doVerb: theVerb invItem)
	)
)

(instance river of Feature
	(properties
		x 200
		y 101
		description {the river}
		onMeCheck 2048
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 27 34) ; "The river's considerable undertow churns the waters into a muddy green."
			)
			(3 ; Do
				(Print 27 35) ; "You don't have your suit. Besides, you're on duty."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance tables of Feature
	(properties
		x 93
		y 128
		description {picnic tables}
		onMeCheck 64
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 27 36) ; "You've been picnicking at Aspen Falls many times before. One of those tables probably still has your initials on it."
			)
			(3 ; Do
				(Print 27 37) ; "You don't have time for a picnic."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance trees of Feature
	(properties
		x 159
		y 70
		description {the tree}
		onMeCheck 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 27 38) ; "The graceful willow trees make Aspen Falls the prettiest park for miles around."
			)
			(3 ; Do
				(Print 27 39) ; "You don't have time to climb trees."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sky of Feature
	(properties
		x 219
		y 26
		description {the sky}
		onMeCheck 512
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 27 40) ; "The azure summer sky is accented by wispy clouds."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance grass of Feature
	(properties
		x 152
		y 141
		description {the grass}
		onMeCheck 8194
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 27 41) ; "The grass stays lush and green on the banks of the river."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance dirt of Feature
	(properties
		x 172
		y 187
		description {the dirt}
		onMeCheck 256
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 27 42) ; "The bare area disrupts the grasses."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance womanInset of View
	(properties
		x 57
		y 149
		view 281
		priority 13
		signal 16
	)

	(method (init)
		(womanEyes
			x: (+ (womanInset x:) 25)
			y: (- (womanInset y:) 54)
			init:
			setScript: womanEyesBlink
		)
		(womanMouth
			x: (+ (womanInset x:) 25)
			y: (- (womanInset y:) 49)
			cycleSpeed: 9
			setCycle: RandCycle
			init:
		)
		(suckingthumb
			x: (- (womanInset x:) 17)
			y: (- (womanInset y:) 29)
			cycleSpeed: 12
			setCycle: RandCycle
			init:
		)
		(picnicker1 stopUpd: setScript: 0)
		(picnicker2 stopUpd: setScript: 0)
		(picnicker3 stopUpd: setScript: 0)
		(picnicker4 stopUpd: setScript: 0)
		(self stopUpd:)
		(super init:)
	)

	(method (dispose)
		(womanEyes setScript: 0 dispose:)
		(womanMouth dispose:)
		(suckingthumb dispose:)
		(picnicker1 startUpd: setScript: picnicker1Script)
		(picnicker2 startUpd: setScript: picnicker2Script)
		(picnicker3 startUpd: setScript: picnicker3Script)
		(picnicker4 startUpd: setScript: picnicker4Script)
		(super dispose:)
	)
)

(instance womanEyes of Prop
	(properties
		view 281
		loop 2
		priority 14
		signal 16
	)
)

(instance womanMouth of Prop
	(properties
		view 281
		loop 1
		priority 14
		signal 16
	)
)

(instance suckingthumb of Prop
	(properties
		view 281
		loop 3
		priority 14
		signal 16
	)
)

(instance womanEyesBlink of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 4)
			)
			(1
				(womanEyes cel: 1)
				(= cycles 2)
			)
			(2
				(womanEyes cel: 0)
				(= cycles 1)
			)
			(3
				(self init:)
			)
		)
	)
)

(instance iEgo of View
	(properties
		x 261
		y 99
		view 25
		priority 14
		signal 16
	)

	(method (init)
		(iEgoMouth
			x: (iEgo x:)
			y: (iEgo y:)
			cycleSpeed: 9
			setCycle: RandCycle
			init:
		)
		(iEgoEyes x: (iEgo x:) y: (iEgo y:) init: setScript: egoEyesBlink)
		(picnicker1 stopUpd: setScript: 0)
		(picnicker2 stopUpd: setScript: 0)
		(picnicker3 stopUpd: setScript: 0)
		(picnicker4 stopUpd: setScript: 0)
		(self stopUpd:)
		(super init:)
	)

	(method (dispose)
		(iEgoMouth dispose:)
		(iEgoEyes setScript: 0 dispose:)
		(picnicker1 startUpd: setScript: picnicker1Script)
		(picnicker2 startUpd: setScript: picnicker2Script)
		(picnicker3 startUpd: setScript: picnicker3Script)
		(picnicker4 startUpd: setScript: picnicker4Script)
		(super dispose:)
	)
)

(instance iEgoMouth of Prop
	(properties
		view 25
		loop 1
		priority 15
		signal 16400
	)
)

(instance iEgoEyes of Prop
	(properties
		view 25
		loop 2
		priority 15
		signal 16400
	)
)

(instance egoEyesBlink of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 4)
			)
			(1
				(iEgoEyes cel: 1)
				(= cycles 2)
			)
			(2
				(iEgoEyes cel: 0)
				(= cycles 1)
			)
			(3
				(self init:)
			)
		)
	)
)

(instance soundEffects of Sound
	(properties
		priority 7
	)
)

