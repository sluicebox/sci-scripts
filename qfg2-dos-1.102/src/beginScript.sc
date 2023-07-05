;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 366)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use n003)
(use HandsOffScript)
(use Talker)
(use rm360)
(use Grooper)
(use Motion)
(use Actor)
(use System)

(public
	beginScript 0
)

(local
	[string 200]
	theCost
)

(procedure (LookRight)
	(if (!= (egoHead cel:) 2)
		(egoHead setCycle: CT 2 1)
	)
)

(procedure (LookLeft)
	(if (== (egoHead cel:) 2)
		(egoHead setCycle: End)
	)
)

(procedure (DismissEgo whoCares)
	(if (or (== gTimeODay 4) (== gTimeODay 5))
		(Say
			(ScriptID 360 1) ; ferrari
			whoCares
			((ScriptID 360 1) msgFile:) ; ferrari
			16
			((ScriptID 360 1) msgFile:) ; ferrari
			18
		)
	else
		(Say
			(ScriptID 360 1) ; ferrari
			whoCares
			((ScriptID 360 1) msgFile:) ; ferrari
			16
			((ScriptID 360 1) msgFile:) ; ferrari
			17
		)
	)
)

(instance egoHead of Prop
	(properties
		view 361
		loop 4
		priority 14
		signal 16
	)
)

(instance theDrink of View
	(properties
		x 251
		y 188
		z 20
		view 363
		loop 12
		signal 16384
	)
)

(instance beginScript of Script
	(properties)

	(method (init)
		(if (== gInnState 3)
			((ScriptID 364 0) setLoop: 1 posn: 115 175 init:) ; ugarte
		)
		(super init: &rest)
		(DontMove 1)
		(= global75 self)
		(if (not (gCast contains: (ScriptID 360 1))) ; ferrari
			((ScriptID 360 1) init:) ; ferrari
		)
	)

	(method (dispose)
		(= global75 0)
		(super dispose:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'stand,(get,get<up),done')
				(switch gInnState
					(1
						(if (and (not (IsFlag 110)) ((ScriptID 360 2) script:)) ; bartender
							((ScriptID 360 2) setLoop: -1 setLoop: Grooper) ; bartender
							(((ScriptID 360 2) script:) changeState: 5) ; bartender
						)
						(DismissEgo self)
					)
					(else
						(self cue:)
					)
				)
			)
			((Said 'drink>')
				(cond
					((not (IsFlag 110))
						(event claimed: 1)
						(HighPrint 366 0) ; "You have nothing to drink."
						(return)
					)
					((and (IsFlag 102) (Said '/coffee'))
						(HighPrint 366 1) ; "The drink you ordered resembles nothing you've dared to drink in the past. Therefore, it must be a Djinn Sling."
					)
					((and (not (IsFlag 102)) (Said '/sling'))
						(HighPrint 366 2) ; "The cup of black liquid before you more resembles coffee than a Djinn Sling. Come to think of it, you did order coffee."
					)
					((not (or (Said '/coffee') (Said '/sling') (Said '[/!*]')))
						(HighPrint 366 3) ; "You don't have one of those, but you pick up the glass in front of you."
					)
				)
				(event claimed: 1)
				(self setScript: drinkStuff self)
			)
			((Said 'look,look>')
				(cond
					((not (IsFlag 110))
						(HighPrint 366 4) ; "Have patience! The bartender doesn't seem too interested in moving quickly."
					)
					((IsFlag 102)
						(cond
							((Said '/coffee')
								(HighPrint 366 5) ; "It looks more like a Djinn Sling."
							)
							((Said '/sling,drink')
								(HighPrint 366 6) ; "It looks fizzy and dangerous."
							)
						)
					)
					((Said '/sling')
						(HighPrint 366 7) ; "It looks more like coffee."
					)
					((Said '/coffee,drink')
						(HighPrint 366 8) ; "It looks like brown ooze."
					)
				)
			)
			((and (== gInnState 1) (Said 'talk,talk,ask'))
				(DismissEgo self)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 361
					setLoop: 1
					setCel: 0
					setPri: 12
					posn: 264 161
					init:
				)
				(egoHead posn: (+ (gEgo x:) 2) (- (gEgo y:) 10) init:)
				(= cycles 1)
			)
			(1
				(switch gInnState
					(1
						((ScriptID 360 2) setScript: serveDrinks) ; bartender
					)
					(3
						((ScriptID 364 0) setScript: ugarteTalk) ; ugarte
					)
					(8
						(= cycles 1)
					)
				)
			)
			(2
				(DontMove 0)
				(if (and (>= gTimeODay 4) (== gInnState 1))
					(++ gInnState)
					(gCurRoom newRoom: 370)
				else
					(gEgo setScript: standEgo)
				)
				(self dispose:)
			)
		)
	)
)

(instance drinkStuff of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (IsFlag 102)
					(HighPrint 366 9) ; "The drink is sweet, with a very bitter aftertaste."
				else
					(HighPrint 366 10) ; "You drink the bitter, thick liquid."
				)
				(HighPrint 366 11) ; "It has an odd, almost chemical, taste."
				(ClearFlag 110)
				(= cycles 1)
			)
			(1
				(cond
					((or (TrySkill 3 125) (IsFlag 121)) ; Vitality
						(ClearFlag 121)
						(HighPrint 366 12) ; "You feel strange for a few seconds, but the feeling passes. Ferrari starts to ask some very probing questions, but you evade most of them."
						(Say (ScriptID 360 1) self 366 13) ; "You are a very closed-mouth individual. You handle your drink very well. I trust you will handle yourself in Raseir as well.", ferrari
						(AdvanceTime 1 0)
					)
					((TrySkill 3 75) ; Vitality
						(HighPrint 366 14) ; "You feel a bit odd. Signor Ferrari smiles at you and starts to question you. He is particularly interested in Shapeir, and questions you thoroughly. You are having a difficult time trying not to say too much."
						(Say (ScriptID 360 1) self 366 15) ; "Humm, there is much to what you say, and much more to what you don't say, I suspect.", ferrari
						(AdvanceTime 2 0)
					)
					(else
						(HighPrint 366 16) ; "You start to feel a bit dizzy. Signor Ferrari smiles at you and starts to ask questions about yourself. You find yourself answering, telling your friend all about your adventures. He is particularly interested in Shapeir, and questions you thoroughly. After a while, though, you start to get a headache. Ferrari frowns."
						(Say (ScriptID 360 1) self 366 17) ; "You have led a most interesting and charmed life, it seems. But it would take a miracle to restore Raseir, and Khaveen has outlawed miracles. You are very dangerous to me, for your actions will have serious repercussions. Nevertheless, you may have your uses.", ferrari
						(AdvanceTime 3 0)
					)
				)
			)
			(2
				(if (or (== gTimeODay 4) (== gTimeODay 5))
					(Say
						(ScriptID 360 1) ; ferrari
						self
						((ScriptID 360 1) msgFile:) ; ferrari
						18
					)
				else
					(Say
						(ScriptID 360 1) ; ferrari
						self
						((ScriptID 360 1) msgFile:) ; ferrari
						17
					)
				)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance standEgo of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (and (== gInnState 3) (gCast contains: (ScriptID 364 0))) ; ugarte
					((ScriptID 364 1) cue:) ; ugarteTimer
				)
				(gEgo
					posn: (- (gEgo x:) 8) (+ (gEgo y:) 10)
					setLoop: 0
					setCycle: Beg self
				)
				(egoHead dispose:)
			)
			(1
				(gEgo view: 0 setLoop: 2)
				(= cycles 1)
			)
			(2
				(gEgo
					view: 0
					setLoop: -1
					setLoop: gEgoLooper
					setCel: -1
					setHeading: 270 self
				)
			)
			(3
				(gEgo setCycle: gEgoStopWalk 4 setMotion: MoveTo 200 175 self)
			)
			(4
				(gEgo setPri: -1)
				(self dispose:)
			)
		)
	)
)

(instance serveDrinks of Script
	(properties)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'talk,talk,ask')
				(if (IsFlag 112)
					(Say (ScriptID 360 1) 366 18) ; "Now, now. Pleasure before business. Here come our drinks even as we speak.", ferrari
				else
					(event claimed: 0)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(DontTalk 0)
				(SetFlag 112)
				((ScriptID 360 3) dispose:) ; barMoveTimer
				((ScriptID 360 4) dispose:) ; wipeTimer
				((ScriptID 360 2) setLoop: 9 setCycle: End self) ; bartender
			)
			(1
				((ScriptID 360 2) ; bartender
					posn:
						(+ ((ScriptID 360 2) x:) 1) ; bartender
						(+ ((ScriptID 360 2) y:) 18) ; bartender
					setLoop: 11
					setPri: 11
					setCycle: Walk
					setMotion: MoveTo 118 149 self
				)
			)
			(2
				((ScriptID 360 2) setMotion: MoveTo 225 179 self) ; bartender
			)
			(3
				(LookRight)
				((ScriptID 360 2) setPri: 14 setMotion: MoveTo 235 189 self) ; bartender
			)
			(4
				(LookLeft)
				(ClearFlag 112)
				(SetFlag 110)
				(theDrink init:)
				((ScriptID 360 2) ; bartender
					setLoop: -1
					setLoop: Grooper
					setMotion: MoveTo 225 179 self
				)
				(Say (ScriptID 360 1) 366 19) ; "Let us drink to our fortunate meeting!", ferrari
			)
			(5
				((ScriptID 360 2) setPri: -1 setMotion: MoveTo 118 149 self) ; bartender
			)
			(6
				((ScriptID 360 2) setMotion: MoveTo 99 157 self) ; bartender
			)
			(7
				((ScriptID 360 2) ; bartender
					posn:
						(- ((ScriptID 360 2) x:) 1) ; bartender
						(- ((ScriptID 360 2) y:) 18) ; bartender
					setLoop: 8
					setPri: 12
				)
				(StartTimer (ScriptID 360 3) 2 10) ; barMoveTimer
				(StartTimer (ScriptID 360 4) 2) ; wipeTimer
				(self dispose:)
			)
		)
	)
)

(instance ugarteTalk of Script
	(properties)

	(method (handleEvent event &tmp rc)
		(cond
			((super handleEvent: event))
			((or (Said 'buy/info') (Said 'pay,give'))
				(= theCost 500)
				(client setScript: payUgarte 0 0)
			)
			((Said 'bargain')
				(= theCost (if (TrySkill 13 125) 300 else 500)) ; communication
				(client setScript: payUgarte 0 1)
			)
			((Said 'no')
				(client setScript: ugarteInsultS)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if register
					(self changeState: 6)
				else
					(LookRight)
					((ScriptID 364 0) ; ugarte
						illegalBits: 0
						setLoop: -1
						setLoop: Grooper
						setCycle: Walk
						setMotion: MoveTo 235 189 self
					)
				)
			)
			(1
				(= global75 (ScriptID 364 0)) ; ugarte
				(Say (ScriptID 364 0) self 366 20) ; "I am very pleased to make your acquaintance. I have heard much about you already.", ugarte
			)
			(2
				(LookLeft)
				(Say (ScriptID 360 1) self 366 21) ; "Ugarte, here, provides an invaluable service to this community. He obtains for others things which are otherwise unattainable.", ferrari
			)
			(3
				(LookRight)
				(Say (ScriptID 364 0) self 366 22) ; "For a nominal fee, of course.", ugarte
			)
			(4
				(LookLeft)
				(Say (ScriptID 360 1) self 366 23) ; "It seems he has some information for you.", ferrari
			)
			(5
				(LookRight)
				(Say (ScriptID 364 0) self 366 24) ; "A rumor, perhaps, that may influence your actions. I will be happy to share such information for, say, five dinars?", ugarte
			)
			(6
				(HandsOn 1)
				(DontMove 1)
			)
			(7
				(DontTalk 1)
				(self dispose:)
			)
		)
	)
)

(instance payUgarte of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if register
					(if (== theCost 300)
						(Say (ScriptID 364 0) self 366 25) ; "Well, seeing as you are a hero and all, perhaps we could settle for say, 3 dinars?", ugarte
					else
						(Say (ScriptID 364 0) self 366 26) ; "I am sorry, but I am just a poor businessman. Surely a hero such as yourself can spare a few measly dinars for information which might save his life?", ugarte
						(client setScript: ugarteTalk 0 1)
					)
				else
					(self cue:)
				)
			)
			(1
				(switch (CheckFunds theCost)
					(1
						(Say
							(ScriptID 364 0) ; ugarte
							self
							(Format @string 366 27 @gUserName) ; "Forgive me, %s, but I do not accept foreign coin."
						)
					)
					(2
						(GiveMoney theCost)
						(SetFlag 111)
						(self changeState: 3)
					)
					(0
						(HighPrint 366 28) ; "You find you do not have the money. Ugarte quickly loses interest in you."
						(Say (ScriptID 364 0) self 366 29) ; "Well, what kind of hero are you? You come into town acting like you are a wealthy man, and make poor honest businessmen such as myself work for nothing.", ugarte
					)
				)
			)
			(2
				(client setScript: ugarteInsultS)
			)
			(3
				(LookRight)
				(SkillUsed 1 100) ; intelligence
				(Say (ScriptID 364 0) self 366 30) ; "Khaveen has sent the word out to his men that you are to be watched at all times. It seems that, ah, Someone is very interested in your actions. You should be aware that Khaveen does not usually greet strangers at the gate. You were expected.", ugarte
			)
			(4
				(LookLeft)
				(Say (ScriptID 360 1) self 366 31) ; "Why would He take an interest?", ferrari
			)
			(5
				(LookRight)
				(Say (ScriptID 364 0) self 366 32) ; "There is the little matter of a prophecy to be fulfilled and this one may be the one.", ugarte
			)
			(6
				(LookLeft)
				(Say
					(ScriptID 360 1) ; ferrari
					self
					(Format @string 366 33 @gUserName) ; "I suspected before that you were a very dangerous man to have around, %s. It seems I am correct."
					366
					34
				)
			)
			(7
				(StartTimer (ScriptID 364 1) 15) ; ugarteTimer
				(self dispose:)
			)
		)
	)
)

(instance ugarteInsultS of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 364 0) setMotion: MoveTo 180 190 self) ; ugarte
			)
			(1
				(LookLeft)
				((ScriptID 364 0) setMotion: MoveTo 160 250 self) ; ugarte
				(Say (ScriptID 360 1) self 366 35) ; "You may live to regret arriving here with no money. Do you think to live on charity? Wilmer, show our poor hero here to quarters more fitting his purse.", ferrari
			)
			(2
				(KillEgo 0 {Now you're broke AND busted!})
			)
		)
	)
)

