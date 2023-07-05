;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 89)
(include sci.sh)
(use Main)
(use n001)
(use Talker)
(use fred)
(use Guard)
(use System)

(public
	nightPlazaGuard 0
	dayPlazaGuard 1
)

(local
	[guardNames 14] = [89 0 89 1 89 2 89 3 89 4 89 5 89 6]
	theMsg
	warnedEgo
)

(class PlazaGuard of PlazaWalker
	(properties
		walkingView 294
		stoppedView 295
		nameNum 0
		guardCode 0
	)

	(method (init)
		((= guardCode (GuardCode new:)) init: self 1)
		(super init:)
	)

	(method (respond event question)
		(if (not (guardCode respond: event question))
			(super respond: event question &rest)
		)
	)

	(method (messages)
		(super messages: &rest)
		(guardCode startTalking:)
	)

	(method (endTalk)
		(super endTalk:)
		(guardCode stopTalking:)
	)

	(method (showSelf)
		(Say self 83 [guardNames (+ (* nameNum 2) 1)])
	)

	(method (beOutOfRoom)
		(= nameNum (Random 0 6))
		(super beOutOfRoom:)
	)

	(method (atGen whatElement)
		(guardCode atGen: whatElement)
	)

	(method (atSpec whatElement)
		(guardCode atSpec: whatElement)
	)

	(method (dispose)
		(guardCode dispose:)
		(super dispose:)
	)
)

(instance dayPlazaGuard of PlazaGuard
	(properties)
)

(instance nightPlazaGuard of PlazaGuard
	(properties)

	(method (init)
		(= warnedEgo 0)
		(super init: &rest)
	)

	(method (beOutOfRoom)
		(super beOutOfRoom:)
		(= pwSeconds 30)
	)

	(method (doit &tmp [str 100])
		(super doit:)
		(if
			(and
				(not script)
				(< 1 pwState 6)
				(or
					(IsFlag 87)
					(IsFlag 88)
					(IsFlag 117)
					(and gPlazaDoorOpen (not (== gCurRoomNum 300))) ; rmSPlazaGates
				)
			)
			(cond
				(
					(and
						(IsFlag 87)
						(not (IsFlag 90))
						(not (IsFlag 88))
						(== ((gEgo script:) type:) 5)
					)
					(EgoDead 1 89 7 #title {Guards Hate Knife Throwers}) ; "Throwing knives when guards are around is not the wisest course of action."
				)
				((IsFlag 117)
					(EgoDead 1 89 8 #title {Blatant Thievery}) ; "By picking a lock you were choosing your fate."
				)
				(gPlazaDoorOpen
					(EgoDead 1 89 9 #title {Blatant Thievery}) ; "Next time you break into a shop, make sure there are no guards around."
				)
				((> (++ warnedEgo) 1)
					(EgoDead 1 89 10 #title {Nothing Magical about This}) ; "The guard says, "I warned you once!", as he hauls you off to the local pokey. Now play it again, Sam."
				)
				(else
					(self setScript: guardWarning)
				)
			)
		)
	)

	(method (handleEvent event)
		(if (Said 'tell//elemental<air,about')
			(Say self 89 11) ; "Is that what you are doing here? It is certainly not right to steal, but if you are just borrowing those bellows to save the city, I certainly will not stop you. I will talk to Issur in the morning and explain matters."
			(self leave:)
		else
			(super handleEvent: event)
		)
	)
)

(instance guardWarning of Script
	(properties)

	(method (changeState newState &tmp theScript)
		(switch (= state newState)
			(0
				(Say client self 89 12) ; "What are you doing there?"
				(cond
					((IsFlag 90)
						(= theMsg
							{Do you not know that practicing Magic is best done outside of the city?  Do not let me see you using magic around here again unless it is needed!}
						)
						(= theScript (ScriptID 62 1)) ; fallDown
					)
					((IsFlag 88)
						(= theMsg
							{The punishment for thievery in this city is to lose a hand.  Do not let me catch you trying to steal again!}
						)
						(= theScript (ScriptID 61 3)) ; ropeFall
					)
					(else
						(= theMsg
							{Do you not know that practicing Magic is best done outside of the city?  Do not let me see you using magic around here again unless it is needed!}
						)
						(= theScript 0)
					)
				)
				(gEgo setScript: theScript)
			)
			(1
				(= cycles 1)
			)
			(2
				(Say client self theMsg)
			)
			(3
				(= seconds 5)
			)
			(4
				(client leave:)
				(self dispose:)
			)
		)
	)
)

