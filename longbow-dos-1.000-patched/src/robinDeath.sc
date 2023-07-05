;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 170)
(include sci.sh)
(use Main)
(use n013)
(use verseScript)
(use RTEyeCycle)
(use Motion)
(use Game)
(use Actor)

(public
	robinDeath 0
)

(procedure (localproc_0 param1 param2)
	(willHead setCycle: Fwd)
	(SetMessageColor 2)
	(Say param1 param2 self 67 10 10 80 {Will})
)

(procedure (localproc_1)
	(johnHead setCycle: Fwd)
	(johnArm setCycle: Fwd)
	(SetMessageColor 1)
	(Say &rest 80 {John})
)

(procedure (localproc_2)
	(tuckHead setCycle: Fwd)
	(tuckHands setCycle: Fwd)
	(SetMessageColor 3)
	(Say &rest 67 80 20 80 {Tuck})
)

(procedure (localproc_3)
	(alanHead setCycle: Fwd)
	(alanArm setCycle: Fwd)
	(SetMessageColor 4)
	(Say &rest 67 100 25 80 {Alan})
)

(procedure (localproc_4)
	(muchHead setCycle: Fwd)
	(SetMessageColor 5)
	(Say &rest 67 130 10 80 {Much})
)

(procedure (localproc_5)
	(willHead setCycle: Beg)
)

(procedure (localproc_6)
	(muchHead setCycle: Beg)
)

(procedure (localproc_7)
	(tuckHead setCycle: Beg)
	(tuckHands setCycle: Beg)
)

(procedure (localproc_8)
	(johnHead setCycle: Beg)
	(johnArm setCycle: Beg)
)

(procedure (localproc_9)
	(alanHead setCycle: Beg)
	(alanArm setCycle: Beg)
)

(procedure (localproc_10)
	(HandsOn)
	(gTheIconBar enable:)
	(SetMessageColor 0)
	(EgoDead)
)

(instance robinDeath of Rm
	(properties
		picture 160
		style 10
	)

	(method (dispose)
		(gRgnMusic stop:)
		(super dispose: &rest)
	)

	(method (init)
		(johnHead init:)
		(johnArm init:)
		(tuckHead init:)
		(tuckHands init:)
		(alanHead init:)
		(alanArm init:)
		(willHead init:)
		(muchHead init:)
		(super init:)
		(AddToAddToPics johnBody tuckBody alanBody willBody muchBody)
		(HandsOff)
		(gTheIconBar disable:)
		(gRgnMusic number: 173 loop: -1 play:)
		(switch gDeathNum
			(0
				(gCurRoom setScript: death2InRm120)
			)
			(1
				(gCurRoom setScript: death3InRm120)
			)
			(2
				(gCurRoom setScript: death4InRm120)
			)
			(3
				(gCurRoom setScript: death5InRm120)
			)
			(4
				(gCurRoom setScript: death1InFairRgn)
			)
			(5
				(gCurRoom setScript: deathInRm360)
			)
			(6
				(gCurRoom setScript: death1InRm390)
			)
			(7
				(gCurRoom setScript: death2InRm390)
			)
			(8
				(gCurRoom setScript: death3InRm390)
			)
			(9
				(gCurRoom setScript: death4InRm390)
			)
			(10
				(gCurRoom setScript: death1InAbyRegn)
			)
			(11
				(gCurRoom setScript: death2InAbyRegn)
			)
			(12
				(gCurRoom setScript: death3InAbyRegn)
			)
			(13
				(gCurRoom setScript: death1InRm440)
			)
			(14
				(gCurRoom setScript: death2InRm440)
			)
			(15
				(gCurRoom setScript: death1InRm460)
			)
			(16
				(gCurRoom setScript: death2InRm460)
			)
			(17
				(gCurRoom setScript: death3InRm460)
			)
			(18
				(gCurRoom setScript: death4InRm460)
			)
			(19
				(gCurRoom setScript: death1InRm620)
			)
			(20
				(gCurRoom setScript: death2InRm620)
			)
			(21
				(gCurRoom setScript: deathInRm620)
			)
			(22
				(gCurRoom setScript: deathInRm650)
			)
			(23
				(gCurRoom setScript: deathInWatrGate)
			)
			(24
				(gCurRoom setScript: deathInRm470)
			)
			(25
				(gCurRoom setScript: death1InRm500)
			)
			(26
				(gCurRoom setScript: death2InRm500)
			)
			(27
				(gCurRoom setScript: death1InRm530)
			)
			(28
				(gCurRoom setScript: death2InRm530)
			)
			(29
				(gCurRoom setScript: death3InRm530)
			)
			(30
				(gCurRoom setScript: deathInRm550)
			)
			(31
				(gCurRoom setScript: death1InRm570)
			)
			(32
				(gCurRoom setScript: death2InRm570)
			)
			(33
				(gCurRoom setScript: deathInForest)
			)
			(34
				(gCurRoom setScript: deathInRm320)
			)
			(35
				(gCurRoom setScript: getInBoatRm620)
			)
			(36
				(gCurRoom setScript: death2InFairRgn)
			)
			(37
				(gCurRoom setScript: deathInRm501)
			)
			(38
				(gCurRoom setScript: deathInRm710)
			)
			(39
				(gCurRoom setScript: death5InRm390)
			)
			(40
				(gCurRoom setScript: tooLateInTheHedge)
			)
		)
	)
)

(instance tuckBody of PicView
	(properties
		x 131
		y 189
		view 175
		loop 5
		priority 14
		signal 16384
	)
)

(instance tuckHead of Prop
	(properties
		x 138
		y 135
		view 175
		loop 3
		cel 4
		priority 15
		signal 16400
		cycleSpeed 24
	)
)

(instance tuckHands of Prop
	(properties
		x 116
		y 175
		view 175
		loop 4
		priority 15
		signal 16400
		cycleSpeed 36
	)
)

(instance johnBody of PicView
	(properties
		x 83
		y 95
		view 175
		loop 2
		priority 14
		signal 16384
	)
)

(instance johnHead of Prop
	(properties
		x 80
		y 110
		view 175
		priority 15
		signal 16404
		cycleSpeed 15
	)
)

(instance johnArm of Prop
	(properties
		x 62
		y 120
		view 175
		loop 1
		priority 15
		signal 16400
		cycleSpeed 48
	)
)

(instance alanBody of PicView
	(properties
		x 204
		y 189
		view 175
		loop 8
		priority 14
		signal 16384
	)
)

(instance alanHead of Prop
	(properties
		x 192
		y 146
		view 175
		loop 6
		priority 15
		signal 16404
		cycleSpeed 12
	)
)

(instance alanArm of Prop
	(properties
		x 186
		y 188
		view 175
		loop 7
		priority 15
		signal 16400
		cycleSpeed 30
	)
)

(instance willBody of PicView
	(properties
		x 24
		y 189
		view 175
		loop 10
		priority 14
		signal 16384
	)
)

(instance willHead of Prop
	(properties
		x 20
		y 156
		view 175
		loop 9
		priority 15
		signal 16404
		cycleSpeed 12
	)
)

(instance muchBody of PicView
	(properties
		x 289
		y 189
		view 175
		loop 12
		priority 14
		signal 16384
	)
)

(instance muchHead of Prop
	(properties
		x 293
		y 118
		view 175
		loop 11
		priority 15
		signal 16404
		cycleSpeed 12
	)
)

(instance death2InRm120 of TScript
	(properties)

	(method (cue param1)
		(if (and argc (not param1))
			(localproc_10)
			(self dispose:)
		else
			(super cue: &rest)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_3 1169 0 self) ; "I trow, Little John, there is none that can best you with the quarterstaff."
			)
			(1
				(localproc_9)
				(localproc_1 1169 1 self) ; "How could I fail, for I had Robin's death to avenge."
			)
			(2
				(localproc_8)
				(localproc_0 1169 2 self) ; "Now that it's avenged, we must choose a new leader. I say let it be you."
			)
			(3
				(localproc_5)
				(localproc_1 1169 3 self) ; "I could not take his place."
			)
			(4
				(localproc_8)
				(localproc_2 1169 4 self) ; "Ah, no one can."
			)
			(5
				(localproc_7)
				(localproc_3 1169 5 self) ; "Someone must, or we'll be sitting around here like this forever."
			)
			(6
				(localproc_10)
				(self dispose:)
			)
		)
	)
)

(instance death3InRm120 of TScript
	(properties)

	(method (cue param1)
		(if (and argc (not param1))
			(localproc_10)
			(self dispose:)
		else
			(super cue: &rest)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_2 1169 6 self) ; "Alas, poor Robin! We return from a most enjoyable day at the Fair and find him pinned to Watling Street."
			)
			(1
				(localproc_7)
				(localproc_1 1169 7 self) ; "Aye, I thought he was simply so well disguised, not even I could recognize him."
			)
			(2
				(localproc_8)
				(localproc_3 1169 8 self) ; "I thought it odd he didn't show up for the Tournament. And when I said 'naught but death would have kept him away', little did I dream I was being prophetic!"
			)
			(3
				(localproc_9)
				(localproc_0 1169 9 self) ; "He must have met his match, but whoever killed him is long gone now. We shall never know what error led him to this unfortunate end."
			)
			(4
				(localproc_10)
				(self dispose:)
			)
		)
	)
)

(instance death4InRm120 of TScript
	(properties)

	(method (cue param1)
		(if (and argc (not param1))
			(localproc_10)
			(self dispose:)
		else
			(super cue: &rest)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_0 1169 10 self) ; "'Tis no wonder Robin didn't compete in the Tournament. It was not for lack of a disguise."
			)
			(1
				(localproc_5)
				(localproc_2 1169 11 self) ; "Aye, we return from the Fair and find him alongside the unknown Yeoman, both skewered as neat as can be."
			)
			(2
				(localproc_7)
				(localproc_1 1169 12 self) ; "Robin must have made some terrible error in dealing with the fellow and met his match rightly enough."
			)
			(3
				(localproc_8)
				(localproc_4 1169 13 self) ; "I thought Robin was faster than anybody, but I guess even Robin Hood can get careless."
			)
			(4
				(localproc_6)
				(localproc_3 1169 14 self) ; "A wise lesson, Much. There are old outlaws and bold outlaws, but there are no old, bold outlaws."
			)
			(5
				(localproc_10)
				(self dispose:)
			)
		)
	)
)

(instance death1InFairRgn of TScript
	(properties)

	(method (cue param1)
		(if (and argc (not param1))
			(localproc_10)
			(self dispose:)
		else
			(super cue: &rest)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_2 1169 15 self) ; "Rather dangerous for Robin to enter such a busy place as a Monk, don't you think?"
			)
			(1
				(localproc_7)
				(localproc_1 1169 16 self) ; "Aye, after all that's happened, you can be sure the local monks and Sheriff's men would be keeping a sharp eye out for him."
			)
			(2
				(localproc_8)
				(localproc_0 1169 17 self) ; "Better he'd entered in a guise less likely to arouse suspicion."
			)
			(3
				(localproc_5)
				(localproc_3 1169 18 self) ; "Aye, you could say it was a bad habit."
			)
			(4
				(localproc_10)
				(self dispose:)
			)
		)
	)
)

(instance deathInRm360 of TScript
	(properties)

	(method (cue param1)
		(if (and argc (not param1))
			(localproc_10)
			(self dispose:)
		else
			(super cue: &rest)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_3 1169 19 self) ; "I can almost hear a tune for this.  'Bang, bang, cobbler's silver hammer came down on his head!'"
			)
			(1
				(localproc_9)
				(localproc_4 1169 20 self) ; "I've heard that one before."
			)
			(2
				(localproc_6)
				(localproc_1 1169 21 self) ; "I cannot blame Lobb though. There was no excuse for Robin letting the Monk kill Marian like that."
			)
			(3
				(localproc_8)
				(localproc_0 1169 22 self) ; "Perhaps not, but here at least is that rarest of all occasions--a second chance."
			)
			(4
				(localproc_10)
				(self dispose:)
			)
		)
	)
)

(instance death1InRm390 of TScript
	(properties)

	(method (cue param1)
		(if (and argc (not param1))
			(localproc_10)
			(self dispose:)
		else
			(super cue: &rest)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_1 1169 23 self) ; "Rather an odd thing for Robin to do. What would a Sheriff's Man want with a silver comb?"
			)
			(1
				(localproc_8)
				(localproc_0 1169 24 self) ; "Likely he just acted without thinking."
				self
			)
			(2
				(localproc_5)
				(localproc_2 1169 25 self) ; "Let us hope Robin adhered to the Golden Rule."
			)
			(3
				(localproc_7)
				(localproc_3 1169 26 self) ; "What, you mean 'do unto others as they would do unto you?'"
			)
			(4
				(localproc_9)
				(localproc_2 1169 27 self) ; "Nay, I mean 'save early, save often."
			)
			(5
				(localproc_10)
				(self dispose:)
			)
		)
	)
)

(instance death2InRm390 of TScript
	(properties)

	(method (cue param1)
		(if (and argc (not param1))
			(localproc_10)
			(self dispose:)
		else
			(super cue: &rest)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_3 1169 28 self) ; "He must have thought that guard to be very thick indeed to not notice a blonde beard changing to a red one."
			)
			(1
				(localproc_9)
				(localproc_0 1169 29 self) ; "'Tis fatal to underestimate one's enemies."
			)
			(2
				(localproc_5)
				(localproc_1 1169 30 self) ; "I fear Robin's beard had become all too familiar a sight. Once they'd removed his disguise, they made short work of him."
			)
			(3
				(localproc_8)
				(localproc_3 1169 31 self) ; "I rue the rouge that robbed us of Robin, betrayed by the beard he'd bandied about in."
			)
			(4
				(localproc_10)
				(self dispose:)
			)
		)
	)
)

(instance death3InRm390 of TScript
	(properties)

	(method (cue param1)
		(if (and argc (not param1))
			(localproc_10)
			(self dispose:)
		else
			(super cue: &rest)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_1 1169 32 self) ; "That was a sure way to get arrested."
			)
			(1
				(localproc_8)
				(localproc_2 1169 33 self) ; "Aye, flaunting a stolen ring is not subtle."
			)
			(2
				(localproc_7)
				(localproc_4 1169 34 self) ; "Why'd he want to give a ring to that soldier anyway?"
			)
			(3
				(localproc_6)
				(localproc_0 1169 35 self) ; "'Tis a mystery to me. If I could know what Robin was thinking at all times, I would not be a mere outlaw."
			)
			(4
				(localproc_5)
				(localproc_3 1169 36 self) ; "You'd be the richest game designer in history."
			)
			(5
				(localproc_10)
				(self dispose:)
			)
		)
	)
)

(instance death4InRm390 of TScript
	(properties)

	(method (cue param1)
		(if (and argc (not param1))
			(localproc_10)
			(self dispose:)
		else
			(super cue: &rest)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_3 1169 37 self) ; "What a curse, that Robin's dashing beard so impressed the Sheriff's wife!"
			)
			(1
				(localproc_9)
				(localproc_2 1169 38 self) ; "Had he been but a bit more careful, he might have had a hair's-breadth escape."
			)
			(2
				(localproc_7)
				(localproc_1 1169 39 self) ; "Aye, the Sheriff wasted no time lengthening his beard with a rope."
			)
			(3
				(localproc_8)
				(localproc_0 1169 40 self) ; "They say the Sheriff's wife wept through the whole hanging."
			)
			(4
				(localproc_5)
				(localproc_3 1169 41 self) ; "Small comfort for poor Robin! Would that she'd never recognized him."
			)
			(5
				(localproc_10)
				(self dispose:)
			)
		)
	)
)

(instance death1InAbyRegn of TScript
	(properties)

	(method (cue param1)
		(if (and argc (not param1))
			(localproc_10)
			(self dispose:)
		else
			(super cue: &rest)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_1 1169 42 self) ; "He should've waited and worked on the box in a safer place."
			)
			(1
				(localproc_8)
				(localproc_2 1169 43 self) ; "Robin always was overburdened with curiosity."
			)
			(2
				(localproc_7)
				(localproc_3 1169 44 self) ; "Curiosity killed the outlaw."
			)
			(3
				(localproc_9)
				(localproc_4 1169 45 self) ; "I thought it killed the cat."
			)
			(4
				(localproc_6)
				(localproc_3 1169 46 self) ; "Fortunately, outlaws, like cats, have 9 lives. Sometimes even more."
			)
			(5
				(localproc_10)
				(self dispose:)
			)
		)
	)
)

(instance death2InAbyRegn of TScript
	(properties)

	(method (cue param1)
		(if (and argc (not param1))
			(localproc_10)
			(self dispose:)
		else
			(super cue: &rest)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_4 1169 47 self) ; "I'm not very smart, but even I wouldn't have done that."
			)
			(1
				(localproc_6)
				(localproc_2 1169 48 self) ; "Aye, it did seem a rather poorly considered action, all in all."
			)
			(2
				(localproc_7)
				(localproc_1 1169 49 self) ; "No need to speak ill of the dead. For all we know, he had a good reason to give it to that Monk."
			)
			(3
				(localproc_8)
				(localproc_0 1169 50 self) ; "Well, we'll certainly never know what it was."
			)
			(4
				(localproc_10)
				(self dispose:)
			)
		)
	)
)

(instance death3InAbyRegn of TScript
	(properties)

	(method (cue param1)
		(if (and argc (not param1))
			(localproc_10)
			(self dispose:)
		else
			(super cue: &rest)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_0 1169 51 self) ; "That ring was a rather flashy piece of jewelry to wear amidst one's enemies."
			)
			(1
				(localproc_5)
				(localproc_1 1169 52 self) ; "He probably just forgot he had it on."
			)
			(2
				(localproc_8)
				(localproc_2 1169 53 self) ; "Or assumed no one would notice."
			)
			(3
				(localproc_7)
				(localproc_3 1169 54 self) ; "You know the old saying, 'assumption is the mother of mistake.'"
			)
			(4
				(localproc_9)
				(localproc_2 1169 55 self) ; "That's an old saying? I never heard that before."
			)
			(5
				(localproc_7)
				(localproc_3 1169 56 self) ; "Ah, well, in fact I just made it up. But it rings of truth, all the same."
			)
			(6
				(localproc_9)
				(localproc_1 1169 57 self) ; "Please, don't mention rings again. Maybe your saying should go, 'assumption is downfall of all outlaws.'"
			)
			(7
				(localproc_8)
				(localproc_3 1169 58 self) ; "Everyone's a critic."
			)
			(8
				(localproc_10)
				(self dispose:)
			)
		)
	)
)

(instance death1InRm440 of TScript
	(properties)

	(method (cue param1)
		(if (and argc (not param1))
			(localproc_10)
			(self dispose:)
		else
			(super cue: &rest)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_2 1169 59 self) ; "I cannot believe that Robin ignored his peril at the Abbey and let Brother Theodore see him."
			)
			(1
				(localproc_7)
				(localproc_1 1169 60 self) ; "Aye, it didn't take long for the Sheriff's men to surround the Abbey and seize him."
			)
			(2
				(localproc_8)
				(localproc_0 1169 61 self) ; "And it didn't take the Sheriff long to hang him, either."
			)
			(3
				(localproc_5)
				(localproc_2 1169 62 self) ; "Ah, what a felonious monk he was."
			)
			(4
				(localproc_10)
				(self dispose:)
			)
		)
	)
)

(instance death2InRm440 of TScript
	(properties)

	(method (cue param1)
		(if (and argc (not param1))
			(localproc_10)
			(self dispose:)
		else
			(super cue: &rest)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_0 1169 63 self) ; "He was doing very well until he wandered out into town in broad daylight, bold as you please."
			)
			(1
				(localproc_5)
				(localproc_3 1169 64 self) ; "It pleased the soldiers well enough."
			)
			(2
				(localproc_9)
				(localproc_1 1169 65 self) ; "Aye, it's not often the most famous of outlaws walks guilelessly into their hands."
			)
			(3
				(localproc_8)
				(localproc_2 1169 66 self) ; "I certainly hope it's not often. It's not a tale worth repeating."
			)
			(4
				(localproc_10)
				(self dispose:)
			)
		)
	)
)

(instance death1InRm460 of TScript
	(properties)

	(method (cue param1)
		(if (and argc (not param1))
			(localproc_10)
			(self dispose:)
		else
			(super cue: &rest)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_2 1169 67 self) ; "Defrocking is not usually a lethal affair, but in Robin's case...."
			)
			(1
				(localproc_7)
				(localproc_1 1169 68 self) ; "Aye, without a hood, the Hood was revealed."
			)
			(2
				(localproc_8)
				(localproc_0 1169 69 self) ; "It wasn't hard to knock down a few soft monks, if only that patrol of soldiers hadn't been nearby."
			)
			(3
				(localproc_0 1169 70 self) ; "He might still have won the fight if not for their crossbows."
			)
			(4
				(localproc_5)
				(localproc_3 1169 71 self) ; "Alas, their quarrels ended his quarrel."
			)
			(5
				(localproc_10)
				(self dispose:)
			)
		)
	)
)

(instance death2InRm460 of TScript
	(properties)

	(method (cue param1)
		(if (and argc (not param1))
			(localproc_10)
			(self dispose:)
		else
			(super cue: &rest)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_2 1169 72 self) ; "A dangerous game, getting drunk with the Abbot."
			)
			(1
				(localproc_7)
				(localproc_3 1169 73 self) ; "Robin needed extra help in a drinking bout against someone with the Abbot's vast girth and daily practice."
			)
			(2
				(localproc_9)
				(localproc_1 1169 74 self) ; "It would've been worth the risk, had he been able to outdrink him."
			)
			(3
				(localproc_8)
				(localproc_0 1169 75 self) ; "Aye, there's the matter of that interesting puzzle box he sent to his room."
			)
			(4
				(localproc_5)
				(localproc_2 1169 76 self) ; "A puzzle which, perhaps, will yet be solved."
			)
			(5
				(localproc_10)
				(self dispose:)
			)
		)
	)
)

(instance death3InRm460 of TScript
	(properties)

	(method (cue param1)
		(if (and argc (not param1))
			(localproc_10)
			(self dispose:)
		else
			(super cue: &rest)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_3 1169 77 self) ; "Alas, of all the times for Robin's cunning to fail him."
			)
			(1
				(localproc_9)
				(localproc_1 1169 78 self) ; "Did he think his theft would go unnoticed?"
			)
			(2
				(localproc_8)
				(localproc_2 1169 79 self) ; "Had he been a bit quicker, he could have escaped."
			)
			(3
				(localproc_7)
				(localproc_0 1169 80 self) ; "Everything is clearer in hindsight, my friends, even death."
			)
			(4
				(localproc_10)
				(self dispose:)
			)
		)
	)
)

(instance death4InRm460 of TScript
	(properties)

	(method (cue param1)
		(if (and argc (not param1))
			(localproc_10)
			(self dispose:)
		else
			(super cue: &rest)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_1 1169 81 self) ; "Giving that to the Abbot was rather like sticking one's head in the lion's mouth and then being surprised when it was bitten off."
			)
			(1
				(localproc_8)
				(localproc_4 1169 82 self) ; "The Abbot has a lion?"
			)
			(2
				(localproc_6)
				(localproc_3 1169 83 self) ; "Much, it was an example."
			)
			(3
				(localproc_9)
				(localproc_4 1169 84 self) ; "An example of what?"
			)
			(4
				(localproc_6)
				(localproc_1 1169 85 self) ; "As I was saying, it wasn't a good idea."
			)
			(5
				(localproc_8)
				(localproc_4 1169 86 self) ; "If that's what you were saying, why didn't you say so?"
			)
			(6
				(localproc_6)
				(localproc_1 1169 87 self) ; "Much, if you had a brain in your skull, it would perish from lack of use."
			)
			(7
				(localproc_10)
				(self dispose:)
			)
		)
	)
)

(instance death1InRm620 of TScript
	(properties)

	(method (cue param1)
		(if (and argc (not param1))
			(localproc_10)
			(self dispose:)
		else
			(super cue: &rest)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_1 1170 0 self) ; "One can only wonder what Robin was trying to do."
			)
			(1
				(localproc_8)
				(localproc_0 1170 1 self) ; "Knowing full well that these monks were once soldiers and not to be trifled with."
			)
			(2
				(localproc_5)
				(localproc_2 1170 2 self) ; "Let us hope he is wiser in the afterlife."
			)
			(3
				(localproc_10)
				(self dispose:)
			)
		)
	)
)

(instance death2InRm620 of TScript
	(properties)

	(method (cue param1)
		(if (and argc (not param1))
			(localproc_10)
			(self dispose:)
		else
			(super cue: &rest)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_2 1170 3 self) ; "That monk had a sharp eye."
			)
			(1
				(localproc_7)
				(localproc_1 1170 4 self) ; "And a heavy stick."
			)
			(2
				(localproc_8)
				(localproc_0 1170 5 self) ; "And a short temper."
			)
			(3
				(localproc_5)
				(localproc_4 1170 6 self) ; "And good aim."
			)
			(4
				(localproc_6)
				(localproc_3 1170 7 self) ; "And that's the end of Robin."
			)
			(5
				(localproc_10)
				(self dispose:)
			)
		)
	)
)

(instance deathInRm650 of TScript
	(properties)

	(method (cue param1)
		(if (and argc (not param1))
			(localproc_10)
			(self dispose:)
		else
			(super cue: &rest)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_3 1170 8 self) ; "That was rather an odd tactic, don't you think?"
			)
			(1
				(localproc_9)
				(localproc_2 1170 9 self) ; "Aye, putting the amethyst in the Prior's cup would have kept him sober."
			)
			(2
				(localproc_7)
				(localproc_1 1170 10 self) ; "And done nothing to keep him from studying the scroll Robin wanted."
			)
			(3
				(localproc_8)
				(localproc_0 1170 11 self) ; "He didn't think it through, I wager."
			)
			(4
				(localproc_5)
				(localproc_4 1170 12 self) ; "Now he gets to think about it from the bottom of the fens."
			)
			(5
				(localproc_10)
				(self dispose:)
			)
		)
	)
)

(instance deathInWatrGate of TScript
	(properties)

	(method (cue param1)
		(if (and argc (not param1))
			(localproc_10)
			(self dispose:)
		else
			(super cue: &rest)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_3 1170 90 self) ; "I heard it took a dozen Monks to subdue poor Robin."
			)
			(1
				(localproc_9)
				(localproc_2 1170 91 self) ; "Aye, but in the end, they dunked him in the fens with stone weights around his neck."
			)
			(2
				(localproc_7)
				(localproc_4 1170 92 self) ; "I'll ne'er venture close to that evil fens again now that Robin has become a will-o-th-wisp."
			)
			(3
				(localproc_6)
				(localproc_1 1170 93 self) ; "A shame he was not more cautious."
			)
			(4
				(localproc_8)
				(localproc_0 1170 94 self) ; "For had he been, he might not now be sleeping with the fish."
			)
			(5
				(localproc_10)
				(self dispose:)
			)
		)
	)
)

(instance deathInRm470 of TScript
	(properties)

	(method (cue param1)
		(if (and argc (not param1))
			(localproc_10)
			(self dispose:)
		else
			(super cue: &rest)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_0 1170 13 self) ; "So there he stood, stolen box in hand, disguised, surrounded by enemies and he did what?"
			)
			(1
				(localproc_5)
				(localproc_2 1170 14 self) ; "Pulled the bell rope in the Abbot's room."
			)
			(2
				(localproc_7)
				(localproc_1 1170 15 self) ; "Whatever possessed him?"
			)
			(3
				(localproc_8)
				(localproc_3 1170 16 self) ; "There are those who simply cannot resist doing what should not be done."
			)
			(4
				(localproc_9)
				(localproc_2 1170 17 self) ; "Well, let this be a lesson to them."
			)
			(5
				(localproc_10)
				(self dispose:)
			)
		)
	)
)

(instance death1InRm500 of TScript
	(properties)

	(method (cue param1)
		(if (and argc (not param1))
			(localproc_10)
			(self dispose:)
		else
			(super cue: &rest)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_1 1170 18 self) ; "Well, he certainly botched that one up."
			)
			(1
				(localproc_8)
				(localproc_2 1170 19 self) ; "Aye, he infuriated the Innkeeper who sent a warning to the Sheriff."
			)
			(2
				(localproc_7)
				(localproc_0 1170 20 self) ; "The Abbot was quick to guess the secret way that Robin would take through the Abbey."
			)
			(3
				(localproc_5)
				(localproc_3 1170 21 self) ; "Alas, we've lost both Robin and Marian. Such a sad day."
			)
			(4
				(localproc_9)
				(localproc_1 1170 22 self) ; "Had it been me, I would've found a better way to deal with the Innkeeper."
			)
			(5
				(localproc_8)
				(localproc_3 1170 23 self) ; "Aye, you would have threatened to drink his pub dry!"
			)
			(6
				(localproc_9)
				(localproc_1 1170 24 self) ; "This is hardly the time for jest. Ah, well, time to select a new leader."
			)
			(7
				(localproc_10)
				(self dispose:)
			)
		)
	)
)

(instance death2InRm500 of TScript
	(properties)

	(method (cue param1)
		(if (and argc (not param1))
			(localproc_10)
			(self dispose:)
		else
			(super cue: &rest)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_1 1170 25 self) ; "That was very clever of Robin to go through the maze and the hidden door and try to rescue Marian by surprise."
			)
			(1
				(localproc_8)
				(localproc_4 1170 26 self) ; "Clever? But he's dead!"
			)
			(2
				(localproc_6)
				(localproc_1 1170 27 self) ; "I said it was clever, I didn't say it was wise."
			)
			(3
				(localproc_8)
				(localproc_3 1170 28 self) ; "I shall make a tragic ballad of 'Robin's Daring Rescue' which failed because he forgot to think of what would happen when he found himself at the mercy of scores of armed enemies."
			)
			(4
				(localproc_9)
				(localproc_2 1170 29 self) ; "If we'd only known he meant to be so clever, we might have aided him."
			)
			(5
				(localproc_7)
				(localproc_0 1170 30 self) ; "There are times to act alone and times to seek the advice of your comrades in arms."
			)
			(6
				(localproc_10)
				(self dispose:)
			)
		)
	)
)

(instance death1InRm530 of TScript
	(properties)

	(method (cue param1)
		(if (and argc (not param1))
			(localproc_10)
			(self dispose:)
		else
			(super cue: &rest)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_4 1170 31 self) ; "The pub is a popular place for the Sheriff's Men to go."
			)
			(1
				(localproc_6)
				(localproc_2 1170 32 self) ; "Even a drunk soldier would recognize such a famous outlaw walking into their midst."
			)
			(2
				(localproc_7)
				(localproc_1 1170 33 self) ; "Perhaps Robin was overcome with the need for an ale and thought the pub might be empty."
			)
			(3
				(localproc_8)
				(localproc_0 1170 34 self) ; "A shame, for he never got one before they hung him. Seems a waste to die for a drop of grog."
			)
			(4
				(localproc_5)
				(localproc_3 1170 35 self) ; "To Robin Hood let's raise a toast, and hope there's good ale amongst the heavenly Host!"
			)
			(5
				(localproc_10)
				(self dispose:)
			)
		)
	)
)

(instance death2InRm530 of TScript
	(properties)

	(method (cue param1)
		(if (and argc (not param1))
			(localproc_10)
			(self dispose:)
		else
			(super cue: &rest)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_2 1170 36 self) ; "Tsk, all the Sheriff wanted was a blessing."
			)
			(1
				(localproc_7)
				(localproc_1 1170 37 self) ; "Aye, it's wasn't like Robin to lose his head when a bit of cunning would have served."
			)
			(2
				(localproc_8)
				(localproc_4 1170 38 self) ; "He's lost his head now, alas, stretched from a rope."
			)
			(3
				(localproc_10)
				(self dispose:)
			)
		)
	)
)

(instance death3InRm530 of TScript
	(properties)

	(method (cue param1)
		(if (and argc (not param1))
			(localproc_10)
			(self dispose:)
		else
			(super cue: &rest)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_2 1170 39 self) ; "Of all the times to become drunk!"
			)
			(1
				(localproc_7)
				(localproc_4 1170 40 self) ; "Well, I wouldn't have stood still for toasting Prince John either!"
			)
			(2
				(localproc_6)
				(localproc_0 1170 41 self) ; "Once they had hold of him, it didn't take long to find out who he was."
			)
			(3
				(localproc_5)
				(localproc_1 1170 42 self) ; "The devil took over Robin's tongue, I wager."
			)
			(4
				(localproc_8)
				(localproc_2 1170 43 self) ; "The devil may have him now, I am sad to say."
			)
			(5
				(localproc_10)
				(self dispose:)
			)
		)
	)
)

(instance deathInRm550 of TScript
	(properties)

	(method (cue param1)
		(if (and argc (not param1))
			(localproc_10)
			(self dispose:)
		else
			(super cue: &rest)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_3 1170 44 self) ; "Robin was warned and still he let his tongue get the better of him."
			)
			(1
				(localproc_9)
				(localproc_1 1170 45 self) ; "The Innkeeper was the clever one. He kept his wits and pretended he'd deliberately trapped Robin in the cellar."
			)
			(2
				(localproc_8)
				(localproc_4 1170 46 self) ; "I still don't like him getting the reward for it, though."
			)
			(3
				(localproc_6)
				(localproc_0 1170 47 self) ; "It was Robin's brashness that betrayed him, not the Innkeeper."
			)
			(4
				(localproc_5)
				(localproc_2 1170 48 self) ; "Let us pray Robin finds his rewards in heaven."
			)
			(5
				(localproc_10)
				(self dispose:)
			)
		)
	)
)

(instance death1InRm570 of TScript
	(properties)

	(method (cue param1)
		(if (and argc (not param1))
			(localproc_10)
			(self dispose:)
		else
			(super cue: &rest)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_3 1170 49 self) ; "He was off to a brilliant start."
			)
			(1
				(localproc_9)
				(localproc_1 1170 50 self) ; "Aye, he'd gotten past the Innkeeper and into the tunnels. Very clever."
			)
			(2
				(localproc_8)
				(localproc_2 1170 51 self) ; "And then he walked right into the heart of the castle!"
			)
			(3
				(localproc_7)
				(localproc_4 1170 52 self) ; "Maybe he thought all the Sheriff's Men would be at the burning."
			)
			(4
				(localproc_6)
				(localproc_0 1170 53 self) ; "There's always guards in a castle. I don't know what he was thinking."
			)
			(5
				(localproc_5)
				(localproc_1 1170 54 self) ; "I guess we'll never know. Let's hope our next leader keeps his wits about him."
			)
			(6
				(localproc_10)
				(self dispose:)
			)
		)
	)
)

(instance death2InRm570 of TScript
	(properties)

	(method (cue param1)
		(if (and argc (not param1))
			(localproc_10)
			(self dispose:)
		else
			(super cue: &rest)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_3 1170 55 self) ; "I heard Robin led them a merry chase, for all that he was hampered by the monk's robe."
			)
			(1
				(localproc_9)
				(localproc_1 1170 56 self) ; "He didn't get far once the alarm went up."
			)
			(2
				(localproc_8)
				(localproc_2 1170 57 self) ; "The Sheriff's furious over discovering those tunnels. He nearly hung the Abbot next to Robin."
			)
			(3
				(localproc_7)
				(localproc_0 1170 58 self) ; "Would that he had hung the Abbot INSTEAD of Robin."
			)
			(4
				(localproc_5)
				(localproc_4 1170 59 self) ; "Robin should have been quicker or far more careful."
			)
			(5
				(localproc_6)
				(localproc_1 1170 60 self) ; "For once, Much, you have spoken wisely."
			)
			(6
				(localproc_1 1170 61 self) ; "Alas for poor, dead, careless Robin."
			)
			(7
				(localproc_10)
				(self dispose:)
			)
		)
	)
)

(instance deathInForest of TScript
	(properties)

	(method (cue param1)
		(if (and argc (not param1))
			(localproc_10)
			(self dispose:)
		else
			(super cue: &rest)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_0 1170 62 self) ; "Those cursed soldiers doomed Robin with their worry over an Abbey Monk in the forest!"
			)
			(1
				(localproc_5)
				(localproc_1 1170 63 self) ; "Aye, the more Robin insisted to be left alone, the more suspicious they became."
			)
			(2
				(localproc_8)
				(localproc_2 1170 64 self) ; "By the time they reached Nottingham, the game was up and now our clever Robin swings from the gallows."
			)
			(3
				(localproc_7)
				(localproc_3 1170 65 self) ; "'Tis a lesson to me. I'll never trade the Lincoln green for the Abbey brown when the Sheriff's men are around."
			)
			(4
				(localproc_10)
				(self dispose:)
			)
		)
	)
)

(instance death5InRm120 of TScript
	(properties)

	(method (cue param1)
		(if (and argc (not param1))
			(localproc_10)
			(self dispose:)
		else
			(super cue: &rest)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_1 1170 66 self) ; "Alas, that treacherous Knight was long gone by the time we found Robin cruelly slain upon Watling Street."
			)
			(1
				(localproc_8)
				(localproc_2 1170 67 self) ; "Such a base murderer could not have been a Queen's man."
			)
			(2
				(localproc_7)
				(localproc_0 1170 68 self) ; "Here we are without a leader, without the password, without the true Queen's Knight, and no way to deliver the ransom."
			)
			(3
				(localproc_5)
				(localproc_3 1170 69 self) ; "Wasn't very thoughtful of Robin to leave us in such a mess."
			)
			(4
				(localproc_9)
				(localproc_1 1170 70 self) ; "Wasn't thoughtful of the Knight to leave Robin in such a mess!"
			)
			(5
				(localproc_10)
				(self dispose:)
			)
		)
	)
)

(instance deathInRm620 of TScript
	(properties)

	(method (cue param1)
		(if (and argc (not param1))
			(localproc_10)
			(self dispose:)
		else
			(super cue: &rest)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_4 1170 71 self) ; "I hear the monks dumped Robin's body into the fens after the guardian cracked his pate."
			)
			(1
				(localproc_6)
				(localproc_2 1170 72 self) ; "Aye, he failed to study his gemstone lore."
			)
			(2
				(localproc_7)
				(localproc_1 1170 73 self) ; "I'll not go near those fens now and see his drowned soul lighting the swamps with the other will-o-th'wisps."
			)
			(3
				(localproc_8)
				(localproc_0 1170 74 self) ; "You'd be safe enough with a piece of jet or lapis lazuli in hand."
			)
			(4
				(localproc_5)
				(localproc_1 1170 75 self) ; "How d'you know that?"
			)
			(5
				(localproc_8)
				(localproc_0 1170 76 self) ; "Studied my gemstore lore in the book, that's how. I suggest you do the same."
			)
			(6
				(localproc_10)
				(self dispose:)
			)
		)
	)
)

(instance deathInRm320 of TScript
	(properties)

	(method (cue param1)
		(if (and argc (not param1))
			(localproc_10)
			(self dispose:)
		else
			(super cue: &rest)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_3 1170 77 self) ; "Robin was feeling a bit TOO bold considering that he was surrounded by enemies."
			)
			(1
				(localproc_9)
				(localproc_2 1170 78 self) ; "I'd thought him wise enough to listen to warnings."
			)
			(2
				(localproc_7)
				(localproc_0 1170 79 self) ; "A shame he didn't shoot for the Golden Arrow. That would've been a sight worth seeing."
			)
			(3
				(localproc_5)
				(localproc_1 1170 80 self) ; "Were he here now, I'd warn him to be quicker and wiser and join the tournament while the time was right."
			)
			(4
				(localproc_10)
				(self dispose:)
			)
		)
	)
)

(instance getInBoatRm620 of TScript
	(properties)

	(method (cue param1)
		(if (and argc (not param1))
			(localproc_10)
			(self dispose:)
		else
			(super cue: &rest)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_1 1170 81 self) ; "A suspicious lot, those Fens Monks."
			)
			(1
				(localproc_8)
				(localproc_2 1170 82 self) ; "Aye, and quick to wield their staves."
			)
			(2
				(localproc_7)
				(localproc_0 1170 83 self) ; "Mayhap Robin thought the Monk had nothing better to do than pole him about the fens all day."
			)
			(3
				(localproc_5)
				(localproc_3 1170 84 self) ; "More likely he did not think at all!"
			)
			(4
				(localproc_10)
				(self dispose:)
			)
		)
	)
)

(instance death2InFairRgn of TScript
	(properties)

	(method (cue param1)
		(if (and argc (not param1))
			(localproc_10)
			(self dispose:)
		else
			(super cue: &rest)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_2 1170 85 self) ; "Alas, after all the warnings Robin had about the Prince's spies, he still fell prey to one."
			)
			(1
				(localproc_7)
				(localproc_1 1170 86 self) ; "Aye, his caution failed him."
			)
			(2
				(localproc_8)
				(localproc_4 1170 87 self) ; "He's learned better now."
			)
			(3
				(localproc_6)
				(localproc_0 1170 88 self) ; "'Tis a painful education when taught upon the gallows."
			)
			(4
				(localproc_5)
				(localproc_3 1170 89 self) ; "Let us hope that those who study their mistakes will learn from this lesson and improve upon their 'scholarship' in the future."
			)
			(5
				(localproc_10)
				(self dispose:)
			)
		)
	)
)

(instance deathInRm501 of TScript
	(properties)

	(method (cue param1)
		(if (and argc (not param1))
			(localproc_10)
			(self dispose:)
		else
			(super cue: &rest)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_2 1170 95 self) ; "I knew there was something missing from this plan."
			)
			(1
				(localproc_7)
				(localproc_1 1170 96 self) ; "He should've paid more attention to what Fulk told him."
			)
			(2
				(localproc_8)
				(localproc_3 1170 97 self) ; "It gives a whole new meaning to lyrics about the fires of love burning hotly--"
			)
			(3
				(localproc_9)
				(localproc_0 1170 98 self) ; "That's in very poor taste, Alan."
			)
			(4
				(localproc_5)
				(localproc_3 1170 99 self) ; "Pray pardon me. But then, I'm not the one foolish enough to jump into a fire without protection."
			)
			(5
				(localproc_10)
				(self dispose:)
			)
		)
	)
)

(instance deathInRm710 of TScript
	(properties)

	(method (cue param1)
		(if (and argc (not param1))
			(localproc_10)
			(self dispose:)
		else
			(super cue: &rest)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_3 1170 100 self) ; "Poor Robin has learned, to his dismay, that death is but a stone's throw away."
			)
			(1
				(localproc_10)
				(self dispose:)
			)
		)
	)
)

(instance death5InRm390 of TScript
	(properties)

	(method (cue param1)
		(if (and argc (not param1))
			(localproc_10)
			(self dispose:)
		else
			(super cue: &rest)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_0 1170 101 self) ; "Instead of a hair's breadth escape, Robin was caught by his hair."
			)
			(1
				(localproc_5)
				(localproc_1 1170 102 self) ; "Aye, once they'd removed his disguise, they made short work of him."
			)
			(2
				(localproc_8)
				(localproc_3 1170 103 self) ; "'Tis enough to keep a man beardless."
			)
			(3
				(localproc_9)
				(localproc_2 1170 104 self) ; "'Twas not the beard that was his undoing."
			)
			(4
				(localproc_2 1170 105 self) ; "It was his own carelessness in forgetting that the guard had seen him before."
			)
			(5
				(localproc_7)
				(localproc_0 1170 106 self) ; "Our next leader had best be wiser, whatever the state of his chin may be."
			)
			(6
				(localproc_10)
				(self dispose:)
			)
		)
	)
)

(instance tooLateInTheHedge of TScript
	(properties)

	(method (cue param1)
		(if (and argc (not param1))
			(localproc_10)
			(self dispose:)
		else
			(super cue: &rest)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_2 1170 107 self) ; "Alas for Marian! Alas for Robin! We have lost both in a single black day."
			)
			(1
				(localproc_7)
				(localproc_0 1170 108 self) ; "It is grievous indeed that he came so close, but lost himself in the maze."
			)
			(2
				(localproc_5)
				(localproc_4 1170 109 self) ; "It's too bad Robin didn't explore the maze earlier when he had disguises and more time."
			)
			(3
				(localproc_6)
				(localproc_3 1170 110 self) ; "It makes too grim a tale to sing, for they found Robin in the maze, mad and raging with grief."
			)
			(4
				(localproc_9)
				(localproc_1 1170 111 self) ; "But the Sheriff had no qualms about hanging a madman, all the same."
			)
			(5
				(localproc_8)
				(localproc_2 1170 112 self) ; "Robin could not save his soul, but let us hope he saved a game."
			)
			(6
				(localproc_10)
				(self dispose:)
			)
		)
	)
)

