;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 565)
(include sci.sh)
(use Main)
(use n013)
(use TheDungeon)
(use verseScript)
(use RTEyeCycle)
(use Motion)
(use Actor)
(use System)

(public
	peephole 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	[local6 15]
)

(procedure (localproc_0 param1 param2)
	(gCast eachElementDo: #perform hideMe)
	(= local0 gCast)
	(= local1 gFeatures)
	(= local2 gAddToPics)
	(= local3 gMouseDownHandler)
	(= gMouseDownHandler (= gCast (= gFeatures (= gAddToPics 0))))
	(gCurRoom drawPic: param1 param2)
	((= gCast newCast) add:)
	((= gFeatures newFeatures) add:)
	((= gMouseDownHandler newMDH) add: gFeatures)
	(SetMessageColor 19)
)

(procedure (localproc_1)
	(SetMessageColor 0)
	(gCast eachElementDo: #dispose eachElementDo: #delete release: dispose:)
	(gFeatures dispose:)
	(gMouseDownHandler dispose:)
	(gCurRoom drawPic: (gCurRoom picture:) 10)
	(= gCast local0)
	(= gFeatures local1)
	((= gAddToPics local2) doit:)
	(= gMouseDownHandler local3)
	(gCast eachElementDo: #perform showMe)
	(Animate (gCast elements:) 0)
)

(instance newCast of EventHandler
	(properties)
)

(instance newFeatures of EventHandler
	(properties)
)

(instance newMDH of EventHandler
	(properties)
)

(instance hideMe of Code
	(properties)

	(method (doit param1)
		(param1 z: (+ (param1 z:) 1000))
	)
)

(instance showMe of Code
	(properties)

	(method (doit param1)
		(param1 z: (- (param1 z:) 1000))
	)
)

(instance peephole of Code
	(properties)

	(method (doit)
		(HandsOff)
		(localproc_0 565 10)
		(cond
			((== gDay 10)
				(gCurRoom setScript: dayTenScript)
			)
			((IsFlag 213)
				(gCurRoom setScript: allDone)
			)
			((IsFlag 195)
				(gCurRoom setScript: allDone)
			)
			((and (== gPrevRoomNum 570) (IsFlag 125))
				(if (not (IsFlag 214))
					(gCurRoom setScript: guardsDoneDrinking)
				else
					(gCurRoom setScript: randomScript)
				)
			)
			((and (IsFlag 125) (not (IsFlag 214)))
				(gCurRoom setScript: guardsDoneDrinkingTwo)
			)
			((IsFlag 125)
				(gCurRoom setScript: randomScript)
			)
			((and (not (gEgo has: 13)) (not (IsFlag 125))) ; robes
				(if (TheDungeon firstLook:)
					(gCurRoom setScript: rogerEnter)
				else
					(gCurRoom setScript: randomScript)
				)
			)
			((IsFlag 31)
				(if (TheDungeon firstLook:)
					(gCurRoom setScript: rogerEnter)
				else
					(gCurRoom setScript: randomScript)
				)
			)
			((not (TheDungeon timerHasFired:))
				(gCurRoom setScript: rogerPace)
			)
			((or ((ScriptID 564 1) seconds:) ((ScriptID 564 3) seconds:)) ; shortTimer, warningTimer
				(gCurRoom setScript: shortTimerScript)
			)
			((not (TheDungeon coinsLeft:))
				(if (TheDungeon firstShortTimer:)
					(gCurRoom setScript: tryAgain)
				else
					(gCurRoom setScript: noMoreChances)
				)
			)
			((not (TheDungeon longTimerGone:))
				(cond
					((< (TheDungeon valueCoins:) 14)
						(if ((ScriptID 564 2) seconds:) ; longTimer
							(gCurRoom setScript: goneForAle)
						else
							(gCurRoom setScript: longTimerOne)
						)
					)
					(((ScriptID 564 2) seconds:) ; longTimer
						(gCurRoom setScript: goneForAle)
					)
					(else
						(gCurRoom setScript: longTimerTwo)
					)
				)
			)
			((not (TheDungeon boysRescued:))
				(gCurRoom setScript: randomScript)
			)
			(else
				(gCurRoom setScript: randomScript)
			)
		)
	)

	(method (dispose)
		(localproc_1)
		(DisposeScript 565)
	)
)

(instance roger of Actor
	(properties
		view 753
		signal 1
	)
)

(instance giles of Actor
	(properties
		view 753
		signal 1
	)
)

(instance coins of View
	(properties
		x 138
		y 112
		view 570
		loop 3
	)
)

(instance dayTenScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Say 1565 0) ; "Hmmm....no guards in this room."
				(= cycles 1)
			)
			(1
				(TheDungeon guardsGone: 1)
				(TheDungeon timeToDie: 0)
				(HandsOn)
				(self dispose:)
				(peephole dispose:)
			)
		)
	)
)

(instance randomScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local4 (Random 1 3))
				(giles view: 565 posn: 163 136 setPri: 9 init:)
				(switch local4
					(1
						(roger posn: (Random 111 191) (Random 123 130))
					)
					(2
						(roger posn: (Random 111 119) (Random 123 147))
					)
					(3
						(roger posn: (Random 106 148) (Random 145 147))
					)
				)
				(roger loop: (Random 0 4) init:)
				(SetMessageColor 19)
				(= cycles 10)
			)
			(1
				(cond
					((IsFlag 125)
						(Say 1565 6 80 {Roger}) ; "I'm drunk, Giles."
						(SayModeless 1565 7 80 {Giles}) ; "Shut up, Roger."
					)
					((or (not (gEgo has: 13)) (IsFlag 31)) ; robes
						(Say 1565 1 80 {Roger}) ; "I'm bored, Giles."
						(SayModeless 1565 2 80 {Giles}) ; "Shut up, Roger."
					)
					(else
						(Say 1565 3 80 {Roger}) ; "I'm drunk, Giles."
						(SayModeless 1565 4 80 {Giles}) ; "Shut up, Roger."
						(SetMessageColor 0)
						(Say 1565 5) ; "I fear I've lost my chance."
					)
				)
				(HandsOn)
				(self dispose:)
				(peephole dispose:)
			)
		)
	)
)

(instance rogerEnter of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(giles view: 565 posn: 163 136 setPri: 9 init:)
				(roger
					posn: 102 105
					setCycle: Walk
					init:
					setMotion: MoveTo 143 128 self
				)
				(SetMessageColor 19)
			)
			(1
				(Say 1565 8 self 80 {Roger}) ; "'Tis a grand night, isn't it, Giles?"
			)
			(2
				(SayModeless 1565 9 self 80 {Giles}) ; "What's so bloody grand about it? We're stuck on duty in the dungeons while the Sheriff's throwing a party at the pub."
			)
			(3
				(Say 1565 10 self 80 {Roger}) ; "Aye, but someone has to guard the prisoners."
			)
			(4
				(SayModeless 1565 11 self 80 {Giles}) ; "Bugger that! They're in that pit, not a prayer of escaping. I don't see why we need to be here at all."
			)
			(5
				(Say 1565 12 self 80 {Roger}) ; "Have they eaten?"
			)
			(6
				(SayModeless 1565 13 self 80 {Giles}) ; "Aye. Waste of food, if y'ask me. They'll be choking on ropes before long."
			)
			(7
				(Say 1565 14 self 80 {Roger}) ; "I'll have a look in on them, just the same."
			)
			(8
				(SayModeless 1565 15 self 80 {Giles}) ; "If you like."
			)
			(9
				(roger setMotion: MoveTo 85 128 self)
			)
			(10
				(= seconds 3)
			)
			(11
				(roger setMotion: MoveTo 143 128 self)
			)
			(12
				(Say 1565 16 self 80 {Roger}) ; "They look miserable, Giles."
			)
			(13
				(SayModeless 1565 17 self 80 {Giles}) ; "Of course they look miserable, you flap-ear'd dawkin. They're going to die."
			)
			(14
				(Say 1565 18 self 80 {Roger}) ; "There's no need to come over all insulting like. We're to be on guard for half the night together."
			)
			(15
				(SayModeless 1565 19 self 80 {Giles}) ; "Aye, just my rotten luck."
			)
			(16
				(TheDungeon firstLook: 0)
				(HandsOn)
				(self dispose:)
				(peephole dispose:)
			)
		)
	)
)

(instance rogerPace of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(giles posn: 153 146 cycleSpeed: 6 init:)
				(roger posn: 93 128 setCycle: Walk init:)
				(Face giles roger self)
			)
			(1
				(roger setMotion: MoveTo 215 128 self)
			)
			(2
				(roger setMotion: MoveTo 93 128 self)
			)
			(3
				(roger setMotion: MoveTo 215 128 self)
			)
			(4
				(roger setMotion: MoveTo 143 128 self)
			)
			(5
				(SetMessageColor 19)
				(SayModeless 1565 20 1 80 {Giles}) ; "Will you stop that confounded pacing!"
				(roger setMotion: MoveTo 93 128 self)
			)
			(6
				(roger setMotion: MoveTo 143 128 self)
			)
			(7
				(Say 1565 21 1 80 {Roger}) ; "I'm bored."
				(roger setMotion: MoveTo 215 128 self)
			)
			(8
				(roger setMotion: MoveTo 143 128 self)
			)
			(9
				(SayModeless 1565 22 self 80 {Giles}) ; "Sneak us up a bucket of ale from the pub. That'll keep you busy. I've got such a thirst, I'd throttle me own mother for a mug right now."
			)
			(10
				(Say 1565 23 self 80 {Roger}) ; "Give me some money then."
			)
			(11
				(SayModeless 1565 24 self 80 {Giles}) ; "Ahem...well...if you could pay for it this time--"
			)
			(12
				(Say 1565 25 self 80 {Roger}) ; "I knew it! You lost it all to Old Harry playing Nine Men's Morris, didn't you?"
			)
			(13
				(SayModeless 1565 26 self 80 {Giles}) ; "Aw, come on, Roger. Be a good lad--"
			)
			(14
				(Say 1565 27 self 80 {Roger}) ; "I haven't enough."
			)
			(15
				(SayModeless 1565 28 self 80 {Giles}) ; "We only need four pennies."
			)
			(16
				(= cycles 1)
			)
			(17
				(Say 1565 29 self 80 {Roger}) ; "I've got two farthings and that's it."
			)
			(18
				(SayModeless 1565 30 self 80 {Giles}) ; "He won't fill the bucket for less than four pennies."
			)
			(19
				(Say 1565 31 self 80 {Roger}) ; "Sorry. That's all I've got."
			)
			(20
				(SayModeless 1565 32 self 80 {Giles}) ; "Hie yourself up the stairs and tell Jack I need a loan."
			)
			(21
				(Say 1565 33 self 80 {Roger}) ; "Why should I--"
			)
			(22
				(SayModeless 1565 34 self 80 {Giles}) ; "Go on. By Ges, if I don't have an ale before the night is out, you'll never hear the end of it."
			)
			(23
				(Say 1565 35 self 80 {Roger}) ; "Very well, if it'll improve your foul temper."
			)
			(24
				(roger setMotion: MoveTo 102 105)
				(= seconds 4)
			)
			(25
				(SayModeless 1565 36 80 {Giles}) ; "Wait. I already owe Jack money."
				(giles setCycle: Walk setMotion: MoveTo 116 146 self)
			)
			(26
				(giles setMotion: MoveTo 117 128 self)
			)
			(27
				(giles setMotion: MoveTo 135 120 self)
			)
			(28
				(giles setMotion: MoveTo 92 107 self)
			)
			(29
				((ScriptID 564 1) seconds: 15) ; shortTimer
				(TheDungeon setScript: (ScriptID 564 1)) ; shortTimer
				(TheDungeon neverBefore: 1)
				(TheDungeon timeToDie: 0)
				(TheDungeon guardsGone: 1)
				(TheDungeon timerHasFired: 1)
				(TheDungeon firstShortTimer: 1)
				(SetFlag 212)
				(HandsOn)
				(self dispose:)
				(peephole dispose:)
			)
		)
	)
)

(instance shortTimerScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (TheDungeon coinsLeft:)
					(for
						((= local5 1))
						(and
							(<= local5 (TheDungeon numberCoins:))
							(< local5 15)
						)
						((++ local5))
						
						((= [local6 local5] (coins new:))
							setPri: 11
							init:
							posn: (Random 133 163) (Random 109 113)
						)
					)
				)
				(= cycles 1)
			)
			(1
				(Say 1565 37) ; "The guards have left, but not for long, I'll wager."
				(HandsOn)
				(self dispose:)
				(peephole dispose:)
			)
		)
	)
)

(instance tryAgain of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(giles posn: 187 144 setCycle: Walk init:)
				(roger posn: 114 145 setCycle: Walk init:)
				(Face roger giles)
				(Face giles roger)
				(Say 1565 38 self 80 {Roger}) ; "Jack wasn't very polite about it, was he?"
			)
			(1
				(SayModeless 1565 39 self 80 {Giles}) ; "He's a spiteful wretch. I'm telling you, I'd brain me own sister for a mug right now."
			)
			(2
				(Say 1565 40 self 80 {Roger}) ; "Well, there's no point going on about it when we haven't got a penny between us."
			)
			(3
				(SayModeless 1565 41 self 80 {Giles}) ; "I know! Go ask Will the Weasel."
			)
			(4
				(Say 1565 42 self 80 {Roger}) ; "I don't know him."
			)
			(5
				(SayModeless 1565 43 self 80 {Giles}) ; "C'mon then. You've got to meet Will the Weasel."
			)
			(6
				(giles setMotion: MoveTo 152 146 self)
			)
			(7
				(roger setMotion: MoveTo 117 128)
				(giles setMotion: MoveTo 116 146 self)
			)
			(8
				(giles setMotion: MoveTo 117 128)
				(roger setMotion: MoveTo 135 120 self)
			)
			(9
				(roger setMotion: MoveTo 102 105)
				(giles setMotion: MoveTo 135 120 self)
			)
			(10
				(giles setMotion: MoveTo 92 107 self)
			)
			(11
				((ScriptID 564 1) seconds: 15) ; shortTimer
				(TheDungeon setScript: (ScriptID 564 1)) ; shortTimer
				(TheDungeon neverBefore: 1)
				(TheDungeon timeToDie: 0)
				(TheDungeon guardsGone: 1)
				(TheDungeon timerHasFired: 1)
				(TheDungeon firstShortTimer: 0)
				(HandsOn)
				(self dispose:)
				(peephole dispose:)
			)
		)
	)
)

(instance noMoreChances of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(roger posn: 130 124 init:)
				(giles posn: 142 147 init:)
				(Face giles roger)
				(Face roger giles)
				(Say 1565 44 self 80 {Roger}) ; "So that's Will the Weasel. Do you think he'll ever pay back the two farthings he just borrowed from me?"
			)
			(1
				(SayModeless 1565 45 self 80 {Giles}) ; "Miserable little dung-eating ferret. I'd cut me own father's throat for a mug right now."
			)
			(2
				(Say 1565 46 self 80 {Roger}) ; "I thank Heaven that I'm not related to you, Giles."
			)
			(3
				(SetFlag 195)
				(TheDungeon tooLate: 1)
				(HandsOn)
				(self dispose:)
				(peephole dispose:)
			)
		)
	)
)

(instance allDone of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(roger posn: 135 120 init:)
				(giles view: 565 posn: 163 136 setPri: 9 init:)
				(SetMessageColor 0)
				(Say 1565 47) ; "I fear they've settled in for good."
				(= cycles 1)
			)
			(1
				(HandsOn)
				(self dispose:)
				(peephole dispose:)
			)
		)
	)
)

(instance goneForAle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (TheDungeon coinsDoneBeenTook:))
					(for
						((= local5 1))
						(and
							(<= local5 (TheDungeon numberCoins:))
							(< local5 15)
						)
						((++ local5))
						
						((= [local6 local5] (coins new:))
							setPri: 11
							init:
							posn: (Random 133 163) (Random 109 113)
						)
					)
				)
				(= cycles 2)
			)
			(1
				(Say 1565 48) ; "They should be gone long enough to buy and drink a bucket of ale."
				(= cycles 1)
			)
			(2
				(HandsOn)
				(self dispose:)
				(peephole dispose:)
			)
		)
	)
)

(instance longTimerOne of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(roger posn: 130 124 setCycle: Walk init:)
				(giles posn: 151 147 setCycle: Walk init:)
				(Face roger giles)
				(Face giles roger)
				(coins setPri: 9 init:)
				(SayModeless 1565 49 self 80 {Giles}) ; "Roger, did you leave this money here?"
			)
			(1
				(Say 1565 50 self 80 {Roger}) ; "Not me. If you mean to pretend you just found it--"
			)
			(2
				(SayModeless 1565 51 self 80 {Giles}) ; "I DID just find it!"
			)
			(3
				(Say 1565 52 self 80 {Roger}) ; "It's still not enough."
			)
			(4
				(SayModeless 1565 53 self 80 {Giles}) ; "Ah, eh, well, I've suddenly remembered that I have a couple of pennies in me boot after all."
			)
			(5
				(Say 1565 54 self 80 {Roger}) ; "You lying, miserly hound!"
			)
			(6
				(SayModeless 1565 55 self 80 {Giles}) ; "Never mind that! Stay here while I fetch the ale."
			)
			(7
				(Say 1565 56 self 80 {Roger}) ; "I'll never taste a drop if you fetch it. We'll both go."
			)
			(8
				(giles setMotion: MoveTo 138 146 self)
			)
			(9
				(coins dispose:)
				(TheDungeon coinsDoneBeenTook: 1)
				(roger setMotion: MoveTo 117 128)
				(giles setMotion: MoveTo 116 146 self)
			)
			(10
				(giles setMotion: MoveTo 117 128)
				(roger setMotion: MoveTo 135 120 self)
			)
			(11
				(roger setMotion: MoveTo 102 105)
				(giles setMotion: MoveTo 135 120 self)
			)
			(12
				(giles setMotion: MoveTo 92 107 self)
			)
			(13
				((ScriptID 564 2) seconds: 60) ; longTimer
				(TheDungeon setScript: (ScriptID 564 2)) ; longTimer
				(TheDungeon neverBefore: 1)
				(TheDungeon timeToDie: 0)
				(TheDungeon guardsGone: 1)
				(TheDungeon timerHasFired: 1)
				(SetScore 50)
				(HandsOn)
				(self dispose:)
				(peephole dispose:)
			)
		)
	)
)

(instance longTimerTwo of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(roger posn: 130 124 setCycle: Walk init:)
				(giles posn: 151 147 setCycle: Walk init:)
				(Face roger giles)
				(Face giles roger)
				(coins setPri: 9 init:)
				(Say 1565 57 self 80 {Roger}) ; "He wasn't much help, was he? Do you think he'll ever pay back the two farthings he just borrowed from me?"
			)
			(1
				(SayModeless 1565 58 self 80 {Giles}) ; "He's a miserable little dung-eating ferret. I trow, I'd cut me own father's throat for a mug right now."
			)
			(2
				(Say 1565 59 self 80 {Roger}) ; "I thank Heaven that I'm not related to you, Giles."
			)
			(3
				(SayModeless 1565 60 self 80 {Giles}) ; "Roger, you sly old dog!"
			)
			(4
				(Say 1565 61 self 80 {Roger}) ; "What?"
			)
			(5
				(SayModeless 1565 62 self 80 {Giles}) ; "You left this money on the table when I wasn't looking!"
			)
			(6
				(Say 1565 63 self 80 {Roger}) ; "What?! I did no such thing!"
			)
			(7
				(SayModeless 1565 64 self 80 {Giles}) ; "Have your little jest, if you like. Stay here while I fetch the ale."
			)
			(8
				(Say 1565 65 self 80 {Roger}) ; "I'll never taste a drop if you fetch it. We'll both go."
			)
			(9
				(giles setMotion: MoveTo 138 146 self)
			)
			(10
				(coins dispose:)
				(TheDungeon coinsDoneBeenTook: 1)
				(roger setMotion: MoveTo 117 128)
				(giles setMotion: MoveTo 116 146 self)
			)
			(11
				(giles setMotion: MoveTo 117 128)
				(roger setMotion: MoveTo 135 120 self)
			)
			(12
				(roger setMotion: MoveTo 102 105)
				(giles setMotion: MoveTo 135 120 self)
			)
			(13
				(giles setMotion: MoveTo 92 107 self)
			)
			(14
				(SetScore 100)
				((ScriptID 564 2) seconds: 60) ; longTimer
				(TheDungeon setScript: (ScriptID 564 2)) ; longTimer
				(TheDungeon neverBefore: 1)
				(TheDungeon timeToDie: 0)
				(TheDungeon guardsGone: 1)
				(TheDungeon timerHasFired: 1)
				(HandsOn)
				(self dispose:)
				(peephole dispose:)
			)
		)
	)
)

(instance guardsDoneDrinking of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(roger
					posn: 102 105
					setCycle: Walk
					init:
					setMotion: MoveTo 135 120 self
				)
			)
			(1
				(giles posn: 92 107 setCycle: Walk init:)
				(roger setMotion: MoveTo 117 128)
				(giles setMotion: MoveTo 135 120 self)
			)
			(2
				(roger setMotion: MoveTo 116 146)
				(giles setMotion: MoveTo 117 128 self)
			)
			(3
				(roger setMotion: MoveTo 152 146 self)
			)
			(4
				(Face roger giles)
				(Face giles roger)
				(= cycles 1)
			)
			(5
				(Say 1565 66 self 80 {Roger}) ; "My oath, Giles! The Captain nearly caught us with that bucket."
			)
			(6
				(SayModeless 1565 67 self 80 {Giles}) ; "Aye, we daren't step another foot outside this door tonight!"
			)
			(7
				(Say 1565 68 self 80 {Roger}) ; "But we downed a bucket of ale between us! I'll need to visit the privy."
			)
			(8
				(SayModeless 1565 69 self 80 {Giles}) ; "You clodpate. We can go one at a time."
			)
			(9
				(Say 1565 70 self 80 {Roger}) ; "D'ye think we should check on the prisoners?"
			)
			(10
				(SayModeless 1565 71 self 80 {Giles}) ; "They haven't gone anywhere unless they've learned to walk through stone. Now quiet down. You chatter like a bloody magpie."
			)
			(11
				(SetFlag 214)
				(TheDungeon firstAfterRescue: 0)
				(HandsOn)
				(self dispose:)
				(peephole dispose:)
			)
		)
	)
)

(instance guardsDoneDrinkingTwo of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(roger posn: 121 141 init:)
				(giles posn: 173 130 init:)
				(Face giles roger)
				(Face roger giles)
				(= cycles 1)
			)
			(1
				(Say 1565 72 self 80 {Roger}) ; "My oath, Giles! The Captain nearly caught us with that bucket."
			)
			(2
				(SayModeless 1565 73 self 80 {Giles}) ; "Aye, we daren't step another foot outside this door tonight!"
			)
			(3
				(Say 1565 74 self 80 {Roger}) ; "But we downed a bucket of ale between us! I'll need to visit the privy."
			)
			(4
				(SayModeless 1565 75 self 80 {Giles}) ; "You clodpate. We can go one at a time."
			)
			(5
				(Say 1565 76 self 80 {Roger}) ; "D'ye think we should check on the prisoners?"
			)
			(6
				(SayModeless 1565 77 self 80 {Giles}) ; "They haven't gone anywhere unless they've learned to walk through stone. Now quiet down. You chatter like a bloody magpie."
			)
			(7
				(SetFlag 214)
				(TheDungeon firstAfterRescue: 0)
				(HandsOn)
				(self dispose:)
				(peephole dispose:)
			)
		)
	)
)

