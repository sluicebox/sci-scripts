;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 531)
(include sci.sh)
(use Main)
(use AudioScript)
(use eRS)
(use Sq4Dialog)
(use Sq4Feature)
(use Sync)
(use Sound)
(use Motion)
(use System)

(public
	rm531 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	[local8 12]
	[local20 7]
	[local27 30] = [245 129 255 129 265 129 275 129 285 129 245 139 255 139 265 139 275 139 285 139 245 149 255 149 265 149 275 149 285 149]
	[local57 37] = [5 4 3 2 1 0 20 20 20 20 20 20 2 20 20 20 20 20 10 10 10 10 10 10 6 11 1 7 13 9 4 14 6 9 1 11 0]
	[local94 18] = [2 0 9 6 8 3 4 4 6 8 5 2 6 0 0 0 0 0]
	local112
	local113
	local114
	local115
	local116
)

(procedure (localproc_0 param1)
	(return
		(and
			(== ([local20 0] cel:) [local57 param1])
			(== ([local20 1] cel:) [local57 (++ param1)])
			(== ([local20 2] cel:) [local57 (++ param1)])
			(== ([local20 3] cel:) [local57 (++ param1)])
			(== ([local20 4] cel:) [local57 (++ param1)])
			(== ([local20 5] cel:) [local57 (++ param1)])
		)
	)
)

(procedure (localproc_1 param1)
	(return
		(and
			(== ([local20 0] cel:) [local94 (+ 0 param1)])
			(== ([local20 1] cel:) [local94 (+ 1 param1)])
			(== ([local20 2] cel:) [local94 (+ 2 param1)])
			(== ([local20 3] cel:) [local94 (+ 3 param1)])
			(== ([local20 4] cel:) [local94 (+ 4 param1)])
			(== ([local20 5] cel:) [local94 (+ 5 param1)])
		)
	)
)

(procedure (localproc_2 param1 &tmp temp0)
	(gCurRoom
		overlay:
			(switch param1
				(305
					(windshield noun: 0 lookStr: 31)
					(proc0_14 10)
					(= local2 6)
					533
				)
				(376
					(windshield noun: 0 lookStr: 32)
					(proc0_14 10)
					(= local2 12)
					534
				)
				(530
					(windshield noun: 0 lookStr: 33)
					(proc0_14 12)
					(= local2 18)
					532
				)
				(613
					(windshield noun: 0 lookStr: 34)
					(proc0_14 1)
					(= local2 24)
					631
				)
				(650
					(windshield noun: 0 lookStr: 35)
					(proc0_14 3)
					(= local2 0)
					651
				)
				(271
					(windshield noun: 0)
					(proc0_14 3)
					(= local2 0)
					529
				)
				(else
					(windshield noun: 0 lookStr: 36)
					(proc0_14 12)
					(= gPrevRoomNum 530)
					(= local2 18)
					532
				)
			)
	)
)

(instance rm531 of SQRoom
	(properties
		picture 531
	)

	(method (init &tmp temp0 temp1 temp2)
		(= local4 gNormalCursor)
		(= gNormalCursor 852)
		(Load rsPIC 529)
		(if (not (IsFlag 21))
			(Load rsPIC 602)
		)
		(gEgo view: 0)
		(super init:)
		(windshield init:)
		(localproc_2 (= local3 gPrevRoomNum))
		(for ((= temp1 0)) (<= temp1 5) ((++ temp1))
			(= [local57 (+ 18 temp1)] [global173 temp1])
		)
		(if (IsFlag 35)
			(for ((= temp1 0)) (<= temp1 5) ((++ temp1))
				(= [local57 (+ 12 temp1)] [global179 temp1])
			)
		)
		(if (and (OneOf gPrevRoomNum 305 376 530) (IsFlag 2))
			(ClearFlag 2)
		)
		(if (>= global128 1)
			(for ((= temp1 0)) (<= temp1 5) ((++ temp1))
				(= [local57 (+ 6 temp1)] [global122 temp1])
			)
		)
		(for ((= temp1 0)) (<= temp1 14) ((++ temp1))
			((= [local8 temp1] (butn new:))
				posn: [local27 (= temp2 (* temp1 2))] [local27 (++ temp2)]
				cel: temp1
				init:
				setPri: 0
				stopUpd:
			)
		)
		(for ((= temp1 0)) (<= temp1 5) ((++ temp1))
			((= [local20 temp1] (theDisplay new:))
				posn: (- 289 (* temp1 7)) 114
				cel: [local57 (+ local2 temp1)]
				init:
			)
		)
		((= local7 (butn new:))
			noun: 0
			lookStr: 1
			posn: 295 148
			cel: 15
			init:
			setPri: 0
			stopUpd:
		)
		(hand init:)
		(rogerHead init:)
		(keyDisplay init:)
		(mainScreen init:)
		(smallCompartment init:)
		(largeCompartment init:)
		(headRest init:)
		(cables init:)
		(entryPad init:)
		(soundFX init:)
		(exitButn init:)
		(restOfPod init:)
		(HandsOn)
		(gUser canControl: 0)
		(gTheIconBar disable: 0 4 5)
		(gGame setCursor: 852 1)
		(gTheIconBar curIcon: (gTheIconBar at: 2))
	)

	(method (newRoom)
		(if (gSounds contains: soundFX)
			(soundFX dispose:)
		)
		(= gNormalCursor local4)
		(super newRoom: &rest)
	)
)

(instance raiseHandS of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame setCursor: 996 1 local5 local6)
				(hand setMotion: MoveTo local5 local6 self)
			)
			(1
				(= local1 1)
				(= cycles 2)
			)
			(2
				(gGame setCursor: 996 1 local5 local6)
				(self dispose:)
			)
		)
	)
)

(instance hand of Sq4Actor
	(properties
		x 300
		y 200
		yStep 15
		view 531
		priority 14
		signal 26640
		illegalBits 0
		xStep 15
	)

	(method (doit &tmp temp0 temp1)
		(cond
			((and (not script) (== ((gTheIconBar curIcon:) message:) 4))
				(= temp0 (gUser curEvent:))
				(if (not (& (temp0 type:) evMOUSE))
					(temp0 localize:)
					(= local5 (temp0 x:))
					(= local6 (temp0 y:))
					(= temp1 (InRect 230 118 308 170 local5 local6))
					(cond
						((and (not local1) temp1)
							(self setScript: raiseHandS)
						)
						(temp1
							(self posn: local5 local6)
						)
						(local1
							(if (> local6 170)
								(self setScript: lowerHandS 0 2)
							else
								(if (< local6 118)
									(= local6 118)
								)
								(= local5
									(cond
										((> local5 308) 308)
										((< local5 230) 230)
										(else local5)
									)
								)
								(gGame setCursor: 996 1 local5 local6)
								(self posn: local5 local6)
							)
						)
					)
				)
			)
			((and (not script) local1)
				(self setScript: lowerHandS 0 1)
			)
		)
		(super doit:)
	)
)

(instance lowerHandS of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(hand setMotion: MoveTo 270 204 self)
			)
			(1
				(= local1 0)
				(if register
					(switch register
						(1
							(gGame setCursor: gTheCursor 1 local5 local6)
						)
						(2
							(gGame setCursor: gNormalCursor 1 local5 175)
						)
					)
					(self dispose:)
				else
					(gGame setCursor: gNormalCursor 1 local5 175)
					(caller cue:)
				)
			)
		)
	)
)

(instance pushAndBackS of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(hand posn: (+ (hand x:) 1) (+ (hand y:) 1))
				(= cycles 6)
			)
			(1
				(hand posn: (- (hand x:) 1) (- (hand y:) 1))
				(gGame setCursor: 996 1 (hand x:) (hand y:))
				(self dispose:)
			)
		)
	)
)

(instance displayMeS of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(gUser canInput: 0)
				(soundFX number: 102 loop: 0 play:)
				(client setPri: 10)
				(= cycles 1)
			)
			(1
				(if (!= ([local20 5] loop:) 4)
					(for ((= temp0 5)) (>= temp0 0) ((-- temp0))
						([local20 temp0] loop: 4)
					)
				else
					(for ((= temp0 4)) (>= temp0 0) ((-- temp0))
						(if (!= ([local20 temp0] loop:) 4)
							([local20 (+ temp0 1)] loop: 2)
							([local20 (+ temp0 1)] cel: ([local20 temp0] cel:))
						)
					)
				)
				([local20 0] loop: 2 cel: (client cel:))
				(= cycles 7)
			)
			(2
				(client setPri: 0)
				(gUser canInput: 1)
				(self dispose:)
			)
		)
	)
)

(instance dudScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(lowerHandS caller: 0)
				(hand setScript: 0)
				(if local0
					(gNarrator say: 5 self) ; "... nothing happens. You're already there, Roger!"
				else
					(gNarrator say: 6 self) ; "Nothing much happens. That must not have been a valid code. Try again!"
				)
			)
			(1
				(for ((= temp0 0)) (<= temp0 5) ((++ temp0))
					([local20 temp0] loop: 4)
				)
				(= cycles 1)
			)
			(2
				(if (!= (gLongSong prevSignal:) -1)
					(gLongSong fade: 0 0 0 1)
				)
				(HandsOff)
				(= cycles 1)
			)
			(3
				(if (!= (gLongSong prevSignal:) -1)
					(-- state)
				)
				(= cycles 1)
			)
			(4
				(= seconds 2)
			)
			(5
				(gGame setCursor: 852 1)
				(gTheIconBar curIcon: (gTheIconBar at: 2))
				(gUser canInput: 1)
				(gTheIconBar enable: 2 3 1)
				(= cycles 2)
			)
			(6
				(if (OneOf local115 15 14 535 19)
					(gLongSong2
						number: local115
						loop: -1
						vol: local116
						flags: 1
						prevSignal: 0
						play:
					)
				)
				(= cycles 1)
			)
			(7
				(self dispose:)
			)
		)
	)
)

(instance timeToTimeWarpS of AudioScript
	(properties)

	(method (doit)
		(super doit: &rest)
		(if register
			(Palette palANIMATE 190 220 -2)
		)
	)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(= register 0)
				(= local115 (gLongSong2 number:))
				(= local116 (gLongSong2 vol:))
				(HandsOff)
				(soundFX number: 102 loop: 0 playBed:)
				(local7 setPri: 10)
				(if (localproc_0 30)
					(heart init: setScript: ILoveLunacyScript)
					(self dispose:)
				else
					(= cycles 2)
				)
			)
			(1
				(cond
					(
						(and
							(localproc_1 0)
							(not local112)
							(not local113)
							(not local114)
						)
						(= local112 1)
					)
					(
						(and
							(localproc_1 6)
							local112
							(not local113)
							(not local114)
						)
						(= local113 1)
					)
					((and (localproc_1 12) local112 local113 (not local114))
						(= local114 1)
					)
					(else
						(= local112 0)
						(= local113 0)
						(= local114 0)
					)
				)
				(= local0
					(cond
						((localproc_0 0) 650)
						((localproc_0 12) 376)
						((localproc_0 18) 530)
						((localproc_0 24)
							(SetScore 86 5)
							613
						)
						((and local112 local113 local114) 271)
						((and (== global128 1) (localproc_0 6))
							(for ((= temp0 0)) (<= temp0 5) ((++ temp0))
								([local20 temp0] loop: 4)
							)
							0
						)
						((and (== global128 1) (!= ([local20 5] loop:) 4))
							(= global128 2)
							(for ((= temp0 0)) (<= temp0 5) ((++ temp0))
								(= [global122 temp0]
									(= [local57 (+ 6 temp0)]
										([local20 temp0] cel:)
									)
								)
							)
							(SetFlag 35)
							(if (> global122 10)
								(= global179 2)
							else
								(= global179 13)
							)
							(for ((= temp0 1)) (<= temp0 5) ((++ temp0))
								(= [global179 temp0] (Random 0 14))
							)
							305
						)
						((and (== global128 0) (!= ([local20 5] loop:) 4))
							(= global128 1)
							(for ((= temp0 0)) (<= temp0 5) ((++ temp0))
								(= [global122 temp0]
									(= [local57 (+ 6 temp0)]
										([local20 temp0] cel:)
									)
								)
							)
							(for ((= temp0 0)) (<= temp0 5) ((++ temp0))
								([local20 temp0] loop: 4)
							)
							0
						)
						((localproc_0 6) 305)
						(else
							(for ((= temp0 0)) (<= temp0 5) ((++ temp0))
								([local20 temp0] loop: 4)
							)
							0
						)
					)
				)
				(hand setScript: lowerHandS self 0)
			)
			(2
				(= seconds 1)
				(gLongSong2 stop:)
			)
			(3
				(HandsOff)
				(local7 setPri: 0)
				(gNarrator modeless: 1 say: 2 self) ; "The powerful quad-quark drives rev to life!"
			)
			(4
				(if (& gMessageMode $0002)
					(= waitForCue 256)
					(dummy init: 531 99 0 3 1)
					(gNarrator modeless: 1 say: 3 self) ; "Time and space bend under the fibrilations of the time rip trans-fluxers. Your adrenalin (and stomach) reel with the hyperbolic hyperbole...!"
				else
					(gNarrator modeless: 1 say: 3 self) ; "Time and space bend under the fibrilations of the time rip trans-fluxers. Your adrenalin (and stomach) reel with the hyperbolic hyperbole...!"
				)
			)
			(5
				(if (and local0 (!= local0 local3))
					(gLongSong
						number: 17
						loop: 0
						vol: 127
						flags: 1
						prevSignal: 0
						play:
					)
				else
					(gLongSong
						number: 16
						loop: 0
						vol: 127
						flags: 1
						prevSignal: 0
						play:
					)
				)
				(= cycles 1)
			)
			(6
				(if (!= (gNarrator ticks:) -1)
					(-- state)
				)
				(= cycles 1)
			)
			(7
				(gNarrator modeless: 0 say: 4 self) ; "And, finally... FINALLY..."
			)
			(8
				(= seconds 0)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(if (and local0 (!= local0 local3))
					(for ((= temp0 0)) (<= temp0 5) ((++ temp0))
						([local20 temp0] hide:)
					)
					(= cycles 2)
					(if (IsFlag 22)
						(ClearFlag 22)
						(SetFlag 8)
						(ClearFlag 10)
						(ClearFlag 11)
						(ClearFlag 13)
						(ClearFlag 12)
						(ClearFlag 20)
						(ClearFlag 19)
						(ClearFlag 30)
						(ClearFlag 23)
						(ClearFlag 30)
						(SetFlag 36)
					)
				else
					(gCurRoom setScript: dudScript)
					(self dispose:)
				)
			)
			(9
				(gCurRoom overlay: 529)
				(= cycles 2)
			)
			(10
				(= temp1 529)
				(= register 1)
				(gLongSong prevSignal: 0)
				(= cycles 1)
			)
			(11
				(if (!= (gLongSong prevSignal:) -1)
					(-- state)
				)
				(= cycles 1)
			)
			(12
				(= register 0)
				(ClearFlag 16)
				(lowerHandS caller: 0)
				(hand setScript: 0)
				(switch local0
					(650
						(gLongSong2
							number: 15
							loop: -1
							vol: 90
							flags: 1
							playBed:
						)
					)
					(613
						(gLongSong2
							number: 14
							vol: 127
							loop: 1
							flags: 1
							playBed:
						)
					)
					(530
						(gLongSong2
							number: 535
							vol: 80
							loop: -1
							flags: 1
							playBed:
						)
					)
					(271
						(gLongSong2 stop:)
						(gLongSong stop:)
					)
					(376
						(gLongSong2
							number: 19
							loop: -1
							vol: 80
							flags: 1
							playBed:
						)
					)
				)
				(if (and local112 local113 local114)
					(gCurRoom newRoom: local0)
				)
				(if (OneOf local0 305 376 530)
					(SetFlag 2)
					(SetFlag 26)
					(gCurRoom newRoom: local0)
				else
					(= local3 local0)
					(localproc_2 local0)
					(HandsOn)
					(gUser canControl: 0)
					(gTheIconBar disable: 0 4 5)
					(for ((= temp0 0)) (<= temp0 5) ((++ temp0))
						([local20 temp0] show:)
					)
					(gUser canInput: 1)
					(self dispose:)
				)
			)
		)
	)
)

(instance exitScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(hand x: 55 y: 189 setLoop: 1 setMotion: MoveTo 37 151 self)
			)
			(1
				(= cycles 3)
			)
			(2
				(soundFX number: 812 loop: 0 play:)
				(hand setMotion: MoveTo 41 151 self)
			)
			(3
				(= cycles 3)
			)
			(4
				(hand setMotion: MoveTo 55 189 self)
			)
			(5
				(gCurRoom newRoom: local3)
			)
		)
	)
)

(instance butn of Sq4Prop
	(properties
		x 247
		y 128
		view 531
		loop 3
		priority 10
		signal 16384
		lookStr 7 ; "It's a button with a strange symbol on it. You vaguely remember these symbols from your fifth grade Time Theory class with crazy Mrs. Drimple."
	)

	(method (cue)
		(super cue: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(gNarrator say: 8) ; "This is a manual keypad. The voice-activated model won't be out until SQ XIV or so."
			)
			(4 ; Do
				(if
					(and
						(not script)
						(not (hand script:))
						(not (gCurRoom script:))
					)
					(if (== cel 15)
						(gCurRoom setScript: timeToTimeWarpS)
					else
						(hand setScript: pushAndBackS)
						(self setScript: displayMeS)
					)
				)
			)
			((OneOf theVerb 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23) 0) ; buckazoid, rope, bomb, rabbit, battery, jar, gum, tank, hintbook, pen, atmCard, plug, cigar, matches, diskette, laptop
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theDisplay of Sq4View
	(properties
		view 531
		loop 2
		priority 10
		lookStr 9 ; "The read-out displays some interesting symbols similiar to those on the keypad. You wonder if these might bear some significance."
	)
)

(instance windshield of Sq4Feature
	(properties)

	(method (onMe param1)
		(return (== (OnControl CONTROL (param1 x:) (param1 y:)) 2))
	)
)

(instance rogerHead of Sq4Feature
	(properties
		lookStr 10 ; "That's your head, Roger. Now use it for something."
	)

	(method (onMe param1)
		(return (== (OnControl CONTROL (param1 x:) (param1 y:)) 4))
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(gNarrator say: 11) ; "You talk to yourself."
			)
			(4 ; Do
				(gNarrator say: 12) ; "Scratching your head doesn't make it work any better. It only loosens unsightly dandruff."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance mainScreen of Sq4Feature
	(properties
		lookStr 13 ; "It's some sort of monitor. Probably used to monitor something or other."
	)

	(method (onMe param1)
		(return (== (OnControl CONTROL (param1 x:) (param1 y:)) 8))
	)
)

(instance keyDisplay of Sq4Feature
	(properties
		lookStr 14 ; "This appears to be the display for the keypad below it."
	)

	(method (onMe param1)
		(return (== (OnControl CONTROL (param1 x:) (param1 y:)) 16))
	)
)

(instance smallCompartment of Sq4Feature
	(properties)

	(method (onMe param1)
		(return (== (OnControl CONTROL (param1 x:) (param1 y:)) 32))
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator say: 15) ; "This is a small panel which provides access to the innards of the time pod. IF you have a 3P-223/4QR access panel wrench, that is."
			)
			(4 ; Do
				(gNarrator say: 16) ; "The small access panel is inaccessible."
			)
			((OneOf theVerb 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23) 0) ; buckazoid, rope, bomb, rabbit, battery, jar, gum, tank, hintbook, pen, atmCard, plug, cigar, matches, diskette, laptop
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance largeCompartment of Sq4Feature
	(properties)

	(method (onMe param1)
		(return (== (OnControl CONTROL (param1 x:) (param1 y:)) 64))
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator say: 17) ; "It's a large compartment that's probably full of instruction manuals, code books, time maps, and the like. Too bad it's also locked."
			)
			(4 ; Do
				(gNarrator say: 18) ; "The large compartment doesn't actually open."
			)
			((OneOf theVerb 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23) 0) ; buckazoid, rope, bomb, rabbit, battery, jar, gum, tank, hintbook, pen, atmCard, plug, cigar, matches, diskette, laptop
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance headRest of Sq4Feature
	(properties)

	(method (onMe param1)
		(return (== (OnControl CONTROL (param1 x:) (param1 y:)) 128))
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator say: 19) ; "A standard time-pod headrest. Not very comfortable, but the regular operators have metal heads, so it's not a concern... for them."
			)
			(4 ; Do
				(gNarrator say: 20) ; "The time pod's headrest is non-adjustable. Evidently, Sequel Police are all the same height."
			)
			((OneOf theVerb 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23) 0) ; buckazoid, rope, bomb, rabbit, battery, jar, gum, tank, hintbook, pen, atmCard, plug, cigar, matches, diskette, laptop
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance cables of Sq4Feature
	(properties)

	(method (onMe param1)
		(return (== (OnControl CONTROL (param1 x:) (param1 y:)) 256))
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator say: 21) ; "Those are unshielded quark power cables. No telling what they're doing to your DNA's genetic structures right now."
			)
			(4 ; Do
				(gNarrator say: 22) ; "You don't want to touch those. You might mutate your fingers."
			)
			((OneOf theVerb 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23) 0) ; buckazoid, rope, bomb, rabbit, battery, jar, gum, tank, hintbook, pen, atmCard, plug, cigar, matches, diskette, laptop
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance entryPad of Sq4Feature
	(properties
		lookStr 24 ; "It's part of the Time/Space Coordinate Entry Unit."
	)

	(method (onMe param1)
		(return (== (OnControl CONTROL (param1 x:) (param1 y:)) 512))
	)
)

(instance exitButn of Sq4Feature
	(properties)

	(method (onMe param1)
		(return (== (OnControl CONTROL (param1 x:) (param1 y:)) 1024))
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator say: 25) ; "That button opens the canopy."
			)
			(4 ; Do
				(if (or (hand script:) (gCurRoom script:))
				else
					(HandsOff)
					(= local1 1)
					(hand setScript: exitScript)
				)
			)
			(6 ; Smell
				(gNarrator say: 26) ; "Placing your proboscus closer to the switch would result in severe quark burns from the unshielded cables. But it might also rid you of those unsightly nose hairs."
			)
			(7 ; Taste
				(gNarrator say: 27) ; "Licking switches is never a good idea unless your into the kind of buzz that causes you to loose all control of your muscle system. This could results in the lose of control of all bodily functions."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance restOfPod of Sq4Feature
	(properties)

	(method (onMe)
		(return 1)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator say: 28) ; "You're sitting inside a time machine, remember?"
			)
			(4 ; Do
				(gNarrator say: 29) ; "The time pod's interior feels smooth and cool to the touch."
			)
			(6 ; Smell
				(gNarrator say: 30) ; "Not only does the time pod look like a used tennis shoe, from the inside, it SMELLS like one, too!"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance soundFX of Sound
	(properties
		number 102
		priority 5
	)
)

(instance frog of Sq4Feature ; UNUSED
	(properties
		nsTop 183
		nsLeft 27
		nsBottom 189
		nsRight 62
		lookStr 37 ; "Blue frogs on my shoulder makes me hap-py..."
	)

	(method (doVerb &tmp temp0)
		(= local2
			(proc816_1
				{Where To?}
				27
				1
				77
				{Time-O-Matic}
				109
				78
				{Estros}
				6
				109
				78
				{Mall}
				12
				109
				78
				{Xenon}
				18
				109
				78
				{Ulence}
				24
				109
				78
				{Ortega}
				0
				109
			)
		)
		(cond
			((and (< global128 2) (== local2 6))
				(proc816_1 531 0)
			)
			((and (< global128 2) (== local2 12))
				(proc816_1 531 1)
			)
			(else
				(for ((= temp0 0)) (<= temp0 5) ((++ temp0))
					([local20 temp0] loop: 2 cel: [local57 (+ local2 temp0)])
				)
				(hand posn: 180 180)
				(gCurRoom setScript: timeToTimeWarpS)
			)
		)
	)
)

(instance heart of Sq4Prop
	(properties
		x 194
		y 131
		view 888
		cel 1
		priority 10
		signal 16400
	)
)

(instance ILoveLunacy of Sq4View
	(properties
		x 194
		y 131
		view 888
		loop 1
		priority 11
		signal 16400
	)
)

(instance ILoveLunacyScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(heart cycleSpeed: 30 setCycle: Fwd)
				(= cycles 2)
			)
			(1
				(local7 setPri: 0)
				(= seconds 3)
			)
			(2
				(ILoveLunacy init:)
				(= seconds 5)
			)
			(3
				(ILoveLunacy dispose:)
				(= cycles 3)
			)
			(4
				(heart hide:)
				(= cycles 2)
			)
			(5
				(gNarrator say: 39) ; "It was the "I Love Lunacy" show! You must have briefly tuned into the electronic entrails of some long-lost civilization."
				(gUser canInput: 1)
				(gTheIconBar enable: 2 3 1)
				(heart dispose:)
			)
		)
	)
)

(instance musicDummy of Script ; UNUSED
	(properties)

	(method (cue)
		(if (OneOf (gLongSong2 number:) 19 535 15)
			(gLongSong2 vol: 80 loop: -1 flags: 1 play:)
		)
	)
)

(instance dummy of ScriptSync
	(properties)
)

