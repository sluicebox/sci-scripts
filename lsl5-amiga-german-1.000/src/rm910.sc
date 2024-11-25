;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 910)
(include sci.sh)
(use Main)
(use eRS)
(use Talker)
(use Feature)
(use Motion)
(use Inventory)
(use User)
(use Actor)
(use System)

(public
	rm910 0
)

(local
	[local0 2]
	local2
	local3
	[local4 2]
	local6
)

(instance rm910 of LLRoom
	(properties
		picture 910
		east 905
	)

	(method (init)
		((Inv at: 22) state: 0) ; Doily
		(Load rsVIEW 910)
		(Load rsVIEW 911)
		(Load rsVIEW 912)
		(Load rsVIEW 913)
		(super init:)
		(gEgo
			init:
			normalize:
			view: 911
			setLoop: 0
			setCycle: 0
			posn: 152 100 -5
			setCel: 0
			setPri: 7
		)
		(faucet init: cycleSpeed: 28 setCycle: Fwd)
		(drill init:)
		(light init:)
		(degree init:)
		(theWindow init:)
		(chair init:)
		(dentalTools init:)
		(sink init:)
		(mouthPic init:)
		(SetupExit 1)
		(HandsOn)
		(SetFlag 4) ; fSeenCC
		(chiChi init:)
		(switch gPrevRoomNum
			(915
				(chiChi
					view: 913
					posn: 185 105
					setLoop: 5
					setCel: 0
					cycleSpeed: 8
				)
				(if (IsFlag 51) ; fScoredCC
					(gEgo setCel: 1)
					(gCurRoom setScript: sScored)
				else
					(gEgo setCel: 4)
					(= local2 25)
					(gCurRoom setScript: sWorkOnTeeth)
				)
			)
			(else
				(HandsOff)
				(gTheMusic number: 910 loop: -1 play:)
				(gCurRoom setScript: sBringInChiChi)
			)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 910 0) ; "Chi Chi Lambada's Dental Hygiene Heaven cubicle is far from typical. Instead of Muzak, hot salsa music plays over a powerful stereo system. And how strange: the center of the carpet shows signs of extensive wear."
			)
			(4 ; Inventory
				(switch invItem
					(21 ; Green_Card
						(TPrint 910 1) ; "Try establishing eye contact first."
					)
					(else
						(TPrint 910 2) ; "She's not interested in that, Larry. Talk to her; use your charm."
					)
				)
			)
			(5 ; Talk
				(TPrint 910 1) ; "Try establishing eye contact first."
			)
			(10 ; Zipper
				(TPrint 910 3) ; "Is that the only thing on your mind?"
				(TPrint 910 4 #at -1 185) ; "(Don't answer that!)"
			)
			(1 ; Walk
				(HandsOff)
				(Say gEgo 910 5) ; "I can't take any more of this, Ms. Lambada," you cry, "I hate the taste of latex gloves!"
				(gTheMusic fade:)
				(gCurRoom newRoom: 905)
			)
			(3 ; Do
				(Say gEgo 910 6) ; "You know, Ms. Lambada," you say as she inserts her hands into your mouth, "I wmwpafz fqpzvi uht cpwexf kpazxccxwq!"
			)
			(else
				(TPrint 910 7) ; "You can't do that while lying in a dentist's chair."
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (!= local3 (GetTime 1)) ; SysTime12
			(= local3 (GetTime 1)) ; SysTime12
			(++ local2)
		)
	)
)

(instance faucet of Prop
	(properties
		x 225
		y 135
		description {the faucet}
		sightAngle 90
		lookStr {The faucet is drip-, drip-, dripping, right in time to the music that's playing!}
		view 910
		loop 1
		priority 8
		signal 18448
	)
)

(instance mouthPic of Feature
	(properties
		x 198
		y 48
		nsTop 33
		nsLeft 176
		nsBottom 63
		nsRight 221
		description {the happy tooth poster}
		sightAngle 40
		lookStr {If you maintained a regular schedule of oral hygiene with Chi Chi Lambada, your teeth would be happy too!}
	)
)

(instance drill of Feature
	(properties
		x 149
		y 33
		nsTop 19
		nsLeft 123
		nsBottom 47
		nsRight 175
		description {the drill}
		sightAngle 40
		lookStr {Whenever you see a high-speed dental drill, you make a silent vow to floss more often!}
	)
)

(instance sink of Feature
	(properties
		x 217
		y 132
		nsTop 118
		nsLeft 193
		nsBottom 146
		nsRight 242
		description {the sink}
		sightAngle 40
		lookStr {You love it when a woman orders you to "Spit!"}
	)
)

(instance dentalTools of Feature
	(properties
		x 124
		y 110
		nsTop 80
		nsLeft 80
		nsBottom 141
		nsRight 169
		description {the tray of dental tools}
		sightAngle 40
		lookStr {You've always believed dental professionals have latent masochistic tendencies.}
	)
)

(instance chair of Feature
	(properties
		x 160
		y 93
		nsTop 60
		nsLeft 119
		nsBottom 127
		nsRight 202
		description {the dentist's chair}
		sightAngle 40
		lookStr {You just love electric furniture!}
	)
)

(instance theWindow of Feature
	(properties
		x 93
		y 48
		nsTop 21
		nsLeft 81
		nsBottom 76
		nsRight 106
		description {the window}
		sightAngle 40
		lookStr {Through the window you see children laughing, skipping, running, playing; all oblivious to their oral hygiene!}
	)
)

(instance degree of Feature
	(properties
		x 123
		y 51
		nsTop 41
		nsLeft 112
		nsBottom 61
		nsRight 134
		description {Chi Chi's degree}
		sightAngle 40
		lookStr {Interesting. You never knew the Columbia School of Broadcasting even HAD a dental college!}
	)
)

(instance light of Feature
	(properties
		x 155
		y 50
		nsTop 43
		nsLeft 147
		nsBottom 58
		nsRight 163
		description {the spotlight}
		sightAngle 40
		lookStr {You love to peer at the reflection of your mouth on the surface of the dental spotlight.}
	)
)

(instance Chi_Chi_Lambada of Talker
	(properties
		name {Chi Chi Lambada}
		nsTop 33
		nsLeft 22
		view 1910
		loop 3
		viewInPrint 1
	)

	(method (init)
		(= bust talkerBust)
		(= eyes talkerEyes)
		(= mouth talkerMouth)
		(super init:)
	)
)

(instance talkerBust of View
	(properties
		view 1910
		loop 1
	)
)

(instance talkerEyes of Prop
	(properties
		nsTop 25
		nsLeft 34
		view 1910
		loop 2
		cycleSpeed 18
	)
)

(instance talkerMouth of Prop
	(properties
		nsTop 33
		nsLeft 27
		view 1910
	)
)

(instance sCloseUp of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 2)
			)
			(1
				(chiChi setLoop: 5 setCel: 255 setCycle: Beg self)
			)
			(2
				(gCurRoom newRoom: 915)
			)
		)
	)
)

(instance sBringInChiChi of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 60)
			)
			(1
				(Say gEgo 910 8 #dispose self) ; "You think to yourself, "Where else do you pay someone lots of money to insert metal objects into your mouth in order to inflict lots of pain?""
			)
			(2
				(= ticks 60)
			)
			(3
				(gEgo setCel: 1 cycleSpeed: 6)
				(= ticks 30)
			)
			(4
				(TPrint 910 9 #dispose self) ; "You hear someone coming."
			)
			(5
				(= seconds 3)
			)
			(6
				(chiChi
					view: 912
					setLoop: 1
					setCel: -1
					setCycle: Fwd
					cycleSpeed: 6
					setStep: 3 2
					moveSpeed: 6
					ignoreActors: 1
					illegalBits: 0
					setMotion: MoveTo 185 105 self
				)
			)
			(7
				(chiChi view: 913 setLoop: 1 setCel: 0 setCycle: 0 setMotion: 0)
				(= ticks 30)
			)
			(8
				(Say Chi_Chi_Lambada 910 10 #dispose #caller self) ; "Well, Mr. Laffer, shall we get started?"
			)
			(9
				(gEgo setCel: 0 stopUpd:)
				(= ticks 30)
			)
			(10
				(Say gEgo 910 11 #at -1 185) ; "Oh, I don't know," you protest. "I hate dental work so much, I think I'd rather have a baby!"
				(= ticks 60)
			)
			(11
				(Say Chi_Chi_Lambada 910 12 #dispose #caller self) ; "Well, make up your mind," says Chi Chi. "I've gotta adjust the chair!"
				(gEgo setCel: 2 stopUpd:)
			)
			(12
				(= ticks 60)
			)
			(13
				(chiChi
					view: 913
					setLoop: 5
					setCel: 0
					cycleSpeed: 8
					setCycle: End self
				)
				(gEgo setCel: 4 stopUpd:)
			)
			(14
				(= seconds 4)
			)
			(15
				(HandsOn)
				(User canControl: 0)
				(gTheMusic2 stop:)
				(= local2 0)
				(= seconds 4)
			)
			(16
				(Say Chi_Chi_Lambada 910 13 #dispose #caller self) ; "Say, Larry. Have you ever considered dental floss as an aphrodisiac?"
			)
			(17
				(gCurRoom setScript: sWorkOnTeeth)
			)
		)
	)
)

(instance sWorkOnTeeth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(chiChi
					cycleSpeed: (Random 3 6)
					setLoop: 6
					setCel: 0
					setCycle: End self
				)
			)
			(1
				(if (and (> local2 30) (not local6))
					(Say Chi_Chi_Lambada 910 14 #dispose #caller self) ; "Just a few more seconds and I'll have that nasty old tooth of yours pu..., er, uh, cleaned!"
					(= local6 1)
				else
					(= ticks 60)
				)
			)
			(2
				(= ticks 30)
			)
			(3
				(chiChi setCycle: Beg self)
			)
			(4
				(= ticks 60)
			)
			(5
				(if (> local2 35)
					(HandsOff)
					(Say Chi_Chi_Lambada 910 15 #dispose #caller self) ; "I'm all done, Mr. Laffer!"
					(chiChi
						setLoop: 5
						setCel: 255
						cycleSpeed: 8
						setCycle: Beg self
					)
					(gTheMusic fade:)
				else
					(self init:)
				)
			)
			(6 0)
			(7
				(gCurRoom newRoom: 905)
			)
		)
	)
)

(instance sDance of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(= register 30)
				(self cue:)
			)
			(1
				(= start state)
				(chiChi
					view: 913
					setLoop: (Random 2 4)
					setCycle: Fwd
					cycleSpeed: (Random 5 12)
				)
				(= ticks (Random 10 30))
			)
			(2
				(if (not (-- register))
					(self dispose:)
				else
					(self init:)
				)
			)
		)
	)
)

(instance chiChi of Actor
	(properties
		x 259
		y 105
		description {Chi Chi Lambada}
		sightAngle 90
		view 912
		priority 8
		signal 18448
	)

	(method (cue)
		(super cue:)
		(gCurRoom newRoom: 915)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(TPrint 910 16) ; "Wow! You can now readily understand how she got that name! Take a look at those Chi Chi's!"
			)
			(2 ; Look
				(HandsOff)
				(gCurRoom setScript: 0)
				(chiChi setLoop: 5 setCel: 255 cycleSpeed: 8 setCycle: Beg self)
			)
			(5 ; Talk
				(TPrint 910 1) ; "Try establishing eye contact first."
			)
			(10 ; Zipper
				(Say Chi_Chi_Lambada 910 17 #dispose) ; "Well, I might be interested, Larry," says Chi Chi. "But what about a little conversation first?"
			)
			(1 ; Walk
				(gCurRoom doVerb: 1)
			)
			(else
				(TPrint 910 1) ; "Try establishing eye contact first."
			)
		)
	)
)

(instance sScored of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 2)
			)
			(1
				(gEgo setCel: 1)
				(self setScript: sDance self)
			)
			(2
				(chiChi setCycle: 0 stopUpd:)
				(Points 40 165)
				(Say Chi_Chi_Lambada 910 18 #dispose #caller self) ; "Why don't we go downstairs to my apartment behind the gymnastics studio where I'll be able to express my appreciation in a more acceptable manner?"
			)
			(3
				(= ticks 90)
			)
			(4
				(TPrint 910 19 #at -1 185 #width 280) ; "(All right, Larry! It sounds like you're going to get a home-cooked meal for a change!)"
				(= ticks 123)
			)
			(5
				(faucet dispose:)
				(chiChi dispose:)
				(gEgo dispose:)
				(gCurRoom drawPic: 1 6)
				(= seconds 3)
			)
			(6
				(gTheMusic fade:)
				(CenterDisplay 3 gColWhite 910 20)
				(= seconds 3)
			)
			(7
				(gCurRoom newRoom: 920)
			)
		)
	)
)

