;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32)
(include sci.sh)
(use Main)
(use Interface)
(use Save)
(use Game)
(use User)
(use Menu)
(use Actor)
(use System)

(public
	Rm32 0
)

(local
	local0
	[local1 11]
	[local12 11] = [0 47 63 85 179 264 274 239 206 131 107]
	[local23 11] = [0 157 110 56 46 66 129 168 107 86 149]
	local34
	local35
	local36
	local37
	[local38 25]
)

(procedure (localproc_0 &tmp temp0)
	(for ((= temp0 1)) (< temp0 11) ((++ temp0))
		((= [local1 temp0] (PV new:))
			view: 132
			loop: (- temp0 1)
			x: [local12 temp0]
			y: [local23 temp0]
		)
		(gAddToPics add: [local1 temp0])
	)
)

(procedure (localproc_1)
	(FlowerName loop: (- local35 1) posn: [local12 local35] [local23 local35])
)

(procedure (localproc_2)
	(= local0 1)
	(if (== local34 local35)
		(clr)
		(switch (++ local36)
			(0 0)
			(1
				(doRiddles changeState: 2)
			)
			(2
				(doRiddles changeState: 5)
			)
			(3
				(doRiddles changeState: 8)
			)
		)
	else
		(HandsOff)
		(doRiddles changeState: 11)
	)
	(= local37 0)
)

(procedure (localproc_3)
	(countDown init:)
	(gTObj noWidth: 1)
	(switch local34
		(1
			(Talk 32 6) ; "When light is dim and courage fails, When heart against adversity rails, When it seems you will never see the dawn, This alone can drive you on."
		)
		(2
			(Talk 32 7) ; "If a dream is abandoned, Or a purpose dies, These are left with the dregs Of bitterness and sighs."
		)
		(3
			(Talk 32 8) ; "It can be sweet on the tongue, Or vile as a curse, To hear it is evil, To believe it is worse."
		)
		(4
			(Talk 32 9) ; "In time of grief, It gives relief, It can lessen fears, Ease the pain of tears."
		)
		(5
			(Talk 32 10) ; "Oh, it is splendid, It has no peer, It scorns the lesser, And holds itself dear."
		)
		(6
			(Talk 32 11) ; "Known to the priest And nun, Who natural pleasures Do shun."
		)
		(7
			(Talk 32 12) ; "Surrounded by giants, Your worries were few, Wonders abounded, The world was new."
		)
		(8
			(Talk 32 13) ; "Wise are they who seek it, Fools are they who believe without it, Scorn those who claim To own it."
		)
		(9
			(Talk 32 14) ; "It alleviates all pain and sorrows, The final end of all tomorrows, That to which we all must go, Rich or poor, high or low."
		)
		(10
			(Talk 32 15) ; "For its sweet sake, You suffer in silence, What we both most desire, But will never possess."
		)
	)
	(= local37 1)
)

(instance riddleWindow of SysWindow
	(properties
		color 15
		back 1
		priority 15
		title {Ice Maiden}
		brLeft 115
		brBottom 300
		brRight 315
	)
)

(instance Flower of View ; UNUSED
	(properties
		view 132
	)
)

(instance FlowerName of View
	(properties
		view 132
	)
)

(instance Rm32 of Rm
	(properties
		picture 32
		style 8
	)

	(method (init)
		(Load rsVIEW 132)
		(super init:)
		(proc0_13 33)
		(gEgo init: posn: 500 500 hide:)
		(User canInput: 0 canControl: 1)
		(MenuBar state: 0)
		(gTObj tWindow: riddleWindow init:)
		(localproc_0)
		(gAddToPics doit:)
		(= local35 (Random 1 10))
		(FlowerName setCel: 1 init:)
		(localproc_1)
		(countDown init:)
		(self setScript: doRiddles)
	)

	(method (doit)
		(super doit:)
		(countDown doit:)
	)

	(method (handleEvent event &tmp temp0)
		(if (or local0 (event claimed:))
			(return)
		)
		(switch (event type:)
			(evMOUSEBUTTON
				(gTObj endTalk:)
				(countDown init:)
				(event claimed: 1)
				(for ((= temp0 1)) (< temp0 12) ((++ temp0))
					(if
						(OnButton
							event
							(- [local12 temp0] 10)
							(- [local23 temp0] 50)
							(+ [local12 temp0] 10)
							[local23 temp0]
						)
						(if (== local35 temp0)
							(localproc_2)
						else
							(= local35 temp0)
							(localproc_1)
						)
						(break)
					)
				)
			)
			(evKEYBOARD
				(countDown init:)
				(cond
					((== (event message:) KEY_RETURN)
						(cond
							(gModelessDialog
								(event claimed: 0)
							)
							(local37
								(localproc_2)
							)
							(else
								(event claimed: 0)
							)
						)
						(gTObj endTalk:)
					)
					((== (event message:) KEY_F1)
						(Print 32 0 #window SysWindow #title {Help}) ; "Use cursor keys or mouse to choose a flower. Press "Enter" or mouse button to answer riddle with the flower you've chosen."
					)
					((== (event message:) KEY_F6)
						(localproc_3)
					)
					(else
						(event claimed: 1)
					)
				)
			)
			($0040 ; direction
				(gTObj endTalk:)
				(countDown init:)
				(event claimed: 1)
				(switch (event message:)
					(JOY_UP
						(switch local35
							(1
								(= local35 2)
							)
							(2
								(= local35 3)
							)
							(6
								(= local35 5)
							)
							(7
								(= local35 8)
							)
							(8
								(= local35 4)
							)
							(9
								(= local35 4)
							)
							(10
								(= local35 9)
							)
						)
						(localproc_1)
					)
					(JOY_RIGHT
						(switch local35
							(1
								(= local35 10)
							)
							(2
								(= local35 9)
							)
							(3
								(= local35 9)
							)
							(4
								(= local35 5)
							)
							(8
								(= local35 6)
							)
							(9
								(= local35 4)
							)
							(10
								(= local35 7)
							)
						)
						(localproc_1)
					)
					(JOY_DOWN
						(switch local35
							(2
								(= local35 1)
							)
							(3
								(= local35 2)
							)
							(4
								(= local35 8)
							)
							(5
								(= local35 6)
							)
							(6
								(= local35 7)
							)
							(8
								(= local35 7)
							)
							(9
								(= local35 10)
							)
						)
						(localproc_1)
					)
					(JOY_LEFT
						(switch local35
							(4
								(= local35 9)
							)
							(5
								(= local35 4)
							)
							(6
								(= local35 8)
							)
							(7
								(= local35 10)
							)
							(8
								(= local35 9)
							)
							(9
								(= local35 2)
							)
							(10
								(= local35 1)
							)
						)
						(localproc_1)
					)
					(else
						(localproc_1)
					)
				)
			)
		)
	)
)

(instance countDown of Script
	(properties)

	(method (init)
		(super init:)
		(= seconds 30)
	)

	(method (cue)
		(localproc_3)
		(= seconds 30)
	)
)

(instance doRiddles of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gTObj noWidth: 1 talkCue: self)
				(Talk 32 1) ; "Here is the first riddle. Remember, you must choose the flower that best answers it."
			)
			(1
				(Display (Format @local38 32 2) dsCOORD 30 173 dsCOLOR 0 dsBACKGROUND 9 dsFONT 4) ; "Press F6 to see riddle again"
				(= local34 (Random 1 4))
				(localproc_3)
				(= local0 0)
			)
			(2
				(= cycles 5)
			)
			(3
				(gTObj noWidth: 1 talkCue: self)
				(Talk 32 3) ; "Your wisdom is great. Here is the next riddle."
			)
			(4
				(= local34 (Random 5 7))
				(localproc_3)
				(= local0 0)
			)
			(5
				(= cycles 5)
			)
			(6
				(gTObj noWidth: 1 talkCue: self)
				(Talk 32 3) ; "Your wisdom is great. Here is the next riddle."
			)
			(7
				(= local34 (Random 8 10))
				(localproc_3)
				(= local0 0)
			)
			(8
				(= cycles 5)
			)
			(9
				(gTObj noWidth: 1 talkCue: self)
				(Talk 32 4) ; "Truly you are worthy to be king. The test is ended. Launcelot shall go free."
			)
			(10
				(SetFlag 67)
				(gCurRoom newRoom: 31)
			)
			(11
				(= cycles 5)
			)
			(12
				(gTObj noWidth: 1 talkCue: self)
				(Talk 32 5) ; "You have failed. The price must be paid."
			)
			(13
				(gCurRoom newRoom: 31)
			)
		)
	)
)

