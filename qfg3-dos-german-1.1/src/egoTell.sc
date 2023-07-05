;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 702)
(include sci.sh)
(use Main)
(use Teller)
(use PAvoider)
(use PolyPath)
(use StopWalk)
(use System)

(public
	egoTell 0
	startUp 1
)

(local
	[local0 11] = [0 -74 -75 37 -55 -73 32 28 -72 56 999]
	[local11 5]
	[local16 19] = [0 -25 -76 -27 -26 -28 -33 -34 -39 -40 -41 -42 -43 -44 48 -49 52 -53 999]
	[local35 6] = [0 -29 -30 -31 -32 999]
	[local41 5] = [0 -22 -23 -24 999]
	[local46 3] = [0 -50 999]
	[local49 3] = [0 51 999]
	[local52 3] = [0 54 999]
	[local55 16]
	[local71 7] = [0 -25 -28 -49 -53 -50 999]
	local78
	local79
	local80
	local81
	local82
	local83
)

(instance johariExit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((ScriptID 36 1) setMotion: PolyPath local78 145 self) ; Johari
				(= local80 1)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance goToVillage of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 92)
				(HandsOff)
				((ScriptID 36 1) setMotion: PolyPath local78 145 self) ; Johari
				(gEgo setAvoider: PAvoider setMotion: PolyPath local78 165)
			)
			(1
				(gCurRoom newRoom: gPrevRoomNum)
			)
		)
	)
)

(instance castLightning of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 10)
			)
			(1
				(gMessager say: 3 6 88) ; "This is how to cast a Lightning Bolt spell."
				(gEgo learn: 32 10 solvePuzzle: 318 4 2) ; lightningBallSpell
				(self dispose:)
			)
		)
	)
)

(instance startUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(if (IsFlag 102)
					(cond
						((& global431 $4000)
							(gMessager say: 4 6 60 0 self) ; "You hear something nearby."
						)
						((IsFlag 103)
							(gMessager say: 3 6 46 0 self) ; "A big monster should come and eat you up! Many times I have watched you from the jungle, and not once did you think to greet me. Why I should try to help you after being so insulted, I do not know."
						)
						(else
							(gMessager say: 3 6 47 0 self) ; "My father is not interested in your words of peace. He even ordered me to stay in the village and not to see you again. He speaks to me as if I were a child. I think he is a child if he thinks that this war will be good."
						)
					)
				else
					(gMessager say: 4 6 63 0 self) ; "You feel as if someone is watching you."
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance johariEntrance of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local80 0)
				(SetFlag 102)
				(= cycles 2)
			)
			(1
				(if (< (gEgo x:) 160)
					(gEgo setMotion: PolyPath 145 145 self)
					(= local78 350)
					((ScriptID 36 1) ; Johari
						view: 975
						x: 350
						y: 145
						init:
						noun: 3
						setScale: -1 gEgo
						setCycle: StopWalk 974
						setAvoider: PAvoider
						setMotion: PolyPath 175 145 self
					)
				else
					(gEgo setMotion: PolyPath 175 145 self)
					(= local78 -20)
					((ScriptID 36 1) ; Johari
						view: 975
						x: -20
						y: 145
						noun: 3
						init:
						setScale: -1 gEgo
						setAvoider: PAvoider
						setCycle: StopWalk 974
						setMotion: PolyPath 145 145 self
					)
				)
			)
			(2
				(if (gEgo mover:)
					(= local83 1)
				else
					(Face gEgo (ScriptID 36 1)) ; Johari
				)
			)
			(3
				(if local83
					(Face gEgo (ScriptID 36 1)) ; Johari
				)
				(= cycles 10)
			)
			(4
				(cond
					((& global431 $8000)
						(gMessager say: 3 6 21 0 self 700) ; "So, you may have paid the cow people bride price for me, but I am not your wife. You cannot buy me."
					)
					((& global431 $4000)
						(gMessager say: 3 6 38 0 self 700) ; "You still trying to get eaten or are you looking for my village? You need someone like that cow man Yesufu to protect you in this jungle."
					)
					(else
						(self cue:)
					)
				)
			)
			(5
				(= [local55 0] @local16)
				(= [local55 1] @local35)
				(= [local55 2] @local41)
				(= [local55 3] @local46)
				(= [local55 4] @local49)
				(= [local55 5] @local52)
				(johariTell init: (ScriptID 36 1) @local16 @local55 @local71) ; Johari
				(= cycles 5)
			)
			(6
				(HandsOn)
				(= cycles 1)
			)
			(7
				(gTheIconBar disable: 6)
				(self dispose:)
			)
		)
	)
)

(instance johariTell of Teller
	(properties)

	(method (doVerb theVerb)
		(if (== theVerb 57) ; theMagicDrum
			(gMessager say: 3 57) ; "Thank you, but I am not allowed to touch the Drum of Magic. You should keep it and we will go to my village together. This way, when you give the Drum of Magic to my father, you can speak of peace and he will listen."
			(gEgo solvePuzzle: 320 8 setScript: goToVillage)
		else
			(super doVerb: theVerb &rest)
		)
	)

	(method (showDialog)
		(if (== local81 local82)
			(if (& global431 $8000)
				(gMessager say: 3 6 35) ; "You sure do like to talk. I will go now, so don't bother trying to follow me. I can hear and see you in the jungle, but you will not hear or see me unless I let you."
			else
				(gMessager say: 3 6 45) ; "I will talk to my father about what you have said. Maybe we can stop a war. I will see you again."
			)
			(SetFlag 105)
			((ScriptID 36 1) setScript: johariExit) ; Johari
			(return -999)
		else
			(super
				showDialog:
					-25 ; "Name"
					(& global431 $8000)
					-76 ; "Village"
					(& global431 $8000)
					-27 ; "Leopardmen"
					(& global431 $8000)
					-26 ; "Jungle"
					(& global431 $8000)
					-28 ; "War"
					(& global431 $8000)
					-33 ; "Cow People"
					(& global431 $8000)
					-34 ; "Magic"
					(and (& global431 $8000) [gEgoStats 12]) ; magic use
					-39 ; "Johari"
					(& global431 $4000)
					-40 ; "Village"
					(& global431 $4000)
					-41 ; "Leopardmen"
					(& global431 $4000)
					-42 ; "Yesufu"
					(& global431 $4000)
					-43 ; "Capture"
					(& global431 $4000)
					-44 ; "Magic"
					(and (& global431 $4000) [gEgoStats 12]) ; magic use
					48 ; "Johari"
					(& global431 $2000)
					-49 ; "Village"
					(& global431 $2000)
					52 ; "Leopardmen"
					(& global431 $2000)
					-53 ; "Spear of Death"
					(& global431 $2000)
			)
		)
	)

	(method (doChild param1 &tmp [temp0 10])
		(switch param1
			(-25 ; "Name"
				(|= local81 $0001)
				(super doChild: param1)
			)
			(-76 ; "Village"
				(|= local81 $0002)
				(return 1)
			)
			(-27 ; "Leopardmen"
				(|= local81 $0004)
				(return 1)
			)
			(-26 ; "Jungle"
				(|= local81 $0008)
				(return 1)
			)
			(-28 ; "War"
				(|= local81 $0010)
				(super doChild: param1)
			)
			(-33 ; "Cow People"
				(|= local81 $0020)
				(return 1)
			)
			(-34 ; "Magic"
				(|= local81 $0040)
				(return 1)
			)
			(-39 ; "Johari"
				(|= local81 $0001)
				(return 1)
			)
			(-40 ; "Village"
				(|= local81 $0002)
				(return 1)
			)
			(-41 ; "Leopardmen"
				(|= local81 $0004)
				(return 1)
			)
			(-42 ; "Yesufu"
				(|= local81 $0080)
				(return 1)
			)
			(-43 ; "Capture"
				(|= local81 $0100)
				(return 1)
			)
			(-44 ; "Magic"
				(|= local81 $0040)
				((ScriptID 36 1) setScript: castLightning) ; Johari
				(return 1)
			)
			(-29 ; "Drum of Magic"
				(|= local81 $0200)
				(return 1)
			)
			(-30 ; "Spear of Death"
				(|= local81 $0400)
				(return 1)
			)
			(-31 ; "Peace"
				(|= local81 $0800)
				(return 1)
			)
			(-32 ; "Peace Mission"
				(|= local81 $1000)
				(return 1)
			)
			(-22 ; "Leader"
				(|= local81 $2000)
				(return 1)
			)
			(-23 ; "Shape Changers"
				(|= local81 $4000)
				(return 1)
			)
			(-24 ; "Spells"
				(|= local81 $8000)
				(return 1)
			)
			(else
				(super doChild: param1)
			)
		)
	)
)

(instance egoTell of Teller
	(properties)

	(method (init)
		(if (& global431 $2000)
			(= local79 1)
			(gEgo setScript: johariEntrance)
		)
		(cond
			((& global431 $8000)
				(if [gEgoStats 12] ; magic use
					(= local82 -385)
				else
					(= local82 -449)
				)
			)
			([gEgoStats 12] ; magic use
				(= local82 455)
			)
			(else
				(= local82 391)
			)
		)
		(gTheIconBar disable: 6)
		(= [local11 0] @local0)
		(super init: gEgo @local0 @local11)
	)

	(method (showDialog)
		(if (not local80)
			(super
				showDialog:
					-74 ; "Call Out"
					(and (& global431 $8000) (not local79))
					-75 ; "Call Out"
					(and (& global431 $4000) (not local79))
					37 ; "Make Friends"
					(and (& global431 $8000) local79)
					-55 ; "Tell about Drum"
					(and (gEgo has: 46) local79) ; theMagicDrum
					-73 ; "Tell about Peace"
					(and (& global431 $2000) local79)
					32 ; "Tell about Mission"
					(and (& global431 $4000) local79)
					28 ; "Tell about War"
					(and (& global431 $4000) local79)
					-72 ; "Good-bye"
					(and (or (& global431 $8000) (& global431 $4000)) local79)
					56 ; "Say Good-bye"
					(and (& global431 $2000) local79)
			)
		else
			(client doVerb: 2)
			(return -999)
		)
	)

	(method (doChild param1)
		(cond
			((== param1 -74) ; "Call Out"
				(= local79 1)
				(gEgo solvePuzzle: 319 3 setScript: johariEntrance)
			)
			((== param1 -75) ; "Call Out"
				(= local79 1)
				(gEgo setScript: johariEntrance)
			)
			((== param1 -55) ; "Tell about Drum"
				(gEgo setScript: goToVillage)
			)
			((== param1 -72) ; "Good-bye"
				(SetFlag 105)
				(gEgo setScript: johariExit)
			)
			((== param1 -73) ; "Tell about Peace"
				(gEgo solvePuzzle: 320 8 setScript: goToVillage)
			)
		)
		(return 1)
	)
)

