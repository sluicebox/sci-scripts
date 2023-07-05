;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 811)
(include sci.sh)
(use Main)
(use n007)
(use Motion)
(use Game)
(use System)

(public
	Street 0
)

(local
	local0
	local1
)

(instance Street of Locale
	(properties)

	(method (init)
		(if
			(and
				(not gNight)
				(or (!= (gContMusic number:) 93) (== (gContMusic state:) 0))
			)
			(gContMusic priority: 0 number: 93 loop: -1 play:)
		)
		(super init: &rest)
	)

	(method (handleEvent event &tmp [temp0 3] temp3 temp4 temp5)
		(cond
			((super handleEvent: event))
			((!= (event type:) evSAID))
			((and (not gNight) (Said 'japaneserestorsleep>')))
			(
				(or
					(Said 'nap,nap')
					(Said 'go[<to]/nap,nap')
					(Said 'get,get,get/nap,nap')
				)
				(cond
					((< 700 gClock 2550)
						(HighPrint 811 0) ; "You're too awake to sleep now."
					)
					((!= (gEgo onControl: 1) 1)
						(HighPrint 811 1) ; "This doesn't look like a good place to curl up."
					)
					((== gCurRoomNum 334)
						(EgoSleeps 5 0)
					)
					(else
						(gEgo setScript: egoSleepsInStreet)
					)
				)
			)
			((Said 'look,look/door')
				(HighPrint 811 2) ; "Yep, that's a door, all right."
			)
			((Said '/window')
				(HighPrint 811 3) ; "The shades are drawn."
			)
			((Said 'open,open,open/window')
				(HighPrint 811 4) ; "The windows appear to be locked.  You certainly don't want to break them and attract attention."
			)
			((Said 'unlock,pick,lockpick/door,hasp,hasp,lock')
				(= temp5 (gEgo onControl: 1))
				(cond
					((not gNight)
						(HighPrint 811 5) ; "In broad daylight? You've got to be kidding! You'd be arrested for certain."
					)
					((not [gEgoStats 9]) ; pick locks
						(HighPrint 811 6) ; "You don't know how to pick locks."
					)
					((not (CanPickLocks))
						(HighPrint 811 7) ; "You can't pick a lock without a lockpick."
					)
					((== temp5 16384)
						(gCurRoom notify: 1)
					)
					((or (== temp5 4096) (== temp5 1024) (== temp5 8192))
						(if (<= (Random 3 10) (++ local0))
							(EgoDead ; "Uh oh. You made too much noise. The Sheriff and Otto arrive on the scene and arrest you for "criminal carelessness". Work a little faster next time!"
								811
								8
								80
								{ Nobody said this job was easy. %j\ba\c9\bc\ba\de\c4\b6\de \d4\bb\bc\b2\c5\dd\c3 \c0\de\da\d3 \b2\dc\c5\b6\af\c0\be\de}
								82
								503
								1
								0
							)
						else
							(TrySkill 9 0 0) ; pick locks
							(HighPrint 811 9) ; "The door is securely barred from the inside, but you do get some practice."
						)
					)
					(else
						(HighPrint 811 10) ; "You're not near a door."
					)
				)
			)
			((Said 'japaneseclimbup,climb,climb')
				(cond
					((not [gEgoStats 11]) ; climbing
						(HighPrint 811 11) ; "Leave the climbing to those who know how."
					)
					((and (not gNight) (!= gCurRoomNum 333))
						(HighPrint 811 12) ; "The town gate's open. There's no need to climb over. Besides, you'd make people nervous."
					)
					((<= (Random 3 10) (++ local1))
						(HighPrint 811 13) ; "You'd better not try to climb the wall any more right now. You've been at this long enough that someone is likely to notice."
						(= local1 10)
					)
					((TrySkill 11 35 0) ; climbing
						(switch gCurRoomNum
							(300
								(= temp3 (if (> (gEgo x:) 130) 65 else 73))
							)
							(310
								(= temp3 73)
							)
							(320
								(= temp3 65)
							)
							(333
								(= temp3 53)
							)
							(334
								(= temp3 53)
							)
							(else
								(HighPrint 811 14) ; "There's no good place to climb the wall here."
								(= temp3 0)
							)
						)
						(if temp3
							(HighPrint 811 15) ; "You climb over the town wall."
							(gCurRoom newRoom: temp3)
						)
					)
					(else
						(HighPrint 811 16) ; "The wall is too smooth to climb with your level of skill, but keep practicing."
					)
				)
			)
			((Said 'look,look>')
				(cond
					((or (Said '<down') (Said '/ground'))
						(HighPrint 811 17) ; "There is an absence of the usual litter associated with town streets. This hamlet is kept very clean."
					)
					((or (Said '/sky') (Said '<up'))
						(if gNight
							(HighPrint 811 18) ; "The evening is clear and the stars are bright. Dark clouds pass over the moon."
						else
							(HighPrint 811 19) ; "The sky is a piercing blue with scudding white clouds."
						)
					)
					((Said '/wall')
						(HighPrint 811 20) ; "The town wall is made of the same rock as the surrounding mountains.It appears to be very sturdy."
					)
					((Said '/roof')
						(HighPrint 811 21) ; "It keeps the occupants of the building dry when it rains."
					)
					((Said '/hill')
						(HighPrint 811 22) ; "If you look past the town wall, you can see the mountains through which you journeyed to arrive here."
					)
				)
			)
		)
	)
)

(instance egoSleepsInStreet of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(HighPrint 811 23) ; "You curl up on the hard ground and try to get some rest."
				(gEgo view: 515 setLoop: 3 cel: 0 setCycle: End self)
			)
			(1
				(EgoSleeps 5 0)
				(= seconds 5)
			)
			(2
				(= temp0 gCurRoomNum)
				(= gCurRoomNum 999)
				(gCurRoom newRoom: temp0)
			)
		)
	)
)

