;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 221)
(include sci.sh)
(use Main)
(use Skilled)
(use Motion)
(use System)

(public
	theMaster 0
)

(local
	local0
	local1
	local2
)

(procedure (localproc_0)
	(HighPrint 221 0) ; "Pity. I'm in the mood for some good combat practice."
)

(procedure (localproc_1)
	(cond
		((not [gEgoStats 6]) ; parry
			(HighPrint 221 1) ; "I am a skilled teacher as well as a skilled fighter."
			(HighPrint 221 2) ; "However, the combat style I teach relies on the subtle alternation of Strike and Parry. As I observe that you have no skill in the use of Parry, you would receive no benefit from my lessons."
		)
		((IsFlag 321)
			(localproc_2)
		)
		(else
			(SetFlag 321)
			(HighPrint 221 1) ; "I am a skilled teacher as well as a skilled fighter."
			(HighPrint 221 3) ; "For a mere gold coin, I will be glad to give you some practice and some pointers on how to better your skills."
			(HighPrint 221 4) ; "Will you pay for a lesson?"
			(= global114 100)
			(= local2 1)
		)
	)
)

(procedure (localproc_2)
	(= local2 0)
	(if (Purchase 10)
		(HighPrint 221 5) ; "You pay the Weapon Master's price and then..."
		(= global267 gDay)
		(SolvePuzzle 607 3 0)
		((ScriptID 39 0) setScript: (ScriptID 222 2)) ; rm39, startFight
	else
		(HighPrint 221 6) ; "That's easy to say, but you don't HAVE a gold coin. You make your apologies to the Weapon Master."
		(localproc_0)
	)
)

(class WeaponMaster of Skilled
	(properties
		strength 65
		intell 60
		agil 75
		vit 50
		luck 60
		weap 80
		parry 80
		dodge 70
		armorValue 3
		shieldValue 10
		weapValue 5
		warriorX 187
		warriorY 150
		endFight 0
	)

	(method (getHit)
		(if fightLeft
			(self x: (+ (self x:) 3))
			((self opponent:) x: (+ ((self opponent:) x:) 3))
		else
			(self x: (- (self x:) 3))
			((self opponent:) x: (- ((self opponent:) x:) 3))
		)
	)

	(method (gotBeat param1)
		(self endFight: 1)
		(self setScript: param1)
	)
)

(instance theMaster of WeaponMaster
	(properties
		view 639
	)

	(method (doit)
		(cond
			((> global114 1)
				(-- global114)
			)
			((== global114 1)
				(= global114 0)
				(= local2 0)
				(localproc_0)
			)
		)
		(cond
			(
				(and
					(< (gEgo distanceTo: (ScriptID 221 0)) 40) ; theMaster
					(not local0)
					(not (IsFlag 304))
				)
				(= local0 1)
			)
			(
				(and
					(not (< (gEgo distanceTo: (ScriptID 221 0)) 40)) ; theMaster
					local0
					(not (IsFlag 304))
				)
				(= local0 0)
			)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evSAID
				(cond
					(script
						(event claimed: 0)
					)
					((super handleEvent: event))
					((> global114 1)
						(cond
							((Said 'yes,please')
								(= global114 0)
								(if local2
									(localproc_2)
								else
									(localproc_1)
								)
							)
							((Said 'pay')
								(= global114 0)
								(if local2
									(localproc_2)
								else
									(localproc_1)
								)
							)
							((Said 'no')
								(= global114 0)
								(if local2
									(= local2 0)
								)
								(localproc_0)
							)
							(else
								(event claimed: 1)
								(HighPrint 221 7) ; "Do not ramble, my friend"
								(if local2
									(HighPrint 221 8) ; "Will you pay?"
									(= global114 80)
								else
									(HighPrint 221 9) ; "Will you fight?"
									(= global114 80)
								)
							)
						)
					)
					((Said 'pay')
						(= global114 0)
						(= local2 0)
						(if [gEgoStats 6] ; parry
							(localproc_2)
						else
							(HighPrint 221 10) ; "I'm sorry. Since you have no skill in parrying blows, you would receive no benefit from my instruction."
						)
					)
					((Said 'look>')
						(cond
							((Said '/man,master[<weapon]')
								(HighPrint 221 11) ; "The man has the muscles of a trained athlete and is apparently quite skilled with the sword."
							)
							((Said '/blade')
								(HighPrint 221 12) ; "The weapon master carries a blunted practice sword, in the belief that students retain more of their learning if they survive the practice sessions."
							)
						)
					)
					((Said 'talk/man,swordsman,master')
						(if (not local0)
							(gEgo setScript: comeBackLittleEgo)
						else
							(HighPrint 221 13) ; "Please don't bore me, young adventurer. Ask me about something interesting to me."
						)
					)
					((Said 'talk,ask>')
						(if (not local0)
							(gEgo setScript: comeBackLittleEgo)
							(event claimed: 1)
						else
							(= local1 1)
						)
						(cond
							(
								(Said
									'//fight,art,skill,strength,strength,agility'
								)
								(HighPrint 221 14) ; "Fighting is both an art and a skill."
								(HighPrint 221 15) ; "It is a skill in the use of the muscle strength and agility's control."
								(HighPrint 221 16) ; "It is an art in the out-witting and out-maneuvering of the opponent."
								(HighPrint 221 17) ; "I am, of course, a most skilled artist."
								(if [gEgoStats 6] ; parry
									(HighPrint 221 18) ; "Do you fight?"
									(= global114 100)
								else
									(HighPrint 221 19) ; "If you were a swordsman skilled in both attack and parry, we could have had a practice bout."
								)
							)
							((Said '//blade,weapon')
								(HighPrint 221 20) ; "The sword is the finest of all weapons. It requires an equal measure of skill and strength."
							)
							((Said '//name,man,master')
								(HighPrint 221 21) ; "I am the Weapon Master."
							)
							((Said '//guard')
								(HighPrint 221 22) ; "You will find them very skilled at fighting. After all, I am the one who trains all of the guards at this castle."
							)
							((Said '//baron')
								(HighPrint 221 23) ; "The Baron had the wisdom to recognize greatness when I presented myself. Thus he made me Weapon Master."
							)
							((Said '//barnard')
								(HighPrint 221 24) ; "The Baronet had some minor talent with weapons, but he was too impatient. If he had but listened and learned what I teach, he would never have been lost."
							)
							((Said '//shield,armor')
								(HighPrint 221 25) ; "I never use a shield or armor under most circumstances. It only gets in the way of my agility and dodging ability. It is best used by those who are strong, but not swift or agile."
							)
							((Said '//teach,learn,lesson,practice')
								(HighPrint 221 26) ; "Practice is the way to refine and improve one's skills."
								(localproc_1)
							)
							(else
								(= local1 0)
								(event claimed: 1)
								(if (not (gEgo script:))
									(HighPrint 221 13) ; "Please don't bore me, young adventurer. Ask me about something interesting to me."
								)
							)
						)
						(if (and local1 (event claimed:))
							(SolvePuzzle 661 1)
						)
					)
					((or (Said 'practice,fight,learn') (Said 'buy,get/lesson'))
						(localproc_1)
					)
				)
			)
		)
	)
)

(instance comeBackLittleEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(HighPrint 221 27) ; "If you are addressing me, sir, you must respect me enough to address me to my face!"
				(if (< (gEgo x:) ((ScriptID 221 0) x:)) ; theMaster
					(theMaster loop: 5)
				else
					(theMaster loop: 4)
				)
				(gEgo
					ignoreActors:
					setMotion:
						MoveTo
						(if (< (gEgo x:) ((ScriptID 221 0) x:)) ; theMaster
							(- (theMaster x:) 35)
						else
							(+ (theMaster x:) 35)
						)
						(theMaster y:)
						self
				)
			)
			(1
				(LookAt gEgo theMaster)
				(= local0 1)
				(gEgo ignoreActors: 0)
				(client setScript: 0)
				(HandsOn)
			)
		)
	)
)

