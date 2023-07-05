;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 500)
(include sci.sh)
(use Main)
(use Interface)
(use Osc)
(use LoadMany)
(use DCIcon)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm500 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5 = 1
)

(instance rm500 of Rm
	(properties
		picture 106
		style 10
	)

	(method (init)
		(SetPort 0 0 200 320 0 0)
		(super init:)
		(Load rsSCRIPT 939)
		(LoadMany rsPIC 510 520)
		(LoadMany rsVIEW 481 501 500)
		(LoadMany rsSOUND 100 101 102 103)
		(sparkle1 init:)
		(sparkle2 init:)
		(lightning init: hide:)
		(bridgeZap init: hide:)
		(bridgeZap2 init: hide:)
		(zapCastle init:)
		(zapLeft init:)
		(zapRight init:)
		(electrons init: hide:)
		(drip init: hide:)
		(lightBulb init: hide:)
		(clock init: hide:)
		(eyeBalls init: hide:)
		(poles init: hide:)
		(windupKey init: hide:)
		(telescope init: hide:)
		(gCMusic number: 1 setVol: 127 flags: 1 play: opening)
		(self setScript: opening)
	)

	(method (dispose)
		(SetPort 0 0 190 320 10 0)
		(introSound dispose:)
		(super dispose:)
	)

	(method (doit)
		(super doit:)
		(if local5
			(Palette palANIMATE 96 218 -1)
		)
		(if (and (not local4) (== (introSound prevSignal:) 7))
			(= local4 1)
		)
		(if local2
			(Sound pause: 1)
			(switch
				(= local1
					(Print
						{Would you like to skip\nthe introduction or\nwatch the whole thing?\n}
						82
						corey
						0
						0
						67
						30
						60
						106
						81
						{Skip it}
						4
						106
						81
						{Watch it}
						0
						106
						81
						{Restore a Game}
						1
					)
				)
				(0
					(Sound pause: 0)
				)
				(1
					(Sound pause: 0)
					(gGame restore:)
				)
				(2
					(gCast eachElementDo: #dispose)
					(gGame restart:)
				)
				(3
					(= gQuit 1)
				)
				(4
					(gCurRoom newRoom: 100)
				)
			)
			(gGame setCursor: 50 0 1000 1000)
			(= local2 0)
			((User curEvent:) type: evNULL)
		)
		(if (OneOf ((User curEvent:) type:) evMOUSEBUTTON evKEYBOARD evJOYDOWN)
			(gGame setCursor: 80 1 103 104)
			(= local2 1)
		)
	)
)

(instance sparkle1 of Prop
	(properties
		x 133
		y 35
		view 108
	)
)

(instance sparkle2 of Prop
	(properties
		x 60
		y 155
		view 108
		loop 1
	)
)

(instance opening of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== (gCMusic prevSignal:) 20)
					(sparkle1 setCycle: End self)
				else
					(-- state)
				)
			)
			(1
				(if (== (gCMusic prevSignal:) 30)
					(sparkle1 dispose:)
					(sparkle2 setCycle: End self)
				else
					(-- state)
				)
			)
			(2
				(if
					(and
						(== (sparkle2 cel:) (sparkle2 lastCel:))
						(== (gCMusic prevSignal:) -1)
					)
					(sparkle2 dispose:)
					(= cycles 1)
				else
					(-- state)
				)
			)
			(3
				(= ticks 60)
			)
			(4
				(= local5 0)
				(SetPort 0 0 190 320 10 0)
				(gCurRoom drawPic: 510 10)
				(introSound init: playBed:)
				(= ticks 1)
			)
			(5
				(= ticks 80)
			)
			(6
				(thunder2 play:)
				(zapCastle setCycle: End self)
			)
			(7
				(= ticks 40)
			)
			(8
				(zapLeft setCycle: End self)
			)
			(9
				(= ticks 30)
			)
			(10
				(thunder play:)
				(zapRight setCycle: End self)
			)
			(11
				(= ticks 30)
			)
			(12
				(thunder2 play:)
				(zapRight setCycle: Beg)
				(zapLeft setCycle: Beg)
				(= ticks 50)
			)
			(13
				(zapLeft setCycle: End self)
			)
			(14
				(= ticks 40)
			)
			(15
				(thunder play:)
				(zapRight setCycle: End self)
			)
			(16
				(= ticks 30)
			)
			(17
				(thunder2 play:)
				(zapRight setCycle: Beg)
				(zapLeft setCycle: Beg)
				(zapCastle setCycle: Beg)
				(= ticks 50)
			)
			(18
				(zapLeft setCycle: End)
				(zapRight setCycle: End)
				(= ticks 40)
			)
			(19
				(thunder2 play:)
				(zapLeft setCycle: Beg)
				(zapRight setCycle: Beg)
				(= ticks 30)
			)
			(20
				(zapLeft setCycle: End)
				(zapCastle setCycle: End)
				(zapRight setCycle: End)
				(= ticks 40)
			)
			(21
				(thunder2 play:)
				(zapRight setCycle: Beg)
				(zapLeft setCycle: Beg)
				(= ticks 50)
			)
			(22
				(zapRight setCycle: End)
				(zapLeft setCycle: End)
				(zapCastle setCycle: Beg)
				(= ticks 10)
			)
			(23
				(thunder play:)
				(thunder2 play:)
				(zapLeft setCycle: Beg)
				(zapCastle setCycle: End)
				(zapRight setCycle: Beg)
				(= ticks 10)
			)
			(24
				(thunder play:)
				(thunder2 play:)
				(zapRight setCycle: End)
				(zapLeft setCycle: End)
				(zapCastle setCycle: Beg)
				(= ticks 10)
			)
			(25
				(gCurRoom setScript: opening2)
			)
		)
	)
)

(instance opening2 of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(if (and local3 local4)
			(= local3 0)
			(self cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(LoadMany rsPIC 500)
				(= local3 1)
				(= ticks 360)
			)
			(1
				(= local3 0)
				(lightning show: setCycle: End)
				(= ticks 3)
			)
			(2
				(lightning hide: setCel: 0)
				(= ticks 1)
			)
			(3
				(thunder3 play:)
				(lightning show: setCycle: End self)
			)
			(4
				(lightning hide: setCel: 0)
				(= ticks 1)
			)
			(5
				(bridgeZap show: setCycle: End self)
			)
			(6
				(gCurRoom drawPic: 500 9)
				(bridgeZap hide:)
				(bridgeZap2 hide:)
				(electrons show: setCycle: Fwd)
				(drip show: setCycle: Fwd)
				(lightBulb show: setCycle: Fwd)
				(clock show: setCycle: Fwd)
				(eyeBalls show: setCycle: Fwd)
				(poles show: setCycle: Fwd)
				(windupKey show: setCycle: Fwd)
				(telescope show: setCycle: Osc)
				(= ticks 780)
			)
			(7
				(drip setCycle: End self)
			)
			(8
				(drip hide:)
				(= ticks 10)
			)
			(9
				(gCurRoom overlay: 520 2)
				(= ticks 900)
			)
			(10
				(introSound fade: 0 10 4 1 self)
			)
			(11
				(gCurRoom newRoom: 100)
			)
		)
	)
)

(instance lightning of Prop
	(properties
		x 133
		view 501
		priority 15
		signal 16
	)
)

(instance bridgeZap of Prop
	(properties
		x 116
		y 93
		view 501
		loop 1
		priority 14
		signal 16
		cycleSpeed 12
	)
)

(instance bridgeZap2 of Prop
	(properties
		x 116
		y 93
		view 501
		loop 1
		cel 3
		priority 14
		signal 16
		cycleSpeed 12
	)
)

(instance electrons of Prop
	(properties
		x 169
		y 27
		view 500
	)
)

(instance drip of Prop
	(properties
		x 137
		y 110
		view 500
		loop 1
	)
)

(instance lightBulb of Prop
	(properties
		x 295
		y 34
		view 500
		loop 2
	)
)

(instance clock of Prop
	(properties
		x 261
		y 83
		view 500
		loop 3
	)
)

(instance eyeBalls of Prop
	(properties
		x 203
		y 189
		view 500
		loop 4
		cycleSpeed 18
	)
)

(instance poles of Prop
	(properties
		x 55
		y 100
		view 500
		loop 5
		priority 14
		signal 16
	)
)

(instance windupKey of Prop
	(properties
		x 245
		y 18
		view 500
		loop 6
	)
)

(instance telescope of Actor
	(properties
		x 201
		y 4
		view 500
		loop 7
		cycleSpeed 12
	)
)

(instance zapCastle of Prop
	(properties
		x 201
		view 505
		cycleSpeed 24
	)
)

(instance zapRight of Prop
	(properties
		x 306
		y 31
		view 505
		loop 1
		cycleSpeed 18
	)
)

(instance zapLeft of Prop
	(properties
		x 98
		view 505
		loop 2
		cycleSpeed 18
	)
)

(instance thunder of Sound
	(properties
		number 101
		priority 15
	)
)

(instance thunder2 of Sound
	(properties
		number 102
		priority 15
	)
)

(instance thunder3 of Sound
	(properties
		number 103
		priority 15
	)
)

(instance corey of DCIcon
	(properties
		view 481
		loop 13
		cycleSpeed 12
	)

	(method (init)
		((= cycler (Osc new:)) init: self)
	)
)

(instance introSound of Sound
	(properties
		number 100
		priority 12
		loop -1
	)
)

