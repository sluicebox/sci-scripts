;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 120)
(include sci.sh)
(use Main)
(use Language)
(use Motion)
(use Game)
(use Menu)
(use Actor)
(use System)

(public
	rm120 0
)

(local
	heardSong
)

(procedure (ShadowPrint x y c f)
	(SaveSubLang)
	(Display &rest dsCOORD x y dsFONT f dsCOLOR c)
	(Display &rest dsCOORD (+ x 1) (+ y 1) dsFONT f dsCOLOR (- c 8))
	(RestoreSubLang)
)

(instance rm120 of Rm
	(properties
		picture 120
		style 3
	)

	(method (init)
		(HandsOff)
		(gGame setSpeed: 6)
		(SL disable:)
		(gTheMenuBar hide:)
		(SetFlag 3)
		(SetFlag 5)
		(SetFlag 4)
		(Load rsVIEW (LangSwitch 110 901))
		(Load rsVIEW 120)
		(Load rsSOUND 110)
		(Load rsSOUND 120)
		(Load rsFONT 9)
		(super init:)
		(gAddToPics add: atpLeg1 add: atpLeg2 add: atpLeg3 add: atpLeg4 doit:)
		(self setScript: RoomScript)
		(gEgo init: hide:)
	)
)

(instance RoomScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== -1 (gMusic prevSignal:)) (== state 7))
			(self cue:)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:))
			((and (== (event type:) evKEYBOARD) (== (event message:) KEY_F2))
				(TglSound)
			)
			(else
				(if (!= 120 (gMusic number:))
					(gMusic number: 120 loop: -1 play:)
				)
				(gCurRoom newRoom: 140)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(gMusic stop: number: 110 loop: 1 play:)
				(= cycles 16)
			)
			(2
				(aLogoDissolve
					view: (LangSwitch 110 901)
					setCel: 255
					setCycle: Beg self
					setPri: 10
					init:
				)
				(aLogo setPri: 8 init:)
			)
			(3
				(aLogoDissolve dispose:)
				(aLogo stopUpd:)
				(= cycles 16)
			)
			(4
				(aSierra init: setCycle: End self)
			)
			(5
				(aSierra stopUpd:)
				(= cycles 16)
			)
			(6
				(aPresents init: setCycle: End self)
			)
			(7
				(aPresents stopUpd:)
			)
			(8
				(= cycles 12)
			)
			(9
				(gMusic prevSignal: 0 stop: number: 120 loop: -1 play:)
				(aLogo dispose:)
				(aSierra dispose:)
				(aPresents dispose:)
				(gCurRoom drawPic: 120)
				(aThigh init:)
				(aCalf init:)
				(= cycles 2)
			)
			(10
				(ShadowPrint 128 30 9 9 120 0) ; "Leisure Suit Larry 3:"
				(= cycles 10)
			)
			(11
				(ShadowPrint (LangSwitch 146 141) 90 9 9 120 1) ; "Passionate Patti"
				(= cycles 10)
			)
			(12
				(ShadowPrint (LangSwitch 143 122) 110 9 9 120 2) ; "in Pursuit of the"
				(= cycles 10)
			)
			(13
				(ShadowPrint (LangSwitch 132 107) 130 9 9 120 3) ; "Pulsating Pectorals!"
				(= cycles 10)
			)
			(14
				(aThigh setCycle: Fwd)
				(aCalf setCycle: Fwd)
				(= cycles 16)
			)
			(15
				(gCurRoom newRoom: 130)
			)
		)
	)
)

(instance aSierra of Prop
	(properties
		x 234
		y 45
		priority 1
		cycleSpeed 1
	)

	(method (init)
		(= view (LangSwitch 110 901))
		(super init:)
	)
)

(instance aPresents of Prop
	(properties
		x 237
		y 146
		loop 1
		priority 10
		cycleSpeed 1
	)

	(method (init)
		(= view (LangSwitch 110 901))
		(super init:)
	)
)

(instance aLogo of Prop
	(properties
		x 236
		y 124
		loop 2
	)

	(method (init)
		(= view (LangSwitch 110 901))
		(super init:)
	)
)

(instance aLogoDissolve of Prop
	(properties
		x 236
		y 124
		loop 3
		cel 255
		cycleSpeed 3
	)
)

(instance aThigh of Prop
	(properties
		x 78
		y 66
		view 120
		priority 3
		cycleSpeed 1
	)
)

(instance aCalf of Prop
	(properties
		x 66
		y 149
		view 120
		loop 1
		priority 4
		cycleSpeed 1
	)
)

(instance atpLeg1 of PicView
	(properties
		x 37
		y 36
		view 120
		loop 2
		priority 3
	)
)

(instance atpLeg2 of PicView
	(properties
		x 26
		y 84
		view 120
		loop 2
		cel 1
		priority 3
	)
)

(instance atpLeg3 of PicView
	(properties
		x 18
		y 129
		view 120
		loop 2
		cel 2
		priority 3
	)
)

(instance atpLeg4 of PicView
	(properties
		x 25
		y 190
		view 120
		loop 2
		cel 3
		priority 3
	)
)

