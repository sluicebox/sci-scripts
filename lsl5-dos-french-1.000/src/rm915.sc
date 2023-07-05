;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 915)
(include sci.sh)
(use Main)
(use eRS)
(use Talker)
(use Feature)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm915 0
)

(local
	blouseOpen
	oldTime
	closeUpSecs
	talkCounter
	buttonCounter
)

(instance rm915 of LLRoom
	(properties
		picture 915
	)

	(method (init)
		(Load rsVIEW 1915)
		(Load rsVIEW 915)
		(Load rsVIEW 916)
		(super init:)
		(chichis init:)
		(herEye init:)
		(herMouth init: hide:)
		(herButton init:)
		(boobs init: hide:)
		(HandsOn)
		(SetupExit 1)
		(User canControl: 0)
		(= closeUpSecs 30)
		(if (!= gPrevRoomNum 910)
			(gTheMusic number: 910 loop: -1 play:)
			(gEgo get: 21) ; Green_Card
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(switch (Random 1 2)
					(1
						(TPrint 915 0) ; "Wow! You can now readily understand how she got that name! Take a look at those Chi Chi's!"
					)
					(2
						(TPrint 915 1) ; "Wow, what a babe! Chi Chi Lambada is the perfect name for this Latin beauty!"
					)
				)
			)
			(4 ; Inventory
				(switch invItem
					(21 ; Green_Card
						(HandsOff)
						(Points 15)
						(gCurRoom setScript: sGiveGreen)
					)
					(else
						(TPrint 915 2) ; "She's not interested in that, Larry. Talk to her; use your charm."
					)
				)
			)
			(5 ; Talk
				(HandsOff)
				(gCurRoom setScript: sTalk)
			)
			(10 ; Zipper
				(switch (Random 1 2)
					(1
						(Say Chi_Chi_Lambada_FChi_Chi_Lambada 915 3 108) ; "Don't rush me, Big Guy!" says Chi Chi. "You've still got a little plaque on those bicuspids."
					)
					(2
						(Say Chi_Chi_Lambada_FChi_Chi_Lambada 915 4 108) ; "Perhaps... if you'll just hold still a little while."
					)
				)
			)
			(3 ; Do
				(TPrint 915 5) ; "Wow! You can now readily understand how she got that name! Take a look at those Chi Chi's!"
			)
			(1 ; Walk
				(HandsOff)
				(Say gEgo 915 6) ; "I can't take any more of this, Ms. Lambada," you cry, "I hate the taste of latex gloves!"
				(gTheMusic fade:)
				(SetFlag 4)
				(gCurRoom newRoom: 905)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (!= oldTime (GetTime 1)) ; SysTime12
			(= oldTime (GetTime 1)) ; SysTime12
			(if (not (-- closeUpSecs))
				(HandsOff)
				(gCurRoom setScript: sBackToWork)
			)
		)
	)
)

(instance sTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= closeUpSecs 1000)
				(= cycles 2)
			)
			(1
				(switch (++ talkCounter)
					(1
						(Say gEgo 915 7 108 self) ; "Oh, Chi Chi," you say, "has anyone ever told you you're beautiful?"
					)
					(2
						(Say gEgo 915 8 108 self) ; ""Does the name `Bucky Beaver' mean anything to you?" you ask Chi Chi."
					)
					(3
						(Say ; ""Oh, I do hope illegal actions don't bother you, Larry!" says Chi Chi."
							Chi_Chi_Lambada_FChi_Chi_Lambada
							915
							9
							108
							139
							self
						)
					)
					(4
						(TPrint 915 10 67 -1 185 108 self) ; "Waiting until your mouth is full of equipment, Chi Chi asks you a question."
					)
					(5
						(Say ; "I hope it doesn't bother you if I occasionally rub up against your elbow... like this. Sometimes when I hear that salsa music, I get so excited I just can't control myself!"
							Chi_Chi_Lambada_FChi_Chi_Lambada
							915
							11
							108
							139
							self
						)
					)
				)
			)
			(2
				(= ticks 30)
			)
			(3
				(switch talkCounter
					(1
						(Say Chi_Chi_Lambada_FChi_Chi_Lambada 915 12 108) ; "Yes."
						(= ticks 123)
					)
					(2
						(Say Chi_Chi_Lambada_FChi_Chi_Lambada 915 13 108) ; ""Well, I suppose I've heard worse!" she responds."
						(= ticks 123)
					)
					(3
						(Say gEgo 915 14 108 self) ; ""Well, I dunno," you respond."
					)
					(4
						(Say Chi_Chi_Lambada_FChi_Chi_Lambada 915 15 108) ; "Have you ever considered dental floss an aphrodisiac?"
						(= ticks 123)
					)
					(5
						(Say gEgo 915 16 108 self) ; ""I know what you mean," you say."
					)
				)
			)
			(4
				(switch talkCounter
					(1
						(TPrint 915 17 67 -1 185 108 self) ; "(You're going to have to do better than that line, Larry!)"
					)
					(2
						(HandsOn)
						(User canControl: 0)
						(= closeUpSecs 30)
					)
					(3
						(Say Chi_Chi_Lambada_FChi_Chi_Lambada 915 18 108) ; "Oh, nothing much, I suppose. I really meant to jump in on that amnesty deal a few years ago, but I just forgot, I guess."
						(= ticks 123)
					)
					(4
						(Say gEgo 915 19 108 self) ; ""Owefggh wfqqafd," you reply."
					)
					(5
						(SetFlag 51)
						(Points 5)
						(gCurRoom newRoom: 910)
					)
				)
			)
			(5
				(switch talkCounter
					(1
						(HandsOn)
						(User canControl: 0)
						(= closeUpSecs 30)
					)
					(3
						(Say gEgo 915 20 108 self) ; "Amnesty? Chi Chi?" you interject. "Are you an `undocumented worker?'"
					)
					(4
						(HandsOn)
						(User canControl: 0)
						(= closeUpSecs 30)
					)
				)
			)
			(6
				(Say Chi_Chi_Lambada_FChi_Chi_Lambada 915 21 108 139 self) ; "Yes, I guess I am," she replies. "Although I'd do anything for the man who could help me become a citizen."
			)
			(7
				(= ticks 60)
			)
			(8
				(Say Chi_Chi_Lambada_FChi_Chi_Lambada 915 22 108 139 self) ; "Say," she pauses and looks deep into your eyes, "you wouldn't have any ideas about this, would you?"
			)
			(9
				(= ticks 60)
			)
			(10
				(Say gEgo 915 23 108 self) ; "Uh, no, I can't think of anything right now," you say with a grin. "But if something pops up, I feel certain I'll think of you!"
			)
			(11
				(HandsOn)
				(User canControl: 0)
				(= closeUpSecs 30)
			)
		)
	)
)

(instance chichis of Feature
	(properties
		x 163
		y 255
		z 100
		nsTop 137
		nsLeft 113
		nsBottom 173
		nsRight 213
		description {her chi chis}
		sightAngle 40
	)

	(method (doVerb)
		(gCurRoom doVerb: &rest)
	)
)

(instance herButton of Feature
	(properties
		x 158
		y 338
		z 200
		nsTop 131
		nsLeft 149
		nsBottom 146
		nsRight 167
		description {her button}
		sightAngle 40
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 3) ; Do
				(if (not blouseOpen)
					(if (< (++ buttonCounter) 6)
						(HandsOff)
						(gCurRoom setScript: sStopThat)
					else
						(HandsOff)
						(gTheIconBar disable:)
						(TPrint 915 24) ; "Now, Larry! Stop that!!"
						(Points 2 166)
						(boobs show:)
						(= blouseOpen 1)
						(Delay 3 2 boobs)
					)
				)
			)
			((== theVerb 2) ; Look
				(TPrint 915 25) ; "As much as you try to prevent it, your eyes are attracted to the vicinity of her button; is that thread straining?"
			)
			(else
				(gCurRoom doVerb: theVerb &rest)
			)
		)
	)
)

(instance boobs of Prop
	(properties
		x 160
		y 172
		description {her chi chis}
		sightAngle 90
		view 916
		priority 14
		signal 18448
	)

	(method (cue)
		(gCurRoom setScript: sHideBoobs)
	)

	(method (doVerb)
		(gCurRoom doVerb: &rest)
	)
)

(instance Chi_Chi_Lambada_FChi_Chi_Lambada of Talker
	(properties
		name {Chi Chi Lambada}
		x 50
		y 140
		nsTop 68
		nsLeft 151
		view 1915
		loop 3
		talkWidth 220
	)

	(method (init)
		(= mouth talkerMouth)
		(super init:)
	)
)

(instance talkerMouth of Prop
	(properties
		view 1915
	)
)

(instance herEye of Prop
	(properties
		x 170
		y 55
		description {her eyes}
		sightAngle 90
		view 915
		priority 14
		signal 18448
	)

	(method (doVerb theVerb invItem)
		(gCurRoom doVerb: theVerb &rest)
	)
)

(instance herMouth of Prop
	(properties
		x 157
		y 169
		z 100
		description {her mouth}
		sightAngle 90
		view 915
		loop 2
		priority 14
		signal 18448
	)
)

(instance sBackToWork of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= closeUpSecs 1000)
				(= cycles 2)
			)
			(1
				(Say Chi_Chi_Lambada_FChi_Chi_Lambada 915 26 108 139 self) ; "If you've stared at me long enough, Mr. Laffer, it's time for me to get back into your mouth!"
			)
			(2
				(= ticks 30)
			)
			(3
				(herEye setCycle: End self)
			)
			(4
				(= ticks 60)
			)
			(5
				(herEye setCycle: Beg self)
			)
			(6
				(= ticks 30)
			)
			(7
				(gCurRoom newRoom: 910)
			)
		)
	)
)

(instance sHideBoobs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= closeUpSecs 1000)
				(= buttonCounter 0)
				(= blouseOpen 0)
				(= cycles 2)
			)
			(1
				(Say Chi_Chi_Lambada_FChi_Chi_Lambada 915 27 108 139 self) ; "Hey! Just a minute here! If anybody's going to undo my button, it's me!"
			)
			(2
				(boobs hide:)
				(gTheIconBar enable:)
				(= ticks 90)
			)
			(3
				(= seconds 2)
			)
			(4
				(herEye setCycle: End self)
			)
			(5
				(= ticks 60)
			)
			(6
				(herEye setCycle: Beg self)
			)
			(7
				(= ticks 30)
			)
			(8
				(HandsOn)
				(= closeUpSecs 20)
				(self dispose:)
			)
		)
	)
)

(instance sStopThat of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= closeUpSecs 1000)
				(= cycles 2)
			)
			(1
				(Say Chi_Chi_Lambada_FChi_Chi_Lambada 915 28 108 139 self) ; "Hey! What do you think you're doing?!"
			)
			(2
				(= ticks 20)
			)
			(3
				(herMouth show: setLoop: 2 setCel: 0 setCycle: End self)
			)
			(4
				(= ticks 60)
			)
			(5
				(herMouth setCycle: Beg self)
			)
			(6
				(herMouth hide:)
				(= closeUpSecs 20)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sGiveGreen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= closeUpSecs 1000)
				(= cycles 2)
			)
			(1
				(Say gEgo 915 29 108 self) ; ""You know, Chi Chi, I bet a girl like you could use something like this," you say, offering her the green card you "found" at the airport."
			)
			(2
				(= ticks 60)
			)
			(3
				(Say Chi_Chi_Lambada_FChi_Chi_Lambada 915 30 108 139 self) ; "Could I?" says Chi Chi. "Oh, Larry! You've made me the happiest woman in Miami. Now I'll be able to move to Central California!"
			)
			(4
				(herMouth dispose:)
				(herEye dispose:)
				(= ticks 60)
			)
			(5
				(gEgo put: 21) ; Green_Card
				(SetFlag 51)
				(gCurRoom newRoom: 910)
			)
		)
	)
)

