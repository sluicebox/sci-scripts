;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 330)
(include sci.sh)
(use Main)
(use Teller)
(use OccasionalCycle)
(use Talker)
(use Feature)
(use LoadMany)
(use Timer)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm330 0
	rajahTalker 1
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
	[local8 20] = [0 -9 -26 -45 -4 -8 -28 -32 -33 -40 -11 -12 -34 -39 -5 -13 -29 -35 -38 999]
	[local28 11] = [0 -16 -6 -19 -24 -17 -14 -15 -30 -44 999]
	[local39 4] = [0 11 18 999]
	[local43 4]
	[local47 5]
	[local52 3] = [0 -14 999]
)

(instance rm330 of Rm
	(properties
		noun 11
		picture 330
		vanishingY 1
	)

	(method (init)
		(LoadMany rsSCRIPT 924 928)
		(LoadMany rsVIEW 961)
		(= [local43 0] @local8)
		(= [local47 0] @local28)
		(= [local47 1] @local39)
		(gEgo noun: 2)
		(egoPic init: actions: tell)
		(tell init: gEgo @local8 @local43)
		(rajahTeller init: rajah @local28 @local47 @local52)
		(rajah init: setCycle: OccasionalCycle self 5 70 180)
		(rajahRightArm init: setCycle: OccasionalCycle self 1 70 180)
		(localRakeesh init:)
		(cheeseCake1 init: setCycle: OccasionalCycle self 1 30 100)
		(cheeseCake2 init:)
		(flame1 init: setCycle: Fwd)
		(flame2 init: setCycle: OccasionalCycle self 1 30 80)
		(lightglobe init:)
		(spittoon init:)
		(hieroglyphics init:)
		(incenseburner init:)
		(gWalkHandler addToFront: self)
		(super init:)
		(gLongSong number: 330 setLoop: -1 play: 127)
		(if (IsFlag 48)
			(gCurRoom setScript: situationTwo)
		else
			(SetFlag 48)
			(gCurRoom setScript: situationOne)
		)
	)

	(method (dispose)
		((gEgo actions:) dispose:)
		(gEgo actions: 0)
		(gWalkHandler delete: self)
		(gTimers eachElementDo: #dispose eachElementDo: #delete release:)
		(UnLoad 128 961)
		(LoadMany 0 35)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 3) ; Walk
			(gCurRoom newRoom: 320)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance situationOne of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_13)
				(= cycles 5)
			)
			(1
				(= local3 1)
				(gMessager say: 1 2 1 0 self) ; "You may enter into the presence of Rajah Sah Tarna."
			)
			(2
				((Timer new:) setReal: self 10)
			)
			(3
				(= local3 2)
				(gMessager say: 1 2 7 1 self) ; "Rakeesh, you brought along this Prince of Shapeir to help you bring peace. How can a human be of such service to a Liontaur?"
			)
			(4
				(gMessager say: 1 2 7 (+ gHeroType 2) self) ; Thief
			)
			(5
				((Timer new:) setReal: self 10)
			)
			(6
				(if (& local3 $0400)
					((Timer new:) setReal: self 5)
				else
					(self cue:)
				)
			)
			(7
				(if register
					(= register 0)
				else
					(= local5 1)
					(gEgo addHonor: -10)
				)
				(= local3 4)
				(gMessager say: 1 2 10 0 self) ; "So this Prince of Shapeir has come to bring peace and harmony to Tarna?"
			)
			(8
				((Timer new:) setReal: self 5)
			)
			(9
				(= local3 8)
				(gMessager say: 1 2 20 0 self) ; "Rakeesh, you of anyone should be demanding war instead of talking about peace. Reeshaka is lost! Your own daughter has been killed by the Leopardmen. Do you not want revenge?"
			)
			(10
				((Timer new:) setReal: self 10)
			)
			(11
				(cond
					((< local6 1)
						(gMessager say: 1 2 21 0 self) ; "It seems that being a prince of Shapeir has not taught you any manners, manling."
					)
					((== local6 3)
						(gMessager say: 1 2 22 0 self) ; "Enough of this. I weary of speaking to a human."
					)
					(else
						(self cue:)
					)
				)
			)
			(12
				(if register
					(= register 0)
				else
					(= local5 1)
					(gEgo addHonor: -10)
				)
				(= local3 16)
				(gTheIconBar enable: 1)
				(gMessager say: 1 2 23 1 self) ; "Human, you may leave our presence now, I wish to speak further to Rakeesh."
			)
			(13
				((Timer new:) setReal: self 10)
			)
			(14
				(if (and register (not local4))
					(= register 0)
					(gEgo addHonor: 10)
					(self cue:)
				else
					(= local5 1)
					(gEgo addHonor: -10)
					(gMessager say: 1 6 49 0 self) ; "Get the human out of here!"
				)
			)
			(15
				(if (== local5 0)
					(gEgo addHonor: 25)
					(gEgo solvePuzzle: 249 2 8)
				)
				(gCurRoom newRoom: 320)
			)
		)
	)
)

(instance situationTwo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_13)
				(= cycles 5)
			)
			(1
				(= local3 64)
				(gMessager say: 3 2 28 0 self) ; "Rajah Sah Tarna, I stand before you."
			)
			(2
				((Timer new:) setReal: self 10)
			)
			(3
				(= register 0)
				(= local3 128)
				(gMessager say: 1 2 31 0 self) ; "Rakeesh, are you so besotted by humans that you pledge your honor for them? What in the name of Sekhmet do you think you are doing?"
			)
			(4
				((Timer new:) setReal: self 10)
			)
			(5
				(if register
					(= register 0)
					(self cue:)
				else
					(gEgo addHonor: -10)
					(gMessager say: 1 2 36 0 self) ; "Does this one have no tongue with which to speak, Rakeesh?"
				)
			)
			(6
				(= local3 256)
				(gMessager say: 1 2 37 0 self) ; "Rakeesh, you and I have disagreed on many things, but I have always cared for you as my brother."
			)
			(7
				((Timer new:) setReal: self 10)
			)
			(8
				(cond
					((< local6 1)
						(gEgo addHonor: -10)
						(gMessager say: 1 2 42 0 self) ; "By the claws of Sekhmet, Rakeesh, how can you stand such an idiot?"
					)
					((== local6 3)
						(gMessager say: 1 2 22 0 self) ; "Enough of this. I weary of speaking to a human."
					)
					(else
						(self cue:)
					)
				)
			)
			(9
				(= local3 512)
				(gMessager say: 1 2 43 0 self) ; "Rakeesh, I cannot understand why you risk your honor and your life for humans. You could stay here in Tarna as my advisor, or lead my armies as a commander. To risk everything for peace is beyond my understanding!"
			)
			(10
				((Timer new:) setReal: self 5)
			)
			(11
				(if (and register (not local4))
					(= register 0)
					(gEgo addHonor: 10)
					(self cue:)
				else
					(gEgo addHonor: -10)
					(gMessager say: 1 6 49 0 self) ; "Get the human out of here!"
				)
			)
			(12
				(HandsOff)
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 0)
				(= cycles 30)
			)
			(13
				(gMessager say: 1 2 48 1 self) ; "You now leave to meet Rakeesh again outside the city gates."
			)
			(14
				(= gDay 3)
				(= gClock 1300)
				(gCurRoom newRoom: 150)
			)
		)
	)
)

(instance rajahTeller of Teller
	(properties)

	(method (showDialog)
		(super
			showDialog:
				-6 ; "Rajah"
				(& local3 $0007)
				-16 ; "Liontaur"
				(& local3 $0108)
				-17 ; "Servants"
				(& local3 $0108)
				-14 ; "Tarna"
				(& local3 $0108)
				-15 ; "Throne"
				(& local3 $0108)
				-19 ; "Rajah"
				(& local3 $0010)
				-24 ; "Rajah"
				(& local3 $0020)
				-30 ; "Rajah"
				(& local3 $00c0)
				-44 ; "Rajah"
				(& local3 $0200)
		)
	)

	(method (doChild param1 &tmp temp0 temp1)
		(cond
			((== param1 -6) ; "Rajah"
				(= local5 1)
				(gEgo addHonor: -10)
				(= temp0 1)
			)
			((or (== param1 -16) (== param1 -17) (== param1 -15)) ; "Liontaur", "Servants", "Throne"
				(if (> local6 2)
					(= temp0 1)
					(= temp1 1)
				else
					(++ local6)
				)
			)
			((== param1 -14) ; "Tarna"
				(super doChild: param1)
				(if (> local6 2)
					(= temp1 1)
					(= temp0 1)
				else
					(++ local6)
				)
			)
			((== param1 -19) ; "Rajah"
				(= local5 1)
				(gEgo addHonor: -10)
				(= local3 32)
			)
			((== param1 -24) ; "Rajah"
				(= local5 1)
				(gEgo addHonor: -10)
				(= temp0 1)
			)
			((== param1 -30) ; "Rajah"
				(= local5 1)
				(gEgo addHonor: -10)
				(= temp0 1)
			)
			((== param1 -44) ; "Rajah"
				(gEgo addHonor: -10)
				(if (not local4)
					(= local4 1)
				else
					(= temp0 1)
					(= temp1 1)
				)
			)
		)
		(if (== temp0 1)
			((gCurRoom script:) register: 1 cycles: 2)
			(if (IsObject ((gCurRoom script:) timer:))
				(((gCurRoom script:) timer:) dispose:)
			)
			(= temp0 0)
		)
		(if (== temp1 1)
			(= temp1 0)
		else
			(return 1)
		)
	)
)

(instance rajah of Prop
	(properties
		x 164
		y 104
		noun 1
		onMeCheck 2
		view 332
		loop 2
		signal 16
	)

	(method (onMe param1 param2 &tmp temp0 temp1)
		(if (IsObject param1)
			(= temp0 (param1 x:))
			(= temp1 (param1 y:))
		else
			(= temp0 param1)
			(= temp1 param2)
		)
		(return (& onMeCheck (OnControl CONTROL temp0 temp1)))
	)
)

(instance egoPic of Feature
	(properties
		x 5
		y 5
		noun 2
		onMeCheck 8
	)

	(method (doVerb theVerb)
		(gEgo doVerb: theVerb)
	)
)

(instance rajahRightArm of Prop
	(properties
		x 201
		y 78
		view 332
		loop 1
	)

	(method (doVerb theVerb)
		(rajah doVerb: theVerb)
	)
)

(instance localRakeesh of Feature
	(properties
		x 18
		y 189
		onMeCheck 4
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(2 ; Talk
				(cond
					((& local3 $0007)
						(= local5 1)
						(gEgo addHonor: -10)
						(= temp0 1)
						(gMessager say: 3 5 6) ; "Who gave you permission to question Rakeesh, human? I am the ruler here."
					)
					((& local3 $0008)
						(= local5 1)
						(gEgo addHonor: -10)
						(= local6 999)
						(= temp0 1)
						(gMessager say: 3 5 19) ; "Do not speak to others in my presence, fool."
					)
					((& local3 $0010)
						(= local5 1)
						(gEgo addHonor: -10)
						(= temp0 0)
						(gMessager say: 3 5 24) ; "Is this human going out of his way to insult me? I am the king, human. You shall speak only to me in my chambers."
						(= local3 32)
					)
					((& local3 $0020)
						(= local4 1)
						(= temp0 1)
						(gMessager say: 3 5 25) ; "That does it. I will take no more. Get the human out of here! Leave!"
					)
					((or (& local3 $0040) (& local3 $0080))
						(gEgo addHonor: -10)
						(= temp0 1)
						(gMessager say: 3 5 30) ; "I am the one who asks the questions, fool."
					)
					((& local3 $0100)
						(= local6 999)
						(gEgo addHonor: -10)
						(= temp0 1)
						(gMessager say: 3 5 30) ; "I am the one who asks the questions, fool."
					)
					((& local3 $0300)
						(if (not local4)
							(= local4 1)
							(gEgo addHonor: -10)
							(= temp0 0)
							(gMessager say: 1 2 27) ; "That's it! Get out before I have the guards throw you out!"
						else
							(= temp0 1)
						)
					)
				)
				(if temp0
					((gCurRoom script:) register: 1 cycles: 2)
					(if (IsObject ((gCurRoom script:) timer:))
						(((gCurRoom script:) timer:) dispose:)
					)
				)
				(return 1)
			)
			(1 ; Look
				(gMessager say: 3 1 0) ; "Your good friend Rakeesh stands before his king."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance cheeseCake1 of Prop
	(properties
		x 116
		y 91
		noun 10
		onMeCheck 16
		view 331
		loop 1
		priority 5
		signal 16
		cycleSpeed 12
	)

	(method (onMe param1 param2 &tmp temp0 temp1)
		(if (IsObject param1)
			(= temp0 (param1 x:))
			(= temp1 (param1 y:))
		else
			(= temp0 param1)
			(= temp1 param2)
		)
		(return (& onMeCheck (OnControl CONTROL temp0 temp1)))
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(2 ; Talk
				(cond
					((& local3 $0007)
						(= local5 1)
						(gEgo addHonor: -10)
						(= temp0 1)
						(gMessager say: 4 5 6) ; "I did not give you leave to question my servants, human."
					)
					((& local3 $0008)
						(= local6 999)
						(= local5 1)
						(gEgo addHonor: -10)
						(= temp0 1)
						(gMessager say: 4 5 19) ; "You do not speak to servants in my presence, fool."
					)
					((& local3 $0010)
						(= local5 1)
						(gEgo addHonor: -10)
						(= temp0 0)
						(gMessager say: 4 5 24) ; "I am the one speaking to you! Keep your responses addressed to me in my presence, or I will order you to leave."
						(= local3 32)
					)
					((& local3 $0020)
						(= temp0 1)
						(= local4 1)
						(gMessager say: 4 5 25) ; "You are deliberately insulting me! I will not stand for this! Leave my presence immediately!"
					)
					((or (& local3 $0040) (& local3 $0080))
						(gEgo addHonor: -10)
						(= temp0 1)
						(gMessager say: 4 5 30) ; "Do not dare to speak to my servants without my permission!"
					)
					((& local3 $0100)
						(= local6 999)
						(gEgo addHonor: -10)
						(= temp0 1)
						(gMessager say: 4 5 30) ; "Do not dare to speak to my servants without my permission!"
					)
					((& local3 $0200)
						(if (not local4)
							(= local4 1)
							(= temp0 0)
							(gEgo addHonor: -10)
							(gMessager say: 1 2 27) ; "That's it! Get out before I have the guards throw you out!"
						else
							(= temp0 1)
						)
					)
				)
				(if temp0
					((gCurRoom script:) register: 1 cycles: 2)
					(if (IsObject ((gCurRoom script:) timer:))
						(((gCurRoom script:) timer:) dispose:)
					)
				)
				(return 1)
			)
			(1 ; Look
				(gMessager say: 4 1 0) ; "Rajah has excellent taste in personal servants."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance cheeseCake2 of Feature
	(properties
		x 238
		y 170
		onMeCheck 32
	)

	(method (doVerb)
		(cheeseCake1 doVerb: &rest)
	)

	(method (onMe param1 param2 &tmp temp0 temp1)
		(if (IsObject param1)
			(= temp0 (param1 x:))
			(= temp1 (param1 y:))
		else
			(= temp0 param1)
			(= temp1 param2)
		)
		(return (& onMeCheck (OnControl CONTROL temp0 temp1)))
	)
)

(instance tell of Teller
	(properties)

	(method (showDialog)
		(super
			showDialog:
				-4 ; "Greet"
				(& local3 $0003)
				-5 ; "Talk about Shapeir"
				(& local3 $0007)
				-9 ; "Answer Rajah"
				(& local3 $0002)
				-8 ; "Greet"
				(& local3 $0400)
				-11 ; "Defend Rakeesh"
				(& local3 $0004)
				-12 ; "Talk about Rakeesh"
				(& local3 $0008)
				-13 ; "Talk about Shapeir"
				(& local3 $0008)
				-26 ; "Say Good-bye"
				(& local3 $0030)
				-28 ; "Greet"
				(& local3 $0040)
				-32 ; "Greet"
				(& local3 $0080)
				-33 ; "Talk about Honor"
				(& local3 $0080)
				-29 ; "Talk about Shapeir"
				(& local3 $0040)
				-34 ; "Talk about Rakeesh"
				(& local3 $0080)
				-35 ; "Talk about Shapeir"
				(& local3 $0080)
				-40 ; "Talk about Honor"
				(& local3 $0100)
				-39 ; "Tell about Rakeesh"
				(& local3 $0100)
				-38 ; "Talk about Shapeir"
				(& local3 $0100)
				-45 ; "Say Good-bye"
				(& local3 $0200)
		)
	)

	(method (doChild param1 &tmp temp0 temp1)
		(cond
			((== param1 -4) ; "Greet"
				(if (& local3 $0002)
					(= local3 1024)
				else
					(gEgo addHonor: 5)
				)
				(= temp0 1)
			)
			((== param1 -5) ; "Talk about Shapeir"
				(= local5 1)
				(gEgo addHonor: -10)
				(= temp0 1)
			)
			((== param1 -9) ; "Answer Rajah"
				(gMessager say: 2 5 9 1) ; "You answer Rajah's question."
				(if (<= (gEgo trySkill: 13 120) 0) ; communication
					(gMessager say: 2 5 9 2) ; "Rakeesh, your companion is not much of a speaker, is he?"
				else
					(gEgo addHonor: 5)
					(gMessager say: 2 5 9 3) ; "Very well."
				)
				(= temp1 1)
				(= temp0 1)
			)
			((== param1 -8) ; "Greet"
				(= temp0 1)
			)
			((== param1 -11) ; "Defend Rakeesh"
				(gEgo addHonor: 20 solvePuzzle: 250 2 8)
				(= temp0 1)
			)
			((== param1 -12) ; "Talk about Rakeesh"
				(= local6 999)
				(gMessager say: 2 5 12 1) ; "You speak of how Rakeesh helped you in Shapeir."
				(if (< [gEgoStats 13] 120) ; communication
					(gMessager say: 2 5 12 2) ; "The human speaks highly of you, Rakeesh, but he does not speak well."
				else
					(gMessager say: 2 5 12 3) ; "You are fortunate, Rakeesh, to have such a defender of your honor."
					(gEgo addHonor: 20)
				)
				(= temp1 1)
				(= temp0 1)
			)
			((== param1 -13) ; "Talk about Shapeir"
				(= local6 999)
				(if (< [gEgoStats 13] 120) ; communication
					(gMessager say: 2 5 13 2) ; "You are neither a storyteller nor a liar, obviously. Both can communicate better than you."
				else
					(gMessager say: 2 5 13 3) ; "That is an interesting tale for a human to tell."
				)
				(= temp1 1)
				(= temp0 1)
			)
			((== param1 -26) ; "Say Good-bye"
				(gEgo addHonor: 3)
				(= temp0 1)
			)
			((== param1 -28) ; "Greet"
				(gEgo addHonor: 5)
				(= temp0 1)
			)
			((== param1 -29) ; "Talk about Shapeir"
				(= local5 1)
				(gEgo addHonor: -10)
				(= temp0 1)
			)
			((== param1 -32) ; "Greet"
				(= temp0 1)
			)
			((== param1 -35) ; "Talk about Shapeir"
				(= local5 1)
				(gEgo addHonor: -10)
				(= temp0 1)
			)
			((== param1 -34) ; "Talk about Rakeesh"
				(gEgo addHonor: 20)
				(= temp0 1)
			)
			((== param1 -33) ; "Talk about Honor"
				(gEgo addHonor: 20)
				(= temp0 1)
			)
			((== param1 -40) ; "Talk about Honor"
				(= local6 999)
				(= temp0 1)
			)
			((== param1 -38) ; "Talk about Shapeir"
				(= local6 999)
				(gEgo addHonor: -10)
				(= temp0 1)
			)
			((== param1 -39) ; "Tell about Rakeesh"
				(= local6 999)
				(gEgo addHonor: 20)
				(= temp0 1)
			)
			((== param1 -45) ; "Say Good-bye"
				(gEgo addHonor: 3)
				(= temp0 1)
			)
		)
		(if temp0
			((gCurRoom script:) register: 1 cycles: 2)
			(if (IsObject ((gCurRoom script:) timer:))
				(((gCurRoom script:) timer:) dispose:)
			)
			(= temp0 0)
		)
		(if (== temp1 1)
			(= temp1 0)
		else
			(return 1)
		)
	)
)

(instance flame1 of Prop
	(properties
		x 45
		y 21
		view 330
		priority 14
		signal 16
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(lightglobe doVerb: theVerb)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance flame2 of Prop
	(properties
		x 286
		y 53
		view 330
		loop 1
		priority 14
		signal 16
	)
)

(instance rajahTalker of Talker
	(properties
		x 226
		y 14
		view 339
		loop 1
		talkWidth 260
		color 41
		back 57
		textX -195
		textY 150
	)

	(method (init)
		(super init: rajahBust rajahEyes rajahMouth &rest)
		(= local7 0)
	)

	(method (doit)
		(if (not (mod (++ local7) 40))
			(if (> (++ local0) 7)
				(= local0 0)
			)
			(cond
				(local2
					(if (> (++ local1) 10)
						(= local1 0)
						(= local2 0)
					)
				)
				((!= (flame2 cel:) 0)
					(= local2 1)
					(= local1 (flame2 cel:))
				)
				((not (Random 0 19))
					(= local2 1)
					(= local1 0)
				)
			)
			(flame1 cel: local0)
			(flame2 cel: local1)
			(Animate (gCast elements:) 0)
		)
		(super doit:)
	)
)

(instance rajahMouth of Prop
	(properties
		view 339
	)
)

(instance rajahBust of Prop
	(properties
		view 339
		loop 3
	)
)

(instance rajahEyes of Prop
	(properties
		view 339
		loop 2
	)
)

(instance lightglobe of Feature
	(properties
		x 43
		y 18
		noun 6
		nsTop 5
		nsLeft 28
		nsBottom 32
		nsRight 58
	)
)

(instance spittoon of Feature
	(properties
		x 191
		y 153
		noun 7
		nsTop 143
		nsLeft 171
		nsBottom 164
		nsRight 211
	)
)

(instance hieroglyphics of Feature
	(properties
		x 76
		y 33
		noun 8
		nsLeft 65
		nsBottom 66
		nsRight 88
	)
)

(instance incenseburner of Feature
	(properties
		x 292
		y 58
		noun 9
		nsTop 41
		nsLeft 278
		nsBottom 75
		nsRight 307
	)
)

