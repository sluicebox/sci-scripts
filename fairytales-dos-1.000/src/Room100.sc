;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 100)
(include sci.sh)
(use Main)
(use goGet)
(use GameControls)
(use LoadMany)
(use Window)
(use Sound)
(use Motion)
(use Game)
(use Actor)

(public
	Room100 0
)

(local
	local0 = {TALES}
	local1 = 1
)

(instance Room100 of Rm
	(properties
		picture 106
		style 10
	)

	(method (init)
		(SetPort 0 0 200 320 0 0)
		(super init: &rest)
		(LoadMany rsPIC 100 101 102)
		(LoadMany rsVIEW 100 108 849)
		(LoadMany rsSOUND 2 156)
		(sparkle1 init:)
		(sparkle2 init:)
		(gGlobalMusic number: 48 setVol: 127 flags: 1 play: startGame)
		(gCurRoom setScript: startGame)
	)

	(method (doit)
		(super doit:)
		(if local1
			(Palette palANIMATE 96 218 -1)
		)
	)

	(method (dispose)
		(startControls dispose:)
		(super dispose: &rest)
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

(instance startGame of HandsOffScript
	(properties)

	(method (changeState newState &tmp [temp0 20] [temp20 400] temp420 temp421)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(gGame setCursor: 69 1 304 172)
				(= cycles 1)
			)
			(2
				(if (== (gGlobalMusic prevSignal:) 20)
					(sparkle1 setCycle: End self)
				else
					(-- state)
				)
			)
			(3
				(if (== (gGlobalMusic prevSignal:) 30)
					(sparkle1 dispose:)
					(sparkle2 setCycle: End self)
				else
					(-- state)
				)
			)
			(4
				(if
					(and
						(== (sparkle2 cel:) (sparkle2 lastCel:))
						(== (gGlobalMusic prevSignal:) -1)
					)
					(sparkle2 dispose:)
					(= cycles 1)
				else
					(-- state)
				)
			)
			(5
				(= ticks 60)
			)
			(6
				(= local1 0)
				(gCurRoom drawPic: 100 9)
				(gGlobalMusic number: 2 priority: 15 setLoop: -1 play:)
				(= ticks 120)
			)
			(7
				(sfx number: 156 play:)
				(magEffectLeft init: cycleSpeed: 24 setCycle: CT 4 1 self)
				(magEffectRight init: cycleSpeed: 24 setCycle: CT 4 1)
			)
			(8
				(gCurRoom overlay: 102 8)
				(magEffectLeft setPri: 15 setCycle: End self)
				(magEffectRight setPri: 15 setCycle: End)
			)
			(9
				(sfx stop:)
				(magEffectLeft dispose:)
				(magEffectRight dispose:)
				(= ticks 120)
			)
			(10
				(gCurRoom overlay: 101 8)
				(= ticks 300)
			)
			(11
				(if
					(==
						(= temp420 (GetSaveFiles (gGame name:) @temp20 @temp0))
						0
					)
					(gCurRoom newRoom: 1)
				else
					(gGame setCursor: 999 1 130 105)
					(startControls init: show:)
				)
			)
		)
	)
)

(instance gameStart of SysWindow
	(properties
		top 50
		left 100
		bottom 110
		right 220
	)
)

(instance startControls of GameControls
	(properties
		stopSound 0
	)

	(method (init)
		(= window gameStart)
		(self add: iconRest iconNew)
		(super init: &rest)
	)

	(method (dispatchEvent event)
		(if (and (== (event type:) evKEYBOARD) (== (event message:) KEY_ESCAPE))
			(event message: JOY_NULL)
		)
		(super dispatchEvent: event)
	)
)

(instance iconNew of CodeIcon
	(properties
		view 849
		loop 1
		cel 0
		nsLeft 60
		nsTop 0
		cursor 80
		signal 193
		highlightColor 5
		lowlightColor 64
	)

	(method (select)
		(if (super select: &rest)
			(gCurRoom newRoom: 1)
		)
	)
)

(instance iconRest of CodeIcon
	(properties
		view 849
		loop 0
		cel 0
		nsTop 0
		cursor 80
		highlightColor 5
		lowlightColor 64
	)

	(method (select)
		(if (super select: &rest)
			(gGame restore:)
		)
	)
)

(instance magEffectLeft of Prop
	(properties
		x 78
		y 154
		view 100
	)
)

(instance magEffectRight of Prop
	(properties
		x 222
		y 154
		view 100
		loop 1
	)
)

(instance sfx of Sound
	(properties
		flags 1
		number 156
	)
)

