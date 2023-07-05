;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 120)
(include sci.sh)
(use Main)
(use dartScript)
(use n101)
(use n102)
(use n814)
(use Ego)
(use Sound)
(use System)

(public
	egoSez 0
)

(local
	local0
	local1
)

(procedure (localproc_0)
	(if (IsFlag 124)
		(ClearFlag 124)
		(ClearFlag 125)
	else
		(= gFreeMeals 1)
	)
)

(instance egoSez of Code
	(properties)

	(method (doit param1 &tmp temp0 temp1 temp2)
		(switch param1
			(81
				(= temp0 ((= temp2 (Event new:)) x:))
				(= temp1 (+ (temp2 y:) 25))
				(temp2 dispose:)
				(CastDart 0 0 temp0 temp1)
			)
			(11
				(= local1 1)
				(gMessager say: 1 11 0 0 0 120) ; "The rations are tasteless but filling."
				(localproc_0)
				(gEgo setScript: cueIt)
			)
			(16
				(ThrowKnife 0)
			)
			(17
				(gEgo setScript: pickScript)
			)
			(20
				(ThrowRock 0)
			)
			(22
				(gMessager say: 1 22 0 0 0 120 cueIt) ; "The drink soothes as it goes down."
				(TakeDamage (- (/ (MaxHealth) 2)))
				(= local1 2)
				(gEgo setScript: cueIt)
			)
			(23
				(gMessager say: 1 23 0 0 0 120 cueIt) ; "The drink burns as it goes down."
				(UseMana (- (/ (MaxMana) 2)))
				(= local1 3)
				(gEgo setScript: cueIt)
			)
			(24
				(gMessager say: 1 24 0 0 0 120 cueIt) ; "The drink is invigorating."
				(UseStamina (- (MaxStamina)))
				(= local1 4)
				(gEgo setScript: cueIt)
			)
			(25
				(gMessager say: 1 25 0 0 0 120 cueIt) ; "You don't feel anything. Perhaps this was not the correct way to use this potion."
				(= local1 5)
				(gEgo setScript: cueIt)
			)
			(29
				(gMessager say: 1 29 0 0 0 120 cueIt) ; "You feel a tingling sensation as you rub the unguent all over your body."
				(SetFlag 168)
				(ClearFlag 164)
				(= global200 150)
				(= local1 6)
				(gEgo setScript: cueIt)
			)
			(32
				(gMessager say: 1 32 0 0 0 120 cueIt) ; "You eat some of the apples. They actually taste quite good."
				(localproc_0)
				(= local1 7)
				(gEgo setScript: cueIt)
			)
			(33
				(gMessager say: 1 33 0 0 0 120 cueIt) ; "You eat some vegetables. You think they would have been better saved for cows or horses. Real Heroes eat preserved dry rations."
				(localproc_0)
				(= local1 8)
				(gEgo setScript: cueIt)
			)
			(34
				(gEgo setScript: acornScript)
			)
			(38
				(gMessager say: 1 38 0 0 0 120) ; "You sprinkle just a smidge of the magical dust on and about your person..."
			)
			(39
				(gMessager say: 1 39 0 0 0 120 cueIt) ; "You drink the clear water from the flask, draining it completely."
				(= local1 9)
				(gEgo setScript: cueIt)
			)
			(40
				(cond
					((IsFlag 148)
						(gEgo setScript: toadScript)
					)
					(
						(not
							(OneOf
								gCurRoomNum
								11
								12
								17
								18
								19
								23
								24
								25
								26
								27
								33
								34
								35
								36
								42
								43
								44
								51
								52
								56
								57
								61
								62
								63
								69
								70
								71
								72
								74
								75
								79
								80
								81
								85
								86
								92
								170
							)
						)
						(gMessager say: 1 40 4 0 0 120) ; "You don't need to do that right now."
					)
					(else
						(SetFlag 286)
						(gEgo setScript: mushScript)
					)
				)
			)
			(else
				(Ego doVerb: param1 &rest)
			)
		)
	)
)

(instance pickScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gMessager say: 1 17 0 0 self 120) ; "You delicately insert the lockpick into your left nostril."
			)
			(1
				(if (not (TrySkill 9 40)) ; pick locks
					(EgoDead 106 107) ; "Unfortunately, you push it in too far, causing yourself a cerebral hemorrhage. Guess you should have been practicing on less difficult locks."
				else
					(gMessager say: 1 17 1 0 self 120) ; "Success! Your nose is now open."
				)
			)
			(2
				(HandsOn)
				(self dispose:)
				(DisposeScript 120)
			)
		)
	)
)

(instance toadScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo use: 30 3) ; mushroom
				(HandsOff)
				(= ticks 60)
			)
			(1
				(if (IsFlag 279)
					(gMessager say: 1 40 7 1 self 120) ; "The mushrooms from the Fairy Ring are pretty good, so you hear. However, when they're mixed with Kobold toadstools... that's a horse of a different color."
				else
					(self cue:)
				)
			)
			(2
				(gMessager say: 1 40 7 2 self 120) ; "You eat some of the Kobold's fungus. Within seconds your insides feel like they're on fire. Guess you're not a Kobold, huh?"
			)
			(3
				(if (<= [gEgoStats 14] 20) ; health
					(EgoDead 166) ; "Didn't anyone warn you about eating other people's food? Death by Toadstools doesn't leave mushroom for improvement."
				else
					(TakeDamage 20)
					(gMessager say: 1 40 7 4 self 120) ; "You think that you'd better take it easy for a while until you recover."
				)
				(if (not (gEgo has: 30)) ; mushroom
					(ClearFlag 148)
				)
			)
			(4
				(HandsOn)
				(self dispose:)
				(DisposeScript 120)
			)
		)
	)
)

(instance acornScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gMessager say: 1 34 0 0 0 120) ; "You eat the Magic Acorn. It tastes terrible. Better stick to real food next time."
				(= seconds 2)
			)
			(1
				(SolvePuzzle 696 -5)
				(= ticks 30)
			)
			(2
				(HandsOn)
				(gEgo use: 24 1) ; acorn
				(self dispose:)
			)
		)
	)
)

(instance mushScript of Script
	(properties)

	(method (doit)
		(if global279
			(SetFlag 327)
			(ClearFlag 286)
		)
		(if (and (IsFlag 286) (not (IsFlag 360)))
			(Palette palANIMATE 75 254 1)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(ClearFlag 328)
				(= cycles 1)
			)
			(1
				(gMessager say: 1 40 6 1 self 120) ; "You ingest a few of the mushrooms from the Fairy Ring. They taste delicious."
			)
			(2
				((= local0 (Sound new:)) number: 126 loop: -1 flags: -1 play:)
				(= cycles 180)
			)
			(3
				(gMessager say: 1 40 6 2 self 120) ; "Wow! Look at all the nice paisley horses!"
			)
			(4
				(= cycles 90)
			)
			(5
				(gMessager say: 1 40 5 3 self 120) ; "Your senses gradually return to normal."
			)
			(6
				(local0 fade:)
				(= cycles 90)
			)
			(7
				(local0 dispose:)
				(ClearFlag 286)
				(if (== gNight 1)
					(PalVary pvUNINIT)
				)
				(= cycles 1)
			)
			(8
				(gCurRoom drawPic: (gCurRoom picture:) 100)
				(if (== gNight 1)
					(PalVary pvINIT (gCurRoom picture:) 0)
				)
				(= cycles 1)
			)
			(9
				(if gAddToPics
					(gAddToPics doit:)
				)
				(if (IsFlag 327)
					(gEgo
						view: 536
						setLoop: 0
						setCel: 255
						posn: (gEgo x:) (+ (gEgo y:) 10)
					)
					(= ticks 5)
				else
					(gMessager say: 1 40 3 3 0 120) ; "Hmm, that was interesting. But it would probably not be a good idea to repeat the experience."
					(SetFlag 327)
					(HandsOn)
					(SetFlag 328)
					(self dispose:)
					(DisposeScript 120)
				)
			)
			(10
				(EgoDead 9 10 0 0 800) ; "That's funny. I could have sworn I warned you about eating too many Magic Mushrooms. Your mind permanently warped, you die a garishly polka-dotted death."
			)
		)
	)
)

(instance cueIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch local1
					(1
						(gEgo use: 1) ; rations
					)
					(2
						(gEgo use: 12) ; healingPotion
						(gEgo get: 11) ; flask
					)
					(3
						(gEgo use: 13) ; manaPotion
						(gEgo get: 11) ; flask
					)
					(4
						(gEgo use: 14) ; staminaPotion
						(gEgo get: 11) ; flask
					)
					(5
						(gEgo use: 15) ; disenchant
						(gEgo get: 11) ; flask
					)
					(6
						(gEgo use: 19) ; ghostOil
						(gEgo get: 11) ; flask
					)
					(7
						(gEgo use: 22 3) ; fruit
					)
					(8
						(gEgo use: 23 2) ; vegetables
					)
					(9
						(gEgo use: 29 1) ; flyingWater
						(gEgo get: 11 1) ; flask
					)
				)
				(self dispose:)
			)
		)
	)
)

