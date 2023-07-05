;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 152)
(include sci.sh)
(use Main)
(use n142)
(use Interface)
(use Motion)
(use Game)
(use User)
(use System)

(public
	Bazaar 0
	proc152_1 1
	proc152_2 2
)

(procedure (proc152_1 &tmp temp0)
	(switch (= temp0 (gCurRoom notify:))
		(0
			(Print 152 0) ; "You are ignored, perhaps because you are obviously a 'foreign devil.'"
		)
		(-1
			(Print 152 1) ; "No one is here."
		)
		(else
			(Talk &rest)
		)
	)
)

(procedure (proc152_2)
	(cond
		((Said '//merlin>')
			(return 0)
		)
		((Said '//grail')
			(proc152_1 152 2) ; "I do not know of it."
		)
		((Said '//galahad,gawain,lancelot')
			(proc152_1 152 3) ; "Never heard of him."
		)
		((Said '//hierophant')
			(Print 152 4) ; "That brings you nothing but a look of confusion."
		)
		((Said '//guard')
			(proc152_1 152 5) ; "They are here to look for thieves."
		)
		((Said '//merchant,man,woman,girl')
			(Print 152 6) ; "I am not certain who you mean."
		)
		((Said '//cost')
			(Print 152 7) ; "It would be best to ask a merchant about the price of a certain thing."
		)
		((Said '//mohammed,ibrahim,farabi,fishmonger,ali,butcher,ismail,tariq')
			(proc152_1 152 8) ; "I have nothing to say about him."
		)
		((Said '//sarah,mari,ione,seeress,fatima,seeress')
			(proc152_1 152 9) ; "I have nothing to say about her."
		)
		((Said '//jerusalem,bazaar')
			(proc152_1 152 10) ; "Those who spend money are always welcome here."
		)
		(else
			(return 0)
		)
	)
	(return 1)
)

(instance Bazaar of Rgn
	(properties)

	(method (init &tmp temp0)
		(Load rsSCRIPT 153)
		(Load rsSCRIPT 150)
		(Load rsSCRIPT 151)
		(super init:)
		(gEgo view: 0 init:)
		(if (and (== gPrevRoomNum 0) (== gCurRoomNum 56))
			(SetFlag 20)
		)
		(if (IsFlag 20)
			(gCurRoom setRegions: 116) ; muleReg
			(gMuleObj setScript: muleActions)
		)
		(ClearFlag 139)
		(cond
			((>= global159 0)
				((ScriptID 165) init:) ; mercenary
			)
			((== global202 3)
				(self setScript: cityGuardMove)
			)
		)
		(cond
			(
				(or
					(IsFlag 20)
					(IsFlag 156)
					(>= global146 7)
					(== global157 gCurRoomNum)
					(== gCurRoomNum 56)
					(== gCurRoomNum 60)
					(> gCurRoomNum 62)
				)
				0
			)
			((> (++ global147) (Random 3 6))
				(= global147 0)
				(SetFlag 139)
				((ScriptID 154) init:) ; ione
			)
		)
		(if (!= (gRegMusic number:) 61)
			(gRegMusic number: 61 loop: -1 play:)
		)
		(= global145 4)
		(proc0_13 81)
	)

	(method (dispose)
		(DisposeScript 154)
		(DisposeScript 150)
		(DisposeScript 151)
		(super dispose:)
	)

	(method (doit)
		(super doit:)
		(if
			(and
				global190
				(not (gEgo script:))
				(!= gCurRoomNum 60)
				(User canInput:)
				(== (-- global190) 1)
			)
			(gTObj endTalk:)
			(SetFlag 165)
			(gEgo setScript: (ScriptID 166 0)) ; threeMercenaryAttack
		)
	)

	(method (handleEvent event)
		(cond
			(
				(or
					(event claimed:)
					(and
						(!= (event type:) evSAID)
						(not
							(and
								(== (event type:) evMOUSEBUTTON)
								(& (event modifiers:) emSHIFT)
							)
						)
					)
				)
				(return)
			)
			((Said 'use,eat/apple')
				(if (gEgo has: 4) ; rose | apple | green_apple
					(gEgo setScript: eatStrengthApple)
				else
					(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
				)
			)
			((or (Said 'draw/blade') (Said 'kill,attack/*'))
				(switch global168
					(0
						(Print 152 11) ; "You must not draw a weapon without good cause in this bazaar. The Muslims will not tolerate it and there are many of them and only one of you."
						(if global124
							(= global125 2)
						)
					)
					(else
						(gEgo setCycle: 0 setMotion: 0 setScript: 0)
						(gEgo setScript: hereComeTheGuards)
					)
				)
				(++ global168)
			)
		)
		(if (not (event claimed:))
			((ScriptID 153) handleEvent: event) ; bazaarSaids
			(if (not (event claimed:))
				((ScriptID 155) handleEvent: event) ; bazaarSaids2
			)
		)
	)
)

(instance cityGuardMove of Script
	(properties)

	(method (init)
		(super init: &rest)
		(if (== global173 0)
			(= global173 (Random 80 100))
		)
		(= seconds global173)
	)

	(method (doit)
		(super doit:)
		(= global173 seconds)
	)

	(method (cue)
		(= global160 -10)
		(= global161 330)
		(= global159 0)
	)
)

(instance muleActions of Script
	(properties)

	(method (init)
		(super init:)
		(gMuleObj setStep: (gEgo xStep:) (gEgo yStep:) setCycle: Walk)
		(cond
			((<= (gEgo x:) 20)
				(gMuleObj loop: 1 posn: 340 180 setMotion: MoveTo 305 180)
			)
			((>= (gEgo x:) 300)
				(gMuleObj loop: 0 posn: -10 180 setMotion: MoveTo 25 180)
			)
			(else
				(gMuleObj
					posn: (- 300 (gMuleObj x:)) 180
					loop: (if (== (gMuleObj loop:) 1) 0 else 1)
				)
			)
		)
	)

	(method (doit &tmp temp0)
		(= temp0 0)
		(cond
			((gMuleObj mover:) 0)
			((> (- (gMuleObj x:) (gEgo x:)) 70)
				(= temp0 50)
			)
			((> (- (gEgo x:) (gMuleObj x:)) 70)
				(= temp0 -50)
			)
		)
		(if temp0
			(gMuleObj setMotion: MoveTo (+ (gEgo x:) temp0) (gMuleObj y:))
		)
		(super doit:)
	)
)

(instance hereComeTheGuards of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 2)
			)
			(1
				(gTObj endTalk:)
				(gMuleObj setMotion: 0 looper: 0)
				(DisposeScript 919)
				(DisposeScript 910)
				(self dispose:)
				(gEgo setScript: (ScriptID 166 0)) ; threeMercenaryAttack
			)
		)
	)
)

(instance eatStrengthApple of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(proc142_0 self)
			)
			(1
				(Print 152 12) ; "The apple works its spell. Your hunger and thirst vanish. The heaviness of your limbs is lightened."
				(PutItem 4 0) ; rose | apple | green_apple
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

