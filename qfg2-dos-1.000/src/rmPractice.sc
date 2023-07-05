;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 170)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use TopWindow)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rmPractice 0
	printResponses 1
)

(local
	presentLoop
	lastLoop
	dodgeNum
	uhuraHits
	noDodge
	msgCount
	newCount = 3
	fightLast
	longString
	[unusedBuffer1 399]
	whichNotify
	fightPresent
	fighter
	whoToFight
	yourOpponent
	string
	[unusedBuffer2 249]
)

(instance rmPractice of Rm
	(properties
		picture 170
		style 17
	)

	(method (init)
		(super init: &rest)
		(if (== gDay 16)
			(SolvePuzzle 662 5 0)
			(= yourOpponent 1)
			(= whoToFight (ScriptID 175 0)) ; rakeesh
			(= fighter {Rakeesh:})
			(InitAddToPics uhura1)
			(TopWindow color: 14 back: 0)
		else
			(SolvePuzzle 663 5 0)
			(= yourOpponent 0)
			(= whoToFight (ScriptID 171 0)) ; uhura
			(= fighter {Uhura:})
			(if (not (== gDay 3))
				(simba init:)
			)
			(TopWindow color: 0 back: 11)
		)
		(self setScript: printResponses)
		(SetFlag 159)
		(whoToFight barMessage: 0 opponent: (ScriptID 32 0) initCombat:) ; warrior
		((ScriptID 32 0) ; warrior
			barMessage: 0
			posn: 142 142
			setPri: 10
			opponent: whoToFight
			initCombat:
		)
		(= gSpellChecker rm170Check)
	)

	(method (notify which &tmp retVal event whichMessage)
		(= retVal 1)
		(= whichNotify which)
		(HandsOff)
		(while ((= event (Event new:)) type:)
			(event dispose:)
		)
		(event dispose:)
		(if (gCurRoom script:)
			((gCurRoom script:) dispose:)
		)
		(if (== gDay 16)
			(= longString
				{You are good, very good.  Soon you will be a master with your sword.  However, the real battle is not always won by a swing or a thrust.  To fight with Honor is not always easy.  Sometimes the Way of Honor will seem foolish to those that have none.  Nevertheless, without Honor, there is no victory.  With Honor, there is no real defeat.}
			)
		else
			(switch which
				(59
					(HighPrint 170 0) ; "You lower your weapon and yield the combat."
				)
				(60
					(if (< dodgeNum uhuraHits)
						(= longString
							(switch gGuildCount2
								(0 {You need to defend better.  You hit pretty often, but you get hit too often.})
								(1 {Don't get into combat with Scorpion until you dodge better.})
								(2 {You getting much better, but you still be not defending enough.})
								(else
									{Do not let me touch you with my spear the next time.  I will be plenty mad if some monster tears you to shreds because you do not dodge enough.}
									(= gGuildCount2 0)
								)
							)
						)
					else
						(= longString
							(switch gGuildCount2
								(0 {Enough for now.  You look pretty winded.  We go back to Hall.})
								(1 {You got a good swing.  My shield arm is sore.})
								(2 {That time, we both got workout.  Pretty soon, I be needing rest.})
								(else
									{You be getting past my shield many times now.  You be getting good.}
									(= gGuildCount2 0)
								)
							)
						)
					)
					(= [gEgoStats 17] 10) ; stamina
				)
				(57
					(= longString
						(switch gGuildCount2
							(0 {Brigands in the desert better watch out for you.  They be in big trouble.})
							(1 {The TerrorSaurus who tries to eat you will be dead meat first.})
							(2 {You can take on a pack of Jackalmen now.})
							(3 {The Ghoulyman who tries to get you now will be sorry.})
							(4 {That be enough for now.  Soon you be giving me lessons.})
							(5 {Either I be out of shape from Simba or you be getting too good for me plenty soon.})
							(else
								{You very fast learner.  I think maybe you be plenty tough enough now.}
								(= gGuildCount2 0)
							)
						)
					)
				)
				(58
					(= longString
						{That be enough for today.  Soon you be giving me lessons.}
					)
				)
				(else
					(= retVal 0)
				)
			)
		)
		(++ gGuildCount2)
		(whoToFight health: 0 endCombat: setScript: monsterToNormal)
		((ScriptID 32 0) endCombat: setScript: returnToNormal) ; warrior
		(return retVal)
	)
)

(instance simba of Prop
	(properties
		x 104
		y 91
		view 168
		loop 11
		signal 1
	)
)

(instance uhura1 of View
	(properties
		x 104
		y 91
		view 162
		loop 4
		signal 1
	)
)

(instance printResponses of Script
	(properties)

	(method (init)
		(super init: &rest)
		(= noDodge 1)
		(= dodgeNum (= uhuraHits 0))
		(= presentLoop (= lastLoop ((ScriptID 32 0) loop:))) ; warrior
		(= fightPresent (= fightLast (whoToFight loop:)))
	)

	(method (doit)
		(super doit:)
		(= presentLoop ((ScriptID 32 0) loop:)) ; warrior
		(= fightPresent (whoToFight loop:))
		(if (>= msgCount newCount)
			(= msgCount 0)
			(= newCount (Random 3 5))
			(= noDodge
				(cond
					((and noDodge (>= dodgeNum 2)) 0)
					((and (not noDodge) (< dodgeNum uhuraHits)) 1)
				)
			)
			(self cue:)
		)
		(if (!= presentLoop lastLoop)
			(cond
				((== ((ScriptID 32 0) loop:) 1) ; warrior
					(++ uhuraHits)
					(++ msgCount)
				)
				((OneOf ((ScriptID 32 0) loop:) 9 10 11) ; warrior
					(++ dodgeNum)
				)
			)
			(= lastLoop presentLoop)
		)
		(if (!= fightPresent fightLast)
			(if (== (whoToFight loop:) 1)
				(++ msgCount)
				(if (< (-- uhuraHits) 0)
					(= uhuraHits 0)
				)
			)
			(= fightLast fightPresent)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0 0)
			(1
				(if (== gDay 16)
					(if (>= (++ gGuildCount1) 2)
						(= gGuildCount1 0)
					)
					(self changeState: 3)
				else
					(if (>= (++ gGuildCount1) 9)
						(= gGuildCount1 0)
					)
					(self changeState: 2)
				)
			)
			(2
				(= state 0)
				(if
					(= string
						(if noDodge
							(= noDodge 0)
							(cond
								((OneOf gGuildCount1 0 6) {Block my spear or get out of the way.  If it be scorpion's tail, you be dead.})
								((OneOf gGuildCount1 1 7) {Dodge!  Don't take damage, get out of the way.})
								((OneOf gGuildCount1 2 8) {Move out of the way more.  You got feet, use them.})
								((OneOf gGuildCount1 3 9) {Don't rely on your weapon to save you. Use your body to avoid damage.})
								((== gGuildCount1 4) {You let me get you with spear way too often.  If I be ghoul, you be plenty cold right now.})
								((== gGuildCount1 5) {Never stand still.  Moving target harder to hit.})
							)
						else
							(switch gGuildCount1
								(0 {TerrorSaurus is stupid but strong.  Takes a while before it knows it is dead.})
								(1 {Watch my actions.  Move before I do.})
								(2 {Swing high, swing low.  Keep enemy guessing where your weapon will be.})
								(3 {Don't watch my weapon, watch my eyes.  Let them show you where I will hit and when.})
								(4 {Put your body into your thrusts.})
								(5 {Brigands don't defend well.  Keep up your attacks.})
								(6 {If I be Griffin, swing high.  If I be Ghoul, swing low.  Use best attack for monster.})
								(7 {Scorpion always wiggles tail before it strikes.  Be ready to dodge.})
								(8 {Jackalmen may be cowards, but they do fight well.  Keep sword on one at a time.  Take it out as fast as possible.})
								(9
									(if (gEgo has: 7) ; Shield
										{Keep your shield held higher.  Easier to block spears and swords with it there.}
									else
										{TerrorSaurus is stupid but strong.  Takes a while before it knows it is dead.}
									)
								)
							)
						)
					)
					(HighPrint string 80 fighter 35 TopWindow)
				)
			)
			(3
				(= state 0)
				(if
					(= string
						(switch gGuildCount1
							(0 {When fighting against a sword, do not let a swing catch you off guard.  You can be disarmed that way.})
							(1 {Do not let yourself be distracted by thoughts.  Let yourself be one with your weapon.})
							(2 {Let your motion flow smoothly as you dodge.  Always remain in balance.})
						)
					)
					(HighPrint string 80 fighter 35 TopWindow)
				)
			)
		)
	)
)

(instance monsterToNormal of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(whoToFight setCycle: Beg self)
				(if (and (gCast contains: simba) (>= gHowFast 2))
					(simba cycleSpeed: 1 setCycle: Fwd)
				)
			)
			(1
				(whoToFight action: 0 setLoop: 0)
			)
		)
	)
)

(instance returnToNormal of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(if
			(and
				(== (whoToFight script:) monsterToNormal)
				(>= (monsterToNormal state:) 1)
				(== (self state:) 2)
			)
			(monsterToNormal dispose:)
			(= cycles 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client
					action: 0
					setCycle:
						(if (== ((ScriptID 32 0) loop:) 1) End else Beg) ; warrior
						self
				)
			)
			(1
				(client
					view: (if (== (client view:) 80) 83 else 84)
					setLoop: -1
					loop: 0
					cel: (if (== (client view:) 80) 4 else 3)
					cycleSpeed: 1
					setCycle: Beg self
				)
			)
			(2 0)
			(3
				(if (and longString (!= whichNotify 59))
					(HighPrint longString 80 fighter 35 TopWindow 103 self)
				else
					(= cycles 1)
				)
			)
			(4
				(= seconds 2)
			)
			(5
				(gCurRoom newRoom: 160)
			)
		)
	)
)

(instance rm170Check of Code
	(properties)

	(method (doit)
		(if (not yourOpponent)
			(HighPrint 170 1 80 fighter 35 TopWindow) ; "You not be remembering rules of practice combat. Come back when you ready to fight fair."
			(SkillUsed 14 -50) ; honor
		else
			(HighPrint 170 2 80 fighter 35 TopWindow) ; "A combat fought without honor brings no honor onto the combatant. Perhaps we shall practice again when you have learned the meaning of honor."
			(SkillUsed 14 -100) ; honor
		)
		(gCurRoom newRoom: 160)
		(return 0)
	)
)

