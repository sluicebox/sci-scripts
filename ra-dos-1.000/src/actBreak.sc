;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 26)
(include sci.sh)
(use Main)
(use eRS)
(use LoadMany)
(use Motion)
(use Actor)
(use System)

(public
	actBreak 0
)

(local
	local0
	local1
	local2
	local3 = 5
	local4 = 12
	local5 = 43
	local6 = 58
	local7 = 61
	local8
)

(instance actBreak of LBRoom
	(properties
		picture 780
		style 10
	)

	(method (init)
		(LoadMany rsVIEW 26)
		(LoadMany rsSOUND 30)
		(gGame handsOff:)
		(switch gAct
			(0
				(= local0 230)
			)
			(1
				(= local8 (/ (* gScore 100) local3))
				(= local0 330)
			)
			(2
				(= local8 (/ (* gScore 100) local4))
				(= local0 18)
			)
			(3
				(= local8 (/ (* gScore 100) local5))
				(= local0 (if (== gPrevRoomNum 620) 610 else 510))
			)
			(4
				(= local8 (/ (* gScore 100) local6))
				(= local0 18)
			)
			(5
				(= local8 (/ (* gScore 100) local7))
				(= local0 750)
			)
		)
		(super init: &rest)
		(cond
			((< -1 local8 21)
				(= local1 2)
				(= local2 global131)
				(++ global131)
			)
			((< 20 local8 41)
				(= local1 3)
				(= local2 global132)
				(++ global132)
			)
			((< 40 local8 61)
				(= local1 4)
				(= local2 global133)
				(++ global133)
			)
			((< 60 local8 81)
				(= local1 5)
				(= local2 global134)
				(++ global134)
			)
			((< 80 local8 101)
				(= local1 6)
				(= local2 global135)
				(++ global135)
			)
		)
		(actView init: cel: gAct)
		(gGameMusic1 number: 30 flags: 1 loop: -1 play:)
		(self setScript: sBreakIt)
	)
)

(instance sBreakIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom picture: 26 drawPic: 26)
				(= cycles 2)
			)
			(1
				(actView setMotion: MoveTo 150 115 self)
			)
			(2
				(titleView init: cel: gAct)
				(= seconds 3)
			)
			(3
				(actView setMotion: MoveTo 150 49 self)
			)
			(4
				(titleView setMotion: MoveTo 150 115 self)
			)
			(5
				(gGameMusic1 fade: 0 40 10 1)
				(= seconds 3)
			)
			(6
				(actView dispose:)
				(titleView setMotion: MoveTo 150 49 self)
			)
			(7
				(titleView dispose:)
				(gCurRoom drawPic: 780 10)
				(= seconds 2)
			)
			(8
				(gNarrator talkWidth: 120)
				(if (and local1 local2 gAct)
					(gMessager say: local1 0 0 local2 self)
				else
					(= cycles 1)
				)
			)
			(9
				(gGameMusic1 fade: 0 10 20 1)
				(++ gAct)
				(= gMustDos 0)
				(gCurRoom newRoom: local0)
				(self dispose:)
			)
		)
	)
)

(instance actView of Actor
	(properties
		x 150
		y 141
		view 26
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Talk
			(sBreakIt changeState: 8)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance titleView of Actor
	(properties
		x 150
		y 161
		view 26
		loop 1
	)
)

