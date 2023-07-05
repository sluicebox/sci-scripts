;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 331)
(include sci.sh)
(use Main)
(use n013)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm331 0
)

(instance rm331 of Room
	(properties
		modNum 330
		picture 99
		style 14
		exitStyle 13
	)

	(method (init)
		(super init:)
		(Load rsMESSAGE 330)
		(gGame handsOff:)
		(Load rsVIEW 680)
		(Load rsVIEW 681)
		(Load rsVIEW 682)
		(Load rsVIEW 683)
		(Load rsVIEW 684)
		(Load rsVIEW 685)
		(if (IsFlag 470)
			(gGkMusic1
				number: 101
				setLoop: -1
				play:
				setVol: 0
				fade: (gGkMusic1 musicVolume:) 25 10 0
			)
		else
			(gGkMusic1
				number: 332
				setLoop: -1
				play:
				setVol: 0
				fade: (gGkMusic1 musicVolume:) 25 10 0
			)
		)
		(gCurRoom setScript: doTheMovie)
	)

	(method (dispose)
		(gGkMusic1 fade:)
		(super dispose:)
	)
)

(instance doTheMovie of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(gMessager sayRange: 12 0 2 1 5 self 330) ; "(THIS IS A DREAM IN WHICH NEITHER SPEAKER IS VISIBLE. A SMALL VOODOO COFFIN COMES SPINNING UP FROM THE BLACKNESS AND CREAKS OPENS)Fire light... <mumble> Gabriel?"
			)
			(2
				(gMessager sayRange: 12 0 2 6 8 0 330) ; "(SCARED, PROTESTING)'s not mine! Too small!"
				(theCoffin init: cycleSpeed: 11 setCycle: End self)
			)
			(3
				(theCoffin setCel: 0 setLoop: 1 1 setCycle: End self)
			)
			(4
				(theCoffin setCel: 0 setLoop: 2 1 setCycle: End self)
			)
			(5
				(theCoffin setCel: 0 setLoop: 0 1 view: 681 setCycle: End self)
			)
			(6
				(theCoffin setCel: 0 setLoop: 0 1 view: 682 setCycle: End self)
			)
			(7
				(theCoffin setCel: 0 setLoop: 0 1 view: 683 setCycle: End self)
			)
			(8
				(theCoffin setCel: 0 setLoop: 0 1 view: 684 setCycle: End self)
			)
			(9
				(theCoffin setCel: 0 setLoop: 0 1 view: 685 setCycle: End self)
			)
			(10
				(gMessager say: 12 0 2 9 self 330) ; "(SARCASTIC, RUDE)Young man, the lecture is OVER."
			)
			(11
				(gCurRoom newRoom: 330)
			)
		)
	)
)

(instance theCoffin of Prop
	(properties
		x 161
		y 84
		view 680
	)
)

