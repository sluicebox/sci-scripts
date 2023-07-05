;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 666)
(include sci.sh)
(use Main)
(use eRS)
(use LoadMany)
(use Sound)
(use Motion)
(use Inventory)
(use User)
(use System)

(public
	rm666 0
)

(local
	local0
	local1
	local2
	local3
)

(instance rm666 of LBRoom
	(properties)

	(method (init)
		(self setRegions: 90) ; MuseumRgn
		(if (== gPrevRoomNum 520)
			(gEgo init: posn: 277 55 normalize: 732)
			(SetFlag 31)
		else
			(gEgo init: posn: 96 161 normalize: 732)
		)
		(self
			picture:
				(if ((Inv at: 15) cel:) ; lantern
					(if (== gPrevRoomNum 520) 735 else 730)
				else
					780
				)
		)
		(if ((Inv at: 15) cel:) ; lantern
			(Palette palSET_INTENSITY 0 255 0)
		)
		(gGame handsOff:)
		(super init:)
		(if ((Inv at: 15) cel:) ; lantern
			(WrapMusic pause: 0)
			(= local0 1)
			(if (== gPrevRoomNum 520)
				(self setScript: sEnterSouthLight520)
			else
				(self setScript: sEnterSouthLight)
			)
		else
			(gGameMusic2 number: 56 flags: 1 loop: -1 play:)
			(gEgo hide:)
			(LoadMany rsSOUND 82 53)
			(self setScript: sEnterDark)
		)
	)

	(method (doit)
		(super doit: &rest)
		(if (and (== (self picture:) 780) ((Inv at: 15) cel:)) ; lantern
			(gGame handsOff:)
			(gGameMusic2 fade:)
			(WrapMusic pause: 0)
			(= local0 1)
			(Palette palSET_INTENSITY 0 255 0)
			(if (== gPrevRoomNum 520)
				(self picture: 735 drawPic: 735)
			else
				(self picture: 730 drawPic: 730)
			)
			(if (== gPrevRoomNum 520)
				(gEgo
					view: 732
					setLoop: 5
					posn: 277 55
					cycleSpeed: 4
					moveSpeed: 4
					xStep: 2
					setCycle: Walk
					show:
				)
			else
				(gEgo
					view: 732
					setLoop: 0
					posn: 96 161
					cycleSpeed: 4
					moveSpeed: 4
					xStep: 2
					setCycle: Walk
					show:
				)
			)
			(= local3 1)
		)
		(if local0
			(Palette palSET_INTENSITY 0 255 (+= local2 2))
			(if (>= local2 100)
				(= local0 0)
				(if local3
					(if (== gPrevRoomNum 520)
						(self setScript: sEnterSouthLight520)
					else
						(self setScript: sEnterSouthLight)
					)
				)
			)
		)
		(if local1
			(Palette palSET_INTENSITY 0 255 (Max 0 (-= local2 3)))
			(if (== local2 0)
				(= local1 0)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(cond
			((== newRoomNumber 99) 0) ; deathRoom
			((== gPrevRoomNum 650)
				(if
					(and
						(== gAct 3)
						(TimeCheck $c304 1) ; can 12:45 am occur?
						(not (TimeCheck $c304)) ; has 12:45 am occurred?
					)
					(= newRoomNumber 565)
				else
					(= newRoomNumber 560)
				)
			)
			((== gPrevRoomNum 630)
				(= newRoomNumber 454)
			)
			((== gPrevRoomNum 520)
				(= newRoomNumber 610)
			)
		)
		(super newRoom: newRoomNumber)
	)

	(method (dispose)
		(WrapMusic pause: 1)
		(gGameMusic2 fade:)
		(super dispose: &rest)
	)
)

(instance sEnterSouthLight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if local3
					(= cycles 1)
				else
					(gEgo
						setLoop: 0
						posn: -10 240
						edgeHit: EDGE_NONE
						setCycle: Walk
						cycleSpeed: 4
						moveSpeed: 4
						xStep: 2
						setMotion: MoveTo 96 161 self
					)
				)
			)
			(1
				(gEgo setMotion: MoveTo 277 55 self)
			)
			(2
				(= local1 1)
				(gEgo setMotion: MoveTo 335 23 self)
			)
			(3
				(gCurRoom drawPic: 780)
				(gCurRoom newRoom: 0)
				(self dispose:)
			)
		)
	)
)

(instance sEnterSouthLight520 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if local3
					(= cycles 1)
				else
					(gEgo
						setLoop: 5
						posn: 335 23
						edgeHit: EDGE_NONE
						setCycle: Walk
						cycleSpeed: 4
						moveSpeed: 4
						xStep: 2
						setMotion: MoveTo 277 55 self
					)
				)
			)
			(1
				(gEgo setMotion: MoveTo 96 161 self)
			)
			(2
				(= local1 1)
				(gEgo setMotion: MoveTo -10 240 self)
			)
			(3
				(gCurRoom drawPic: 780)
				(gCurRoom newRoom: 0)
				(self dispose:)
			)
		)
	)
)

(instance sEnterDark of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gEgo has: 15) ; lantern
					(gGame handsOn:)
					(User canControl: 0)
					(User canInput: 0)
					(gTheIconBar disable: 0 1 2 3 4 5 7)
					(= seconds 8)
				else
					(gTheIconBar disable: 6)
					(= seconds 4)
				)
			)
			(1
				(sFX2 number: 53 loop: -1 flags: 1 play:)
				(= ticks 120)
			)
			(2
				(sFX number: 82 loop: 1 flags: 5 play: self)
			)
			(3
				(sFX2 fade: self)
			)
			(4
				(= global145 15) ; "In the darkness of the secret passage, you're blind as a bat. You have a brave, but brief, battle, during which you endure the battering of the berserk and bellicose black bats without batting an eye. Then your body, bothered by bloody bites, becomes bereft of life."
				(gCurRoom newRoom: 99) ; deathRoom
				(self dispose:)
			)
		)
	)
)

(instance sFX of Sound
	(properties
		flags 1
	)
)

(instance sFX2 of Sound
	(properties
		flags 1
	)
)

