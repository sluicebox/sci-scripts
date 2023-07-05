;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 209)
(include sci.sh)
(use Main)
(use PriorityTalker)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	sStartViewPort 0
	sStopViewPort 1
	viewPort 2
	viewPortTalker 14
	viewPortTalker 16
	viewPortTalker 18
)

(instance theMusic3 of Sound
	(properties)
)

(instance sStartViewPort of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(viewPort init: setCycle: End self)
			)
			(1
				(viewPort
					view: register
					setLoop: 0
					setCel: 0
					setCycle: 0
					stopUpd:
				)
				(theMusic3 dispose:)
				(= seconds 2)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance sStopViewPort of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== (viewPort view:) 210)
					(++ state)
				)
				(= cycles 1)
			)
			(1
				(viewPort view: 205 setLoop: 1 cel: 0 setCycle: 0)
				(= seconds 2)
			)
			(2
				(viewPort view: 205 setLoop: 0 cel: 1 setCycle: End self)
			)
			(3
				(theMusic3 dispose:)
				(viewPort view: 193 setLoop: 0 cel: 0 setCycle: End self)
			)
			(4
				(UnLoad 128 205)
				(= seconds 1)
			)
			(5
				(viewPort dispose:)
				(= seconds 1)
			)
			(6
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 209)
	)
)

(instance viewPort of Prop
	(properties
		x 110
		y 43
		view 205
		priority 7
		signal 16401
	)

	(method (init)
		(self setLoop: 0 setCel: 0)
		(super init: &rest)
	)

	(method (setCycle param1)
		(if (and param1 (== view 205))
			(theMusic3 number: 222 loop: 1 play:)
		)
		(super setCycle: param1 &rest)
	)
)

(instance viewPortTalker of PriorityTalker
	(properties
		x 110
		y 43
		view 207
		priority 7
		signal 16401
		talkWidth 100
	)

	(method (init)
		(self setPri: 7)
		(= font gUserFont)
		(= gSystemWindow gSpeakWindow)
		(gSystemWindow tailX: 225 tailY: 85 xOffset: 40 isBottom: 1)
		(switch global122
			(24
				(self view: 207 loop: 0)
				(super init: 0 wd40Eyes 0 &rest)
			)
			(25
				(switch global142
					(0
						(self view: 209 loop: 0 cel: 0)
						(quirkEyes
							view: 209
							loop: 2
							cel: 0
							nsLeft: 37
							nsTop: 16
						)
						(quirkMouth
							view: 209
							loop: 1
							cel: 0
							nsLeft: 37
							nsTop: 39
						)
					)
					(1
						(self view: 210 loop: 0 cel: 0)
						(quirkEyes
							view: 210
							loop: 3
							cel: 0
							nsLeft: 32
							nsTop: 25
						)
						(quirkMouth
							view: 210
							loop: 1
							cel: 0
							nsLeft: 33
							nsTop: 43
						)
					)
					(2
						(self view: 204 loop: 0 cel: 0)
						(quirkEyes
							view: 204
							loop: 2
							cel: 0
							nsLeft: 22
							nsTop: 11
						)
						(quirkMouth
							view: 204
							loop: 1
							cel: 0
							nsLeft: 23
							nsTop: 29
						)
					)
				)
				(super init: 0 quirkEyes quirkMouth &rest)
			)
			(47
				(self view: 208 loop: 0 cel: 0)
				(super init: 0 0 alienMouth &rest)
			)
		)
	)

	(method (dispose)
		(= gSystemWindow gSq5Win)
		(super dispose: &rest)
	)
)

(instance wd40Eyes of Prop
	(properties
		nsTop 27
		nsLeft 32
		view 207
		loop 1
		priority 7
		signal 16401
	)

	(method (init)
		(self setPri: 7)
		(super init: &rest)
	)
)

(instance alienMouth of Prop
	(properties
		nsTop 35
		nsLeft 20
		view 208
		loop 1
		priority 7
		signal 16401
	)

	(method (init)
		(self setPri: 7 ignoreActors: 1)
		(super init: &rest)
	)
)

(instance quirkMouth of Prop
	(properties
		nsTop 39
		nsLeft 37
		view 209
		loop 1
		priority 7
		signal 16401
	)
)

(instance quirkEyes of Prop
	(properties
		nsTop 16
		nsLeft 37
		view 209
		loop 2
		priority 7
		signal 16401
	)
)

