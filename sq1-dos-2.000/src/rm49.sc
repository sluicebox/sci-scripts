;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 49)
(include sci.sh)
(use Main)
(use Interface)
(use Osc)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm49 0
	openingScript 1
	robotAsksScript 2
	pushButtons 3
	holdLever 4
	scratchHead 5
	doHyperSpace 6
	jetSound 7
)

(instance rm49 of Rm
	(properties
		picture 16
	)

	(method (init)
		(super init:)
		(gAddToPics add: keronaATP_a eachElementDo: #init doit:)
		(self setScript: openingScript)
	)
)

(instance openingScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(jetSound number: 533 loop: -1 play:)
				(ship1 init: setCycle: Fwd setMotion: MoveTo -39 75 self)
			)
			(1
				(gCurRoom drawPic: 17 -32759)
				(= cycles 2)
			)
			(2
				(ship1
					posn: 380 110
					setPri: 14
					setStep: 6 6
					setMotion: MoveTo 112 -40 self
				)
				(gSoundEffects number: 464 loop: -1 play:)
				(satelite init: setCycle: Fwd setMotion: MoveTo 327 -15 self)
			)
			(3 0)
			(4
				(gSoundEffects stop:)
				(ship1 dispose:)
				(satelite dispose:)
				(= ticks 1)
			)
			(5
				(jetSound fade:)
				(gCurRoom drawPic: 49 -32760)
				(arm init:)
				(dial0 init: setCycle: Osc)
				(dial1 init: setCycle: Osc)
				(dial2 init: setCycle: Osc)
				(screen init: setCycle: Osc)
				(self setScript: robotAsksScript self)
			)
			(6
				(Print 49 0) ; "Course is plotted. Stand by for warp speed."
				(self setScript: holdLever self 10)
			)
			(7
				(switch global189
					(0
						(self setScript: (ScriptID 401 0)) ; dodgeAsteroids
					)
					(1
						(switch (Random 0 1)
							(0
								(self setScript: (ScriptID 402 0)) ; romulanWarbird
							)
							(1
								(self setScript: (ScriptID 401 0)) ; dodgeAsteroids
							)
						)
					)
					(2
						(self setScript: (ScriptID 401 0) self 1) ; dodgeAsteroids
					)
				)
			)
			(8
				(self setScript: approachDeltaur self)
			)
			(9
				(EgoDead 2 3 2 49 1) ; "In the face of danger you decide to turn and run, leaving Xenon and the rest of the universe to fend for themselves against those bad boys of the universe, the Sariens. When things get tough, the cream rises to the top. I guess you know which stratum you occupy."
				(self dispose:)
			)
		)
	)
)

(instance robotAsksScript of Script
	(properties)

	(method (init)
		(super init: &rest)
		(gKeyDownHandler addToFront: self)
		(gMouseDownHandler addToFront: self)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event)
		(if (and register (event type:))
			(if gModelessDialog
				(gModelessDialog seconds: 0 caller: 0 dispose:)
			)
			(= register 0)
			(= cycles 1)
			(event claimed: 1)
		else
			(super handleEvent: event)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(arm init: stopUpd:)
				(dial0 init: setCycle: Osc)
				(dial1 init: setCycle: Osc)
				(dial2 init: setCycle: Osc)
				(screen init: setCycle: Osc)
				(self setScript: pushButtons self)
			)
			(1
				(Print 49 2) ; "We have achieved escape velocity."
				(self setScript: holdLever self)
			)
			(2
				(Print 49 3 #at 76 10 #dispose) ; "It might help if you were to tell me where we are going. Please indicate our destination on the touch pad in front of you."
				(self setScript: (ScriptID 400 0)) ; raisePad
			)
			(3 0)
			(4
				(if (== global189 0)
					(Print 49 4) ; "If it doesn't matter to you, we can go to CES (Cosmic Electronics Show) on Rudicube 3. I just love seeing all of those new, big, shiny robots. You could buy me companion."
				)
				(self dispose:)
			)
		)
	)
)

(instance pushButtons of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(arm loop: 0 cel: 0 setCycle: CT 2 1 self)
			)
			(1
				(arm cel: 1)
				(= cycles 12)
			)
			(2
				(arm cel: 2)
				(= cycles 3)
			)
			(3
				(arm setCycle: Beg self)
			)
			(4
				(arm stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance holdLever of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(arm loop: 1 cel: 0 setCycle: End self)
			)
			(1
				(if register
					(self setScript: doHyperSpace self register)
				else
					(= seconds 4)
				)
			)
			(2
				(arm setCycle: Beg self)
			)
			(3
				(= register 0)
				(arm stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance scratchHead of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(arm startUpd: loop: 2 cel: 0 setCycle: End self)
			)
			(1
				(droidHand init: loop: 4 cel: 1 setCycle: Fwd)
				(arm loop: 3)
				(= seconds 3)
			)
			(2
				(droidHand dispose:)
				(arm loop: 2 cel: 0 setCycle: Beg self)
			)
			(3
				(arm stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance doHyperSpace of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== state 0) (== (gLongSong2 prevSignal:) 10))
			(gLongSong prevSignal: 0)
			(self cue:)
		)
		(Palette palANIMATE 238 255 -1)
	)

	(method (dispose)
		(= register 0)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gLongSong pause:)
				(gLongSong2 number: 332 loop: 1 flags: 0 play:)
			)
			(1
				(gCurRoom overlay: 149 7)
				(= cycles 1)
			)
			(2
				(= seconds (- register 2))
			)
			(3
				(if (== global189 0)
					(Print 49 5) ; "OH, NO!!! We're headed straight for an asteroid belt!"
					(self caller: 0)
					(client setScript: (ScriptID 401 0)) ; dodgeAsteroids
				else
					(= seconds 2)
				)
			)
			(4
				(gLongSong2 fade:)
				(gLongSong setVol: 40 pause: 0 fade: 127 25 10 0)
				(gCurRoom drawPic: 49 7)
				(self dispose:)
			)
		)
	)
)

(instance approachDeltaur of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom drawPic: 49 7)
				(arm init: show: loop: 2 cel: 0 setPri: 5 stopUpd:)
				(dial0 init: setCycle: Osc show:)
				(dial1 init: setCycle: Osc show:)
				(dial2 init: setCycle: Osc show:)
				(screen init: setCycle: Osc show:)
				(self setScript: pushButtons self)
			)
			(1
				(Print 49 6) ; "Sensors indicate a large ship in this sector. I wonder who it could be? Will continue to scan for an I.D."
				(gLongSong stop:)
				(gLongSong2 number: 500 loop: 1 flags: 1 play:)
				(self setScript: scratchHead self)
			)
			(2
				(deltaur init: setStep: 5 5 setMotion: MoveTo 352 249 self)
				(arm setScript: holdLever)
			)
			(3
				(deltaur setStep: 3 3 setMotion: MoveTo 312 169 self)
				(arm setScript: pushButtons)
			)
			(4
				(deltaur setStep: 1 1 setMotion: MoveTo 250 107 self)
			)
			(5
				(Print 49 7) ; "Whoa! That's a Sarien battle cruiser! We'd better stand off. If we get any closer, they'll detect us for sure and we'll be space sputum!"
				(if (Print 49 8 #button { OK. } 1 #button { No. } 0) ; "Let's head on out of here, okay boss?"
					(self dispose:)
				else
					(gLongSong fade:)
					(HandsOn)
					(gCurRoom newRoom: 50)
				)
			)
		)
	)
)

(instance keronaATP_a of PicView
	(properties
		name {keronaATP}
		x 227
		y 189
		view 117
		loop 2
		priority 1
		signal 16400
	)
)

(instance keronaATP_b of PicView ; UNUSED
	(properties
		name {keronaATP}
		x 227
		y 189
		view 117
		loop 2
		priority 1
		signal 16
	)
)

(instance satelite of Actor
	(properties
		x -44
		y 180
		yStep 8
		view 118
		loop 3
		priority 14
		signal 10256
		cycleSpeed 3
		xStep 8
		moveSpeed 3
	)
)

(instance deltaur of Actor
	(properties
		x 349
		y 235
		view 249
		priority 2
		signal 22544
		cycleSpeed 2
		moveSpeed 2
	)
)

(instance arm of Prop
	(properties
		x 207
		y 109
		z -56
		view 149
		priority 5
		signal 16400
		cycleSpeed 2
	)
)

(instance droidHand of Prop
	(properties
		x 220
		y 98
		view 149
		loop 4
		priority 5
		signal 24592
		cycleSpeed 2
	)
)

(instance dial0 of Prop
	(properties
		x 58
		y 176
		view 149
		loop 8
		priority 4
		signal 16400
		cycleSpeed 4
		detailLevel 1
	)
)

(instance dial1 of Prop
	(properties
		x 189
		y 84
		view 149
		loop 7
		cel 1
		priority 4
		signal 16400
		cycleSpeed 3
	)
)

(instance dial2 of Prop
	(properties
		x 248
		y 132
		view 149
		loop 6
		cel 4
		priority 4
		signal 16400
		cycleSpeed 2
		detailLevel 2
	)
)

(instance screen of Prop
	(properties
		x 116
		y 131
		view 149
		loop 5
		cel 3
		priority 4
		signal 16400
		cycleSpeed 4
		detailLevel 3
	)
)

(instance ship1 of Actor
	(properties
		x 142
		y 213
		yStep 4
		view 156
		priority 14
		signal 10256
		cycleSpeed 3
		illegalBits 0
		xStep 4
		moveSpeed 3
	)
)

(instance jetSound of Sound
	(properties)
)

