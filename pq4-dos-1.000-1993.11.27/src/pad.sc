;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 33)
(include sci.sh)
(use Main)
(use Array)
(use Inset)
(use IconBar)
(use Tutorial)
(use System)

(public
	pad 0
)

(local
	local0
	local1
	local2
)

(instance pad of Inset
	(properties
		picture 565
		disposeNotOnMe 1
	)

	(method (onMe)
		(return 0)
	)

	(method (init)
		(gGlobalSound0 stop:)
		(= local2 gTheCursor)
		(gTheIconBar disable: 0 3 5 7 show: 0)
		(= local0 (IntArray newWith: 7 -1 -1 -1 -1 -1 -1 -1))
		(gGame setIntensity: 0)
		(super init: &rest)
		(gGame setIntensity: 100)
		(self setScript: startUp)
	)

	(method (dispose)
		(gTheIconBar enable: 0 3 5 7)
		(gGame setIntensity: 0)
		(local0 dispose:)
		(= local0 0)
		(gGlobalSound1 stop: number: 965 setLoop: 1 play:)
		(gGlobalSound0 number: 983 setLoop: -1 play:)
		(super dispose:)
		(FrameOut)
		(gGame setIntensity: 100)
	)
)

(instance startUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== global124 2)
					(self setScript: emmoCall)
				else
					(= ticks 30)
				)
			)
			(1
				(pPad init: show:)
				(FrameOut)
				(pPad doit: dispose:)
				(gGame setCursor: local2 1)
				(self cue:)
			)
			(2
				(checkNumber doit:)
				(self dispose:)
			)
		)
	)
)

(instance emmoCall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 20)
			)
			(1
				(gPqFlags clear: 25)
				(gPqFlags set: 29)
				(gGame points: 2)
				(gMessager say: 7 2 2 0 self 560) ; "Hello, Robbery, Homicide. This is Detective Carey. May I help you?"
			)
			(2
				(= global124 0)
				(pad dispose:)
			)
		)
	)
)

(instance ringer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlobalSound1 number: register setLoop: 1 play: self)
			)
			(1
				(= ticks 200)
			)
			(2
				(self init:)
			)
		)
	)

	(method (dispose)
		(gGlobalSound1 stop:)
		(super dispose:)
	)
)

(instance operator of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 80)
			)
			(1
				(gGlobalSound1 number: 948 setLoop: -1 play:)
				(self dispose:)
			)
		)
	)
)

(instance crash of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 80)
			)
			(1
				(self setScript: ringer 0 951)
				(= seconds (Random 10 30))
			)
			(2
				(self setScript: 0)
				(gGame points: 3)
				(gMessager say: 10 4 0 0 self 560) ; "CRASH unit, Barnes speaking."
			)
			(3
				(pad dispose:)
			)
		)
	)
)

(instance badNumber of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 80)
			)
			(1
				(switch (Random 0 10)
					(0
						(self setScript: ringer 0 951)
					)
					(1
						(gGlobalSound1 number: 948 setLoop: -1 play:)
						(self dispose:)
					)
					(2
						(= seconds (Random 5 10))
						(self setScript: ringer 0 951)
					)
					(3
						(= seconds (Random 5 10))
						(self setScript: ringer 0 951)
					)
					(else
						(self setScript: ringer 0 951)
					)
				)
			)
			(2
				(self setScript: 0)
				(gGlobalSound1 number: 971 setLoop: 1 play: self)
			)
			(3
				(gGlobalSound1 number: 949 setLoop: -1 play:)
			)
		)
	)
)

(instance checkNumber of Code
	(properties)

	(method (doit)
		(switch (local0 at: 0)
			(-1)
			(0
				(pad setScript: operator)
			)
			(8
				(switch (local0 at: 1)
					(8
						(switch (local0 at: 2)
							(3
								(switch (local0 at: 3)
									(2
										(switch (local0 at: 4)
											(6
												(pad setScript: crash)
											)
											(else
												(pad setScript: badNumber)
											)
										)
									)
									(else
										(pad setScript: badNumber)
									)
								)
							)
							(else
								(pad setScript: badNumber)
							)
						)
					)
					(else
						(pad setScript: badNumber)
					)
				)
			)
			(else
				(pad setScript: badNumber)
			)
		)
	)
)

(instance pPad of IconBar
	(properties
		y 29
	)

	(method (shouldClose)
		(return 0)
	)

	(method (shouldOpen)
		(return 1)
	)

	(method (init)
		(gGlobalSound1 number: 949 setLoop: -1 play:)
		(= local1 0)
		(local0 fill: 0 7 -1)
		(self
			add: b0 b1 b2 b3 b4 b5 b6 b7 b8 b9 astrick pound
			eachElementDo: #highlightColor -1
			eachElementDo: #lowlightColor -1
			curIcon: b0
		)
		(super init: &rest)
		(plane picture: -2 setBitmap: 565 0 0 0)
	)

	(method (doit &tmp temp0 temp1 temp2 temp3 temp4)
		(while (and (& state $0020) (= temp0 ((gUser curEvent:) new:)))
			(if
				(or
					(not (local0 at: 0))
					(== local1 7)
					(and (== (local0 at: 0) 8) (== local1 5))
				)
				(&= state $ffdf)
				(break)
			)
			(= temp1 (temp0 type:))
			(= temp2 (temp0 message:))
			(= temp3 (temp0 modifiers:))
			(= gGameTime (+ gTickOffset (GetTime)))
			(if gCuees
				(gCuees eachElementDo: #doit)
			)
			(if (and (= temp4 (gGame script:)) (temp4 isKindOf: Tutorial))
				(temp4 doit:)
			)
			(if (== temp1 32)
				(= temp1 4)
				(= temp2 (if (& temp3 $0003) 27 else 13))
				(= temp3 0)
				(temp0 type: temp1 message: temp2 modifiers: 0)
			)
			(temp0 localize: plane)
			(if
				(and
					(or (== temp1 1) (and (== temp1 4) (== temp2 13)))
					helpIconItem
					(& (helpIconItem signal:) $0010)
				)
				(temp0 type: 24576 message: (helpIconItem message:))
			)
			(MapKeyToDir temp0)
			(breakif
				(or
					(self dispatchEvent: temp0)
					(and (temp0 type:) (not (plane onMe: temp0)))
				)
			)
		)
	)
)

(instance b0 of IconI
	(properties
		x 29
		y 72
		signal 129
		message 0
		mainView 565
		mainLoop 1
	)

	(method (select)
		(if (super select: &rest)
			(gGlobalSound1 number: 953 setLoop: 1 play:)
			(local0 at: local1 message)
			(++ local1)
		)
	)
)

(instance b1 of IconI
	(properties
		x 3
		y 2
		signal 129
		message 1
		mainView 565
		mainLoop 2
	)

	(method (select)
		(if (super select: &rest)
			(gGlobalSound1 number: 954 setLoop: 1 play:)
			(local0 at: local1 message)
			(++ local1)
		)
	)
)

(instance b2 of IconI
	(properties
		x 29
		y 2
		signal 129
		message 2
		mainView 565
		mainLoop 3
	)

	(method (select)
		(if (super select: &rest)
			(gGlobalSound1 number: 955 setLoop: 1 play:)
			(local0 at: local1 message)
			(++ local1)
		)
	)
)

(instance b3 of IconI
	(properties
		x 55
		y 2
		signal 129
		message 3
		mainView 565
		mainLoop 4
	)

	(method (select)
		(if (super select: &rest)
			(gGlobalSound1 number: 956 number: setLoop: 1 play:)
			(local0 at: local1 message)
			(++ local1)
		)
	)
)

(instance b4 of IconI
	(properties
		x 3
		y 25
		signal 129
		message 4
		mainView 565
		mainLoop 5
	)

	(method (select)
		(if (super select: &rest)
			(gGlobalSound1 number: 957 setLoop: 1 play:)
			(local0 at: local1 message)
			(++ local1)
		)
	)
)

(instance b5 of IconI
	(properties
		x 29
		y 25
		signal 129
		message 5
		mainView 565
		mainLoop 6
	)

	(method (select)
		(if (super select: &rest)
			(gGlobalSound1 number: 958 setLoop: 1 play:)
			(local0 at: local1 message)
			(++ local1)
		)
	)
)

(instance b6 of IconI
	(properties
		x 55
		y 25
		signal 129
		message 6
		mainView 565
		mainLoop 7
	)

	(method (select)
		(if (super select: &rest)
			(gGlobalSound1 number: 959 setLoop: 1 play:)
			(local0 at: local1 message)
			(++ local1)
		)
	)
)

(instance b7 of IconI
	(properties
		x 3
		y 48
		signal 129
		message 7
		mainView 565
		mainLoop 8
	)

	(method (select)
		(if (super select: &rest)
			(gGlobalSound1 number: 960 setLoop: 1 play:)
			(local0 at: local1 message)
			(++ local1)
		)
	)
)

(instance b8 of IconI
	(properties
		x 29
		y 48
		signal 129
		message 8
		mainView 565
		mainLoop 9
	)

	(method (select)
		(if (super select: &rest)
			(gGlobalSound1 number: 961 setLoop: 1 play:)
			(local0 at: local1 message)
			(++ local1)
		)
	)
)

(instance b9 of IconI
	(properties
		x 55
		y 48
		signal 129
		message 9
		mainView 565
		mainLoop 10
	)

	(method (select)
		(if (super select: &rest)
			(gGlobalSound1 number: 962 setLoop: 1 play:)
			(local0 at: local1 message)
			(++ local1)
		)
	)
)

(instance astrick of IconI
	(properties
		x 3
		y 72
		signal 129
		mainView 565
		mainLoop 11
	)

	(method (select)
		(if (super select: &rest)
			(gGlobalSound1 number: 963 setLoop: 1 play:)
			(local0 at: local1 message)
			(++ local1)
		)
	)
)

(instance pound of IconI
	(properties
		x 55
		y 72
		signal 129
		mainView 565
		mainLoop 12
	)

	(method (select)
		(if (super select: &rest)
			(gGlobalSound1 number: 952 setLoop: 1 play:)
			(local0 at: local1 message)
			(++ local1)
		)
	)
)

