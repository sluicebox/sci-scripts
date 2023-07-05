;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 100)
(include sci.sh)
(use Main)
(use KQ6Room)
(use Motion)
(use Actor)
(use System)

(public
	rm100 0
)

(local
	local0
	local1
	local2
	local3
)

(instance rm100 of KQ6Room
	(properties)

	(method (init)
		(super init: &rest)
		(if (or (== gHowFast 0) (not global169))
			(Palette palSET_INTENSITY 0 255 0)
			(Load rsPIC 100)
			(presents init:)
			(DrawPic 99)
		)
		(gGame setCursor: blankCursor)
		(gTheIconBar disable:)
		(gCurRoom setScript: introScript)
	)

	(method (doVerb))

	(method (newRoom)
		(gTheIconBar height: 0 activateHeight: 0)
		(super newRoom: &rest)
	)
)

(instance introScript of Script
	(properties)

	(method (handleEvent event)
		(if (and (& (event type:) evKEYBOARD) (== (event message:) KEY_ESCAPE))
			(event claimed: 1)
		)
		(return 0)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(super dispose:)
	)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(gKeyDownHandler add: self)
				(if (and global169 (Platform 7) (> gHowFast 0))
					(self setScript: winLogo self)
				else
					(self setScript: dosLogo self)
				)
			)
			(1
				(gCurRoom drawPic: 100 9)
				(= cycles 1)
			)
			(2
				(if global169
					(= cycles 1)
				else
					(FadeCode init: 100 1 self)
				)
			)
			(3
				(six init:)
				(gGlobalSound number: 2 loop: 1 play: self)
				(= seconds 5)
			)
			(4
				(six setCycle: End)
			)
			(5
				(gGame handsOn:)
				(= seconds 10)
				(gTheIconBar
					enable:
					disable: 0 1 2 3 4 5
					height: -100
					activateHeight: -100
				)
				(Portrait 0 {ALEX})
				(Cursor showCursor: 1)
				(gGame setCursor: gNormalCursor)
				(six stopUpd:)
				(openingBut init: stopUpd:)
				(playBut init: stopUpd:)
				(helpBut init: stopUpd:)
				(restoreBut init: stopUpd:)
			)
			(6)
		)
	)
)

(instance FadeCode of Code
	(properties)

	(method (init param1 param2 param3)
		(= local3 0)
		(if (>= argc 1)
			(= local2 param1)
			(if (>= argc 2)
				(= local1 param2)
				(if (>= argc 3)
					(= local3 param3)
				)
			)
		)
		(gTheDoits add: self)
	)

	(method (doit &tmp temp0)
		(if (!= local0 local2)
			(+= local0 (* 1 local1))
			(Palette palSET_INTENSITY 0 255 local0)
			(for ((= temp0 0)) (< temp0 10) ((++ temp0))
			)
		else
			(gTheDoits delete: self)
			(if (and local3 (IsObject local3))
				(local3 cue:)
				(= local3 0)
			)
		)
	)
)

(instance glint of Prop
	(properties
		x 161
		y 124
		view 100
	)
)

(instance presents of Prop
	(properties
		x 132
		y 182
		view 100
		loop 1
	)
)

(instance blankCursor of Cursor
	(properties
		view 998
		cel 1
	)
)

(class ButtonActor of Actor
	(properties)

	(method (init)
		(super init: &rest)
		(gKeyDownHandler add: self)
		(gMouseDownHandler add: self)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event)
		(if
			(and
				(not (event modifiers:))
				(or
					(& (event type:) evMOUSEBUTTON)
					(and (& (event type:) evKEYBOARD) (== (event message:) KEY_RETURN))
				)
				(<= nsLeft (event x:) nsRight)
				(<= nsTop (event y:) nsBottom)
			)
			((gCurRoom script:) seconds: 0)
			(if (self flash: (& (event type:) evKEYBOARD))
				(self cue:)
			)
			(event claimed: 1)
		)
		(event claimed:)
	)

	(method (flash param1 &tmp temp0 temp1)
		(= temp1 0)
		(self startUpd:)
		(while (!= ((= temp0 (Event new:)) type:) (if param1 8 else 2))
			(temp0 localize:)
			(self cel: (super onMe: temp0))
			(Animate (gCast elements:) 1)
			(temp0 dispose:)
		)
		(if (== cel 1)
			(= temp1 1)
		)
		(self cel: 0 stopUpd:)
		(Animate (gCast elements:) 1)
		(temp0 dispose:)
		(if (not temp1)
			((gCurRoom script:) seconds: 8)
		)
		(return temp1)
	)
)

(instance openingBut of ButtonActor
	(properties
		x 110
		y 174
		view 100
		loop 3
	)

	(method (cue)
		(cond
			((and global169 (Platform 7) (DoSound sndGET_AUDIO_CAPABILITY))
				(gCurRoom newRoom: 108)
			)
			(
				(and
					(not global169)
					(not (== gHowFast 0))
					(== (Graph grGET_COLOURS) 256)
					(DoSound sndGET_AUDIO_CAPABILITY)
				)
				(gCurRoom newRoom: 105)
			)
			(else
				(gCurRoom newRoom: 106) ; egaToon
			)
		)
	)
)

(instance playBut of ButtonActor
	(properties
		x 220
		y 173
		view 100
		loop 5
	)

	(method (cue)
		(gCurRoom newRoom: 200)
	)
)

(instance helpBut of ButtonActor
	(properties
		x 165
		y 174
		view 100
		loop 4
	)

	(method (cue)
		(gCurRoom newRoom: 205)
	)
)

(instance restoreBut of ButtonActor
	(properties
		x 55
		y 174
		view 100
		loop 2
	)

	(method (cue)
		(gGame restore:)
		(gGame setCursor: gNormalCursor)
		((gCurRoom script:) seconds: 8)
	)
)

(instance six of Prop
	(properties
		x 113
		y 74
		view 101
	)
)

(instance dosLogo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Cursor showCursor: 0)
				(gGlobalSound number: 1 loop: 1)
				(gGlobalSound play: self)
			)
			(1
				(if (not global169)
					(if (== gHowFast 0)
						(FadeCode init: 100 1 self)
					else
						(FadeCode init: 100 1)
					)
				)
			)
			(2
				(glint init: setCycle: End)
			)
			(3
				(glint posn: 148 143 setCycle: End)
			)
			(4
				(= cycles 1)
			)
			(5
				(if global169
					(= cycles 1)
				else
					(FadeCode init: 0 -1 self)
				)
			)
			(6
				(presents dispose:)
				(glint dispose:)
				(if global169
					(gCurRoom drawPic: 98)
				)
				(= cycles 1)
			)
			(7
				(self dispose:)
			)
		)
	)
)

(instance winLogo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom drawPic: 98)
				(= cycles 1)
			)
			(1
				(if (not (ShowMovie 0 {hdlogo.avi}))
					(ShowMovie 1 0 5)
					(ShowMovie 2 0 self)
				else
					(= cycles 1)
				)
			)
			(2
				(ShowMovie 6)
				(self dispose:)
			)
		)
	)
)

