;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 105)
(include sci.sh)
(use Main)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm105 0
)

(local
	local0
	[local1 3]
	local4
	[local5 2]
)

(procedure (localproc_0 &tmp temp0)
	(repeat
		(= temp0 (Event new: evMOUSEKEYBOARD))
		(breakif (temp0 type:))
		(temp0 dispose:)
	)
	(temp0 dispose:)
)

(instance rm105 of Rm
	(properties
		picture 104
		style 7
	)

	(method (init)
		(Load rsVIEW 266)
		(HandsOff)
		(= local0 32)
		(super init:)
		(self setScript: rm105Script)
	)
)

(instance rm105Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(switch global126
					(0
						(self changeState: 2)
					)
					(1
						(self changeState: 4)
					)
					(2
						(self changeState: 5)
					)
					(3
						(self changeState: 6)
					)
					(4
						(self changeState: 7)
					)
					(5
						(self changeState: 8)
					)
				)
			)
			(2
				(Display 105 0 dsFONT 1 dsWIDTH 300 dsCOORD 45 63 dsCOLOR 15) ; "You go home and spend a boring and restless evening as you contemplate the events of the day. Eventually you drift off to sleep, wondering why you never called Marie for a date."
				(localproc_0)
				(self changeState: 9)
			)
			(4
				(Display 105 1 dsFONT 1 dsWIDTH 300 dsCOORD 14 43 dsCOLOR 15) ; "Since you were not in the mood, you've let a nice, romantic evening with Marie slip through your fingers. She left the restaurant more than a little upset, and you wonder how you're going to talk your way out of this one!                          Meanwhile, you must get back to the task at hand."
				((= local4 (Prop new:))
					view: 285
					loop: 0
					cel: 0
					posn: 255 175
					setPri: -1
					init:
					setCycle: Fwd
					startUpd:
				)
				(localproc_0)
				(local4 hide:)
				(self changeState: 9)
			)
			(5
				(if (> global107 local0)
					(-= global107 local0)
					(SetScore 2)
					(Display 105 2 dsFONT 1 dsWIDTH 300 dsCOORD 14 43 dsCOLOR 15) ; "Although the meal was nice, and you had great fun with Marie, you must get back to the task at hand. You pay the waiter for your meal, leave him a generous tip, and see Marie home to her house."
				else
					(Display 105 3 dsFONT 1 dsWIDTH 300 dsCOORD 14 43 dsCOLOR 15) ; "Uh-oh! It seems you've spent too much of your ready cash. Even worse than that, you're overextended on your credit cards.   Embarrassed, because you're broke, you ask the waiter if he has any dishes to wash.   Marie sits at the table, embarrassed, while you wash, dry, and think about the case you're working on."
				)
				(localproc_0)
				(self changeState: 9)
			)
			(6
				(Display 105 4 dsFONT 1 dsWIDTH 300 dsCOORD 30 63 dsCOLOR 15) ; "The meal was great, you had a lot of fun with Marie, but you must get back to the task at hand. You see Marie home."
				(localproc_0)
				(self changeState: 9)
			)
			(7
				(if (> global107 local0)
					(-= global107 local0)
					(SetScore 2)
					(Display 105 5 dsFONT 1 dsWIDTH 300 dsCOORD 14 43 dsCOLOR 15) ; "The meal is barely noticed as you and Marie take advantage of the precious moment. You see her home, and the rest is history.....!"
				else
					(Display 105 3 dsFONT 1 dsWIDTH 300 dsCOORD 14 43 dsCOLOR 15) ; "Uh-oh! It seems you've spent too much of your ready cash. Even worse than that, you're overextended on your credit cards.   Embarrassed, because you're broke, you ask the waiter if he has any dishes to wash.   Marie sits at the table, embarrassed, while you wash, dry, and think about the case you're working on."
				)
				(localproc_0)
				(self changeState: 9)
			)
			(8
				(Display 105 6 dsFONT 1 dsWIDTH 300 dsCOORD 14 43 dsCOLOR 15) ; "Well, Sonny Bonds! No one will ever know why you walked out on your girl at Arnie's Restaurant, but you must know how badly you hurt Marie's feelings. You will have to deal with your guilt as you work on the task at hand."
				(localproc_0)
				(self changeState: 9)
			)
			(9
				(gCurRoom drawPic: 104 7)
				(= cycles 1)
			)
			(10
				(Display 105 7 dsFONT 0 dsWIDTH 150 dsCOORD 114 95 dsCOLOR 15) ; "The next day...."
				(DrawCel 999 0 0 138 128 15)
				(= cycles 1)
			)
			(11
				(= global138 0)
				(= global100 8)
				(= global158 600)
				(= global131 33)
				(= global130 105)
				(= global160 0)
				(HandsOn)
				(gCurRoom newRoom: 1)
			)
		)
	)
)

