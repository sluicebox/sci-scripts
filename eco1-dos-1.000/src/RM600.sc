;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 600)
(include sci.sh)
(use Main)
(use Interface)
(use eRS)
(use n819)
(use Talker)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Motion)
(use Actor)
(use System)

(public
	RM600 0
)

(local
	local0
)

(instance RM600 of EcoRoom
	(properties
		lookStr 4
		picture 600
		style 7
		horizon 10
		south 580
		picAngle 70
		vanishingX 180
		vanishingY 44
	)

	(method (init)
		(NormalEgo)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 189 0 0 319 0 319 189 197 189 233 170 285 166 237 162 266 145 228 145 233 137 209 137 180 117 143 117 154 129 66 140 56 168 171 189
					yourself:
				)
		)
		(Load rsVIEW 600)
		(gFeatures
			add: skeletonBits skeleton1 hook skeleton2
			eachElementDo: #init
		)
		(if (== gPrevRoomNum 580)
			(LoadMany rsVIEW 601 602)
			(gEgo init: z: 20)
			(if (not (IsFlag 71))
				(dolphin init: setScript: bugEgoALot setCycle: Fwd)
			)
			(self setScript: enterCave)
		else
			(gEgo setCycle: 0)
			(LoadMany rsVIEW 603 582)
			(dolphin view: 603 loop: 6 cel: 0 init: setCycle: Fwd)
			(self setScript: mantaCartoon)
		)
		(seaweed1 init: setCycle: Fwd)
		(seaweed2 init: setCycle: Fwd)
		(seaweed3 init: setCycle: Fwd)
		(seaweed4 init: setCycle: Fwd)
		(super init: &rest)
		(if (and (not (IsFlag 71)) (== gPrevRoomNum 580))
			(gLongSong number: 665 loop: -1 play: hold: 10)
		else
			(gLongSong number: 600 loop: -1 play:)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Narrator init: 4) ; "Flesh-Eater's lair is a cold, dark cave at the peak of an underwater mountain. The current flows from the toxic waste dump directly to this spot. Flesh-Eater has concealed himself here to feed on the foul water."
			)
			(3 ; Do
				(Narrator init: 29) ; "The walls have absorbed a lot of the toxic chemicals. It would be fatal to touch them."
			)
			(4 ; Inventory
				(Narrator init: 30) ; "Working on the walls won't help."
			)
			(5 ; Talk
				(gEgo setScript: talkToCave)
			)
			(10 ; Recycle
				(Narrator init: 31) ; "Adam has no time to think about cleaning up right now."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance enterCave of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo posn: 184 230 setMotion: MoveTo 173 168 self)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance talkToCave of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 2 1) init: 4 1 self) ; Adam, "Hello-ello-ello-ello."
			)
			(1
				((ScriptID 2 0) init: 7 1 self) ; Delphineus, "Quit horsing around with that echo and get me out of here, Adam!"
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance bugEgoALot of Script
	(properties)

	(method (init)
		(super init: &rest)
		(self setScript: (ScriptID 127 0) 0 918) ; delSpeakScript
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 20)
			)
			(1
				(if (not (gCurRoom script:))
					((ScriptID 2 0) ; Delphineus
						init: (+ (= local0 (mod (++ local0) 4)) 1) 1 self
					)
				else
					(= ticks 3)
				)
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance cutDownDelph of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetFlag 71)
				(gEgo setMotion: PolyPath 175 146 self)
			)
			(1
				(gEgo setMotion: MoveTo 193 128 self)
			)
			(2
				(= register (gEgo z:))
				(gEgo setCycle: 0)
				(= seconds 1)
			)
			(3
				(gEgo
					view: 601
					setLoop: 0
					cel: 0
					posn: 193 108
					z: 0
					cycleSpeed: 20
					setCycle: End self
				)
			)
			(4
				(dolphin hide:)
				(gEgo view: 602 loop: 0 cel: 0 posn: 174 87)
				((ScriptID 2 0) init: 5 1 self) ; Delphineus, "Oh, man, I'm glad you showed up. I'm about ready to suffocate."
			)
			(5
				((dolphin script:) setScript: 0)
				(SetScore 15 335)
				(gEgo setCycle: CT 10 1 self)
			)
			(6
				((ScriptID 2 1) init: 1 1 self) ; Adam, "I hate this nylon stuff, I'm cutting as fast as I can. Hold on, Delphineus, just another second, I promise!"
			)
			(7
				(gSoundEffects number: 602 loop: 1 play:)
				(gLongSong hold: 0)
				(gEgo cel: 11 setCycle: End self)
			)
			(8
				(gEgo view: 601 loop: 1 cel: 10 posn: 194 78)
				(net init: setLoop: 3 setMotion: MoveTo 5 104 setCycle: Fwd)
				(dolphin
					show:
					view: 602
					loop: 1
					cel: 0
					x: 173
					y: 158
					priority: 15
					setCycle: CT 9 1 self
				)
			)
			(9
				((ScriptID 2 0) init: 6 1 self) ; Delphineus, "I'm outta here to grab some air, dude! Can't stop to chat! I'll see you outside."
			)
			(10
				(gSoundEffects number: 921 loop: 1 play:)
				(dolphin setCycle: End self)
			)
			(11
				(dolphin dispose:)
				(gEgo setCycle: End self)
			)
			(12
				(net dispose:)
				(NormalEgo 2)
				(gEgo
					posn: 198 92
					z: register
					setMotion: PolyPath 170 200 self
				)
			)
			(13
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance dolphinSwing of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(dolphin view: 603 loop: 4 cel: 0 setCycle: End self)
			)
			(1
				(dolphin view: 603 loop: 6 cel: 0 setCycle: Fwd)
			)
			(2
				(dolphin view: 603 loop: 4 cel: 0 setCycle: End self)
			)
			(3
				(dolphin view: 603 loop: 6 cel: 0 setCycle: Fwd)
			)
			(4
				(dolphin view: 603 loop: 5 cel: 0 setCycle: End self)
			)
			(5
				(= state 1)
				(dolphin view: 603 loop: 6 cel: 0 setCycle: Fwd)
			)
		)
	)
)

(instance mantaCartoon of Script
	(properties)

	(method (init)
		(super init: &rest)
		(self setScript: (ScriptID 127 0) 0 918) ; delSpeakScript
	)

	(method (changeState newState &tmp [temp0 500])
		(switch (= state newState)
			(0
				(HandsOff)
				(dolphin setPri: 9)
				(manta
					loop: 0
					cel: 0
					posn: 132 71
					cycleSpeed: 20
					init:
					setPri: 8
					setCycle: CT 5 1 self
				)
			)
			(1
				(dolphin setScript: dolphinSwing)
				(manta setCycle: End self)
			)
			(2
				(Narrator init: 19 self) ; "Meanwhile, Delphineus is reliving the nightmare of being trapped in a driftnet, unable to reach the surface for air, unable to free himself. This time, however, Flesh-Eater is there to add to his terror as he circles the dolphin, waiting for his victim's struggles to cease."
			)
			(3
				(manta hide:)
				(= seconds 3)
			)
			(4
				(manta
					show:
					loop: 1
					cel: 0
					posn: 141 78
					cycleSpeed: 20
					setPri: 8
					setCycle: CT 3 1 self
				)
			)
			(5
				(dolphinSwing cue:)
				(manta setCycle: End self)
			)
			(6
				(manta hide:)
				(= seconds 3)
			)
			(7
				(manta
					show:
					loop: 2
					cel: 0
					posn: 214 79
					cycleSpeed: 20
					setPri: 9
					setCycle: CT 3 1 self
				)
			)
			(8
				(dolphinSwing cue:)
				(manta setCycle: End self)
			)
			(9
				(manta hide:)
				(= seconds 3)
			)
			(10
				(manta
					show:
					loop: 1
					cel: 0
					posn: 141 78
					cycleSpeed: 20
					setPri: 8
					setCycle: CT 3 1 self
				)
			)
			(11
				(dolphinSwing cue:)
				(manta setCycle: End self)
			)
			(12
				(manta hide:)
				(= seconds 3)
			)
			(13
				(manta
					show:
					loop: 2
					cel: 0
					posn: 214 79
					cycleSpeed: 20
					setPri: 9
					setCycle: CT 3 1 self
				)
			)
			(14
				(dolphinSwing cue:)
				(manta setCycle: End self)
			)
			(15
				(manta hide:)
				(= seconds 3)
			)
			(16
				(dolphin setScript: 0)
				(manta
					show:
					view: 582
					setLoop: 0
					cel: 0
					setCycle: Fwd
					posn: 312 1
					setPri: -1
					setMotion: MoveTo 237 64 self
				)
			)
			(17
				(= seconds 3)
			)
			(18
				(Narrator init: 20 self) ; "Just as Delphineus arrives at a grim acceptance of his fate, a challenge echoes from outside the lair."
			)
			(19
				(gSoundEffects number: 645 loop: 1 play:)
				(Print
					(GetMessage 16 600 29 @temp0)
					33
					310
					67
					-1
					15
					28
					global207
				)
				(Narrator init: 21 self) ; "Enraged that the great king has escaped his prison, Flesh-Eater wheels from the cave."
			)
			(20
				(HandsOn)
				(gCurRoom newRoom: 580)
			)
		)
	)
)

(instance seaweed1 of Prop
	(properties
		x 112
		y 184
		lookStr 7
		view 600
		priority 15
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10 ; Recycle
				(Narrator init: 31) ; "Adam has no time to think about cleaning up right now."
			)
			(3 ; Do
				(Narrator init: 17) ; "The fronds should be left alone."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance seaweed2 of Prop
	(properties
		x 48
		y 171
		lookStr 7
		view 600
		loop 1
		cel 1
		priority 15
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10 ; Recycle
				(Narrator init: 31) ; "Adam has no time to think about cleaning up right now."
			)
			(3 ; Do
				(Narrator init: 17) ; "The fronds should be left alone."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance seaweed3 of Prop
	(properties
		x 217
		y 185
		lookStr 7
		view 600
		loop 2
		cel 4
		priority 15
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10 ; Recycle
				(Narrator init: 31) ; "Adam has no time to think about cleaning up right now."
			)
			(3 ; Do
				(Narrator init: 17) ; "The fronds should be left alone."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance seaweed4 of Prop
	(properties
		y 189
		lookStr 7
		view 600
		loop 3
		cel 1
		priority 15
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10 ; Recycle
				(Narrator init: 31) ; "Adam has no time to think about cleaning up right now."
			)
			(3 ; Do
				(Narrator init: 17) ; "The fronds should be left alone."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance dolphin of Prop
	(properties
		x 176
		y 84
		lookStr 6
		view 602
		loop 2
		cel 3
		signal 16400
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Narrator init: 18) ; "Adam can't break through the nylon driftnet with his hands."
			)
			(4 ; Inventory
				(switch invItem
					(13 ; sharpShell
						(gCurRoom setScript: cutDownDelph)
					)
					(30 ; hackSaw
						(Narrator init: 23) ; "The hacksaw is too clumsy a tool to cut the net. Delphineus would be badly hurt."
					)
					(12 ; trident
						(Narrator init: 22) ; "Cutting the net with the trident would injure Delphineus."
					)
					(21 ; healingPotion
						(Narrator init: 24) ; "Demeter's medicine can't give air to the dolphin. Delphineus needs to get to the surface to breathe."
					)
					(14 ; tweezers
						(Narrator init: 25) ; "The tweezers aren't sharp enough to cut the net."
					)
					(17 ; spine
						(Narrator init: 26) ; "The venom carried in the spine would paralyze Delphineus. Then he'd never get to the surface for air."
					)
					(else
						(Narrator init: 27) ; "That won't cut the net. There isn't much time. Adam better think of something else!"
					)
				)
			)
			(5 ; Talk
				((ScriptID 2 1) init: 9 1) ; Adam, "I'll get you out as fast as I can. Hang in there, Delphineus. Don't give up on me!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance manta of Actor
	(properties
		x 141
		y 78
		view 603
		loop 1
		cel 4
		priority 6
		signal 16
		cycleSpeed 1
	)
)

(instance net of Actor
	(properties
		x 149
		y 77
		view 602
		loop 3
		signal 16384
		cycleSpeed 15
		xStep 6
	)
)

(instance skeletonBits of Feature
	(properties
		onMeCheck 16384
		lookStr 1
	)

	(method (doVerb theVerb)
		(self x: ((gUser curEvent:) x:) y: ((gUser curEvent:) y:))
		(switch theVerb
			(10 ; Recycle
				(Narrator init: 31) ; "Adam has no time to think about cleaning up right now."
			)
			(3 ; Do
				((ScriptID 2 1) init: 3 1) ; Adam, "Ugh. I think I'll leave those right there."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance skeleton1 of Feature
	(properties
		onMeCheck 8192
		lookStr 2
	)

	(method (doVerb theVerb)
		(self x: ((gUser curEvent:) x:) y: ((gUser curEvent:) y:))
		(switch theVerb
			(10 ; Recycle
				(Narrator init: 31) ; "Adam has no time to think about cleaning up right now."
			)
			(3 ; Do
				(Narrator init: 14) ; "Let him rest where he is."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance skeleton2 of Feature
	(properties
		onMeCheck 4096
		lookStr 3
	)

	(method (doVerb theVerb)
		(self x: ((gUser curEvent:) x:) y: ((gUser curEvent:) y:))
		(switch theVerb
			(10 ; Recycle
				(Narrator init: 31) ; "Adam has no time to think about cleaning up right now."
			)
			(3 ; Do
				((ScriptID 2 1) init: 2 1) ; Adam, "No way am I touching that thing!"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance hook of Feature
	(properties
		x 175
		y 64
		onMeCheck 2048
		lookStr 5
	)

	(method (doVerb theVerb invItem)
		(self x: ((gUser curEvent:) x:) y: ((gUser curEvent:) y:))
		(switch theVerb
			(10 ; Recycle
				(Narrator init: 31) ; "Adam has no time to think about cleaning up right now."
			)
			(4 ; Inventory
				(switch invItem
					(30 ; hackSaw
						(Narrator init: 10) ; "There isn't enough time to saw through the hook!"
					)
					(else
						(Narrator init: 11) ; "The iron hook would easily resist that."
					)
				)
			)
			(3 ; Do
				(Narrator init: 8) ; "The iron hook has lasted this long. Adam can't do anything about it."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

