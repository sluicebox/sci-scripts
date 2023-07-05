;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 531)
(include sci.sh)
(use Main)
(use Interface)
(use eRS)
(use Feature)
(use Sound)
(use Motion)
(use User)
(use Actor)
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
	[local7 12]
	[local19 7]
	[local26 30] = [245 129 255 129 265 129 275 129 285 129 245 139 255 139 265 139 275 139 285 139 245 149 255 149 265 149 275 149 285 149]
	[local56 36] = [5 4 3 2 1 0 20 20 20 20 20 20 2 20 20 20 20 20 10 10 10 10 10 10 6 11 1 7 13 9 4 14 6 9 1 11]
)

(procedure (localproc_0 param1)
	(return
		(and
			(== ([local19 0] cel:) [local56 param1])
			(== ([local19 1] cel:) [local56 (++ param1)])
			(== ([local19 2] cel:) [local56 (++ param1)])
			(== ([local19 3] cel:) [local56 (++ param1)])
			(== ([local19 4] cel:) [local56 (++ param1)])
			(== ([local19 5] cel:) [local56 (++ param1)])
		)
	)
)

(procedure (localproc_1 param1 &tmp temp0)
	(gCurRoom
		overlay:
			(switch param1
				(305
					(windshield
						lookStr:
							{Peering through the port you see an unusual land. Although these alterations are much more exaggerated, it's wind-carved pinnacles and buttes bring back memories of the planet Kerona where this whole adventure mess started.}
					)
					(proc0_14 10)
					(= local2 6)
					533
				)
				(376
					(windshield
						lookStr:
							{This looks like some type of arcade where people mindlessly introduce coinage through insatiable slots to go adrenal amidst the electrons via the latest and not-so-late mind-toggling shoot-m-ups and maze games.}
					)
					(proc0_14 10)
					(= local2 12)
					534
				)
				(530
					(windshield
						lookStr:
							{You look out at the city you were born in decades ago. The capital building stands (just barely) with a huge hole in it. You're sure glad you weren't here when it happened. You might've gotten hurt. On the bright side, you won't have to pay those delinquent traffic tickets.}
					)
					(proc0_14 12)
					(= local2 18)
					532
				)
				(613
					(windshield
						lookStr:
							{Memories race through your mind. You know you've seen this place in your distant past. The rather low-res features look exactly like a place you once visited called Ulence Flats.}
					)
					(proc0_14 1)
					(= local2 24)
					631
				)
				(650
					(windshield
						lookStr:
							{This view provides a flashback to a recent adventure. It looks real hot out there. Hot enough for ThermoWeave(tm).}
					)
					(proc0_14 3)
					(= local2 0)
					651
				)
				(else
					(windshield
						lookStr:
							{You look out at the city you were born in decades ago. The capital building stands (just barely) with a huge hole in it. You're sure glad you weren't here when it happened. You might've gotten hurt. On the bright side, you won't have to pay those delinquent traffic tickets.}
					)
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
		(super init:)
		(if (== gPrevRoomNum 815) ; rmProtect
			(= gPrevRoomNum 530)
		)
		(windshield init:)
		(Load rsPIC 529)
		(if (== global105 16)
			(Load rsPIC 602)
		)
		(localproc_1 (= local3 gPrevRoomNum))
		(for ((= temp1 0)) (<= temp1 5) ((++ temp1))
			(= [local56 (+ 18 temp1)] [global173 temp1])
		)
		(if (IsFlag 35)
			(for ((= temp1 0)) (<= temp1 5) ((++ temp1))
				(= [local56 (+ 12 temp1)] [global179 temp1])
			)
		)
		(if (and (OneOf gPrevRoomNum 305 376 530) (IsFlag 2))
			(ClearFlag 2)
		)
		(if (>= global128 1)
			(for ((= temp1 0)) (<= temp1 5) ((++ temp1))
				(= [local56 (+ 6 temp1)] [global122 temp1])
			)
		)
		(for ((= temp1 0)) (<= temp1 14) ((++ temp1))
			((= [local7 temp1] (butn new:))
				posn: [local26 (= temp2 (* temp1 2))] [local26 (++ temp2)]
				cel: temp1
				init:
				setPri: 0
				stopUpd:
			)
		)
		(for ((= temp1 0)) (<= temp1 5) ((++ temp1))
			((= [local19 temp1] (display new:))
				posn: (- 289 (* temp1 7)) 114
				cel: [local56 (+ local2 temp1)]
				init:
			)
		)
		((= local6 (butn new:))
			lookStr:
				{"ENT"? Must be a secret code. Perhaps it means "SELF DESTRUCT" or maybe "CHANGE RETURN"?}
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
		(gEgo view: 0)
		(HandsOn)
		(User canControl: 0)
		(gTheIconBar disable: 0 4 5)
	)

	(method (newRoom)
		(if (gSounds contains: soundFX)
			(soundFX dispose:)
		)
		(super newRoom: &rest)
	)
)

(instance raiseHandS of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(hand setMotion: MoveTo local4 local5 self)
			)
			(1
				(gGame setCursor: 69 1 local4 local5)
				(= local1 1)
				(= cycles 2)
			)
			(2
				(self dispose:)
			)
		)
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
				(gGame setCursor: 20 1 local4 170)
				(if register
					(= local1 0)
					(self dispose:)
				else
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
				(gGame setCursor: 69 1 (hand x:) (hand y:))
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
				(User canInput: 0)
				(soundFX number: 102 loop: 0 play:)
				(client setPri: 10)
				(= cycles 1)
			)
			(1
				(if (!= ([local19 5] loop:) 4)
					(for ((= temp0 5)) (>= temp0 0) ((-- temp0))
						([local19 temp0] loop: 4)
					)
				else
					(for ((= temp0 4)) (>= temp0 0) ((-- temp0))
						(if (!= ([local19 temp0] loop:) 4)
							([local19 (+ temp0 1)] loop: 2)
							([local19 (+ temp0 1)] cel: ([local19 temp0] cel:))
						)
					)
				)
				([local19 0] loop: 2 cel: (client cel:))
				(= cycles 7)
			)
			(2
				(client setPri: 0)
				(User canInput: 1)
				(self dispose:)
			)
		)
	)
)

(instance timeToTimeWarpS of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(soundFX number: 102 loop: 0 playBed:)
				(local6 setPri: 10)
				(if (localproc_0 30)
					(heart init: setScript: ILoveLunacyScript)
					(self dispose:)
				else
					(= cycles 1)
				)
			)
			(1
				(= local0
					(cond
						((localproc_0 0) 650)
						((localproc_0 12) 376)
						((localproc_0 18) 530)
						((localproc_0 24)
							(SetScore 86 5)
							613
						)
						((and (== global128 1) (localproc_0 6))
							(for ((= temp0 0)) (<= temp0 5) ((++ temp0))
								([local19 temp0] loop: 4)
							)
							0
						)
						((and (== global128 1) (!= ([local19 5] loop:) 4))
							(= global128 2)
							(for ((= temp0 0)) (<= temp0 5) ((++ temp0))
								(= [global122 temp0]
									(= [local56 (+ 6 temp0)]
										([local19 temp0] cel:)
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
						((and (== global128 0) (!= ([local19 5] loop:) 4))
							(= global128 1)
							(for ((= temp0 0)) (<= temp0 5) ((++ temp0))
								(= [global122 temp0]
									(= [local56 (+ 6 temp0)]
										([local19 temp0] cel:)
									)
								)
							)
							(for ((= temp0 0)) (<= temp0 5) ((++ temp0))
								([local19 temp0] loop: 4)
							)
							0
						)
						((localproc_0 6) 305)
						(else
							(for ((= temp0 0)) (<= temp0 5) ((++ temp0))
								([local19 temp0] loop: 4)
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
				(local6 setPri: 0)
				(Print 531 0 #dispose #at -1 156) ; "The powerful quad-quark drives rev to life!"
				(if (and local0 (!= local0 local3))
					(gLongSong number: 17 loop: 0 vol: 127 flags: 1 playBed:)
				else
					(gLongSong
						number: 16
						loop: 0
						vol: 127
						flags: 1
						playBed: musicDummy
					)
				)
				(= seconds 2)
			)
			(4
				(Print 531 1 #dispose #at -1 140) ; "Time and space bend under the fibrilations of the time rip trans-fluxers. Your adrenalin (and stomach) reel with the hyperbolic hyperbole...!"
				(= seconds 4)
			)
			(5
				(Print 531 2 #dispose #at -1 150) ; "And, finally... FINALLY..."
				(= seconds 2)
			)
			(6
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(if (and local0 (!= local0 local3))
					(for ((= temp0 0)) (<= temp0 5) ((++ temp0))
						([local19 temp0] hide:)
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
					(User canInput: 1)
					(gTheIconBar enable: 2)
					(gTheIconBar enable: 3)
					(gTheIconBar enable: 1)
					(lowerHandS caller: 0)
					(hand setScript: 0)
					(if local0
						(Print 531 3 #at -1 150) ; "... nothing happens. You're already there, Roger!"
					else
						(Print 531 4 #at -1 140) ; "... nothing much happens. That must not have been a valid code. Even this far into the future controlled time travel has yet to be perfected."
					)
					(gGame setCursor: 20 1 local4 170)
					(for ((= temp0 0)) (<= temp0 5) ((++ temp0))
						([local19 temp0] loop: 4)
					)
					(self dispose:)
				)
			)
			(7
				(gCurRoom overlay: 529)
				(= cycles 1)
			)
			(8
				(= temp1 529)
				(while (!= (gLongSong prevSignal:) -1)
					(gLongSong check:)
					(if (== global105 256)
						(Palette palANIMATE 234 254 -1)
					else
						(Animate 0 0)
						(switch temp1
							(602
								(gCurRoom overlay: (= temp1 529))
							)
							(529
								(gCurRoom overlay: (= temp1 602))
							)
						)
					)
				)
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
				(if (OneOf local0 305 376 530)
					(SetFlag 2)
					(SetFlag 26)
					(gCurRoom newRoom: local0)
				else
					(= local3 local0)
					(localproc_1 local0)
					(HandsOn)
					(User canControl: 0)
					(gTheIconBar disable: 0 4 5)
					(for ((= temp0 0)) (<= temp0 5) ((++ temp0))
						([local19 temp0] show:)
					)
					(User canInput: 1)
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

(instance hand of Actor
	(properties
		x 300
		y 200
		yStep 15
		view 531
		priority 14
		signal 30736
		illegalBits 0
		xStep 15
	)

	(method (doit &tmp temp0 temp1)
		(cond
			((and (not script) (== ((gTheIconBar curIcon:) message:) 3))
				(= temp0 (User curEvent:))
				(if (not (& (temp0 type:) evMOUSE))
					(temp0 localize:)
					(= local4 (temp0 x:))
					(= local5 (temp0 y:))
					(= temp1 (InRect 230 118 308 164 local4 local5))
					(cond
						((and (not local1) temp1)
							(self setScript: raiseHandS)
						)
						(temp1
							(self posn: local4 local5)
						)
						(local1
							(self setScript: lowerHandS 0 1)
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

(instance butn of Prop
	(properties
		x 247
		y 128
		description {button}
		lookStr {It's a button with a strange symbol on it. You vaguely remember these symbols from your fifth grade Time Theory class with crazy Mrs. Drimple. Say now, wasn't that about the time you decided to become a janitor?}
		view 531
		loop 3
		priority 10
		signal 16384
	)

	(method (cue)
		(super cue: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 0) ; Inventory
			(5 ; Talk
				(Print 531 5) ; "This is a manual keypad. The voice-activated model won't be out until SQ XIV or so."
			)
			(3 ; Do
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
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance display of View
	(properties
		description {time/space coordinate}
		lookStr {The read-out displays some interesting symbols similiar to those on the keypad. You wonder if these might bear some significance.}
		view 531
		loop 2
		priority 10
	)
)

(instance windshield of Feature
	(properties
		description {windshield}
	)

	(method (onMe param1)
		(return (== (OnControl CONTROL (param1 x:) (param1 y:)) 2))
	)
)

(instance rogerHead of Feature
	(properties
		description {your head}
		lookStr {That's your head, Roger. Now use it for something.}
	)

	(method (onMe param1)
		(return (== (OnControl CONTROL (param1 x:) (param1 y:)) 4))
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Talk
				(Print 531 6) ; "You talk to yourself."
			)
			(3 ; Do
				(Print 531 7) ; "Scratching your head doesn't make it work any better. It only loosens unsightly dandruff."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance mainScreen of Feature
	(properties
		description {main screen}
		lookStr {It's some sort of monitor. Probably used to monitor something or other.}
	)

	(method (onMe param1)
		(return (== (OnControl CONTROL (param1 x:) (param1 y:)) 8))
	)
)

(instance keyDisplay of Feature
	(properties
		description {keypad display}
		lookStr {This appears to be the display for the keypad below it.}
	)

	(method (onMe param1)
		(return (== (OnControl CONTROL (param1 x:) (param1 y:)) 16))
	)
)

(instance smallCompartment of Feature
	(properties
		description {small access panel}
		lookStr {This is a small panel which provides access to the innards of the time pod. For anyone with a 3P-223/4QR access panel wrench, that is.}
	)

	(method (onMe param1)
		(return (== (OnControl CONTROL (param1 x:) (param1 y:)) 32))
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 0) ; Inventory
			(3 ; Do
				(Print 531 8) ; "The small access panel is inaccessible."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance largeCompartment of Feature
	(properties
		description {large compartment}
		lookStr {It's a large compartment that's probably full of instruction manuals, code books, time maps, and the like. Too bad it's also locked.}
	)

	(method (onMe param1)
		(return (== (OnControl CONTROL (param1 x:) (param1 y:)) 64))
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 0) ; Inventory
			(3 ; Do
				(Print 531 9) ; "The large compartment doesn't actually open."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance headRest of Feature
	(properties
		description {headrest}
		lookStr {A standard time-pod headrest. Not very comfortable, but the regular operators have metal heads, so it's not a concern... for them.}
	)

	(method (onMe param1)
		(return (== (OnControl CONTROL (param1 x:) (param1 y:)) 128))
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 0) ; Inventory
			(3 ; Do
				(Print 531 10) ; "The time pod's headrest is non-adjustable. Evidently, Sequel Police are all the same height."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance cables of Feature
	(properties
		description {power cables}
		lookStr {Those are unshielded quark power cables. No telling what they're doing to your DNA's genetic structures right now.}
	)

	(method (onMe param1)
		(return (== (OnControl CONTROL (param1 x:) (param1 y:)) 256))
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 0) ; Inventory
			(3 ; Do
				(Print 531 11) ; "You don't want to touch those. You might mutate your fingers."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance entryPad of Feature
	(properties
		description {Time/Space Coordinate Entry Unit}
		lookStr {It's part of the TSCEU (Time/Space Coordinate Entry Unit).}
	)

	(method (onMe param1)
		(return (== (OnControl CONTROL (param1 x:) (param1 y:)) 512))
	)
)

(instance exitButn of Feature
	(properties
		description {canopy button}
		lookStr {That button opens the canopy.}
	)

	(method (onMe param1)
		(return (== (OnControl CONTROL (param1 x:) (param1 y:)) 1024))
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(if (or (hand script:) (gCurRoom script:))
				else
					(HandsOff)
					(= local1 1)
					(hand setScript: exitScript)
				)
			)
			(11 ; Smell
				(Print 531 12) ; "Placing your ample proboscus closer to the switch would result in severe quark burns from the unshielded cables below. It might, however, also rid you of those unsightly nose hairs."
			)
			(10 ; Taste
				(Print 531 13) ; "Licking switches is never a good idea unless your into the kind of buzz that causes you to loose all control of your muscle system. This could results in the lose of control of all bodily functions."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance restOfPod of Feature
	(properties
		description {time pod}
		lookStr {You're sitting inside a time machine, remember?}
	)

	(method (onMe)
		(return 1)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 531 14) ; "The time pod's interior feels smooth and cool to the touch."
			)
			(11 ; Smell
				(Print 531 15) ; "Not only does the time pod look like a used tennis shoe, from the inside, it SMELLS like one, too!"
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

(instance frog of Feature ; UNUSED
	(properties
		nsTop 183
		nsLeft 27
		nsBottom 189
		nsRight 62
		description {blue frog}
		lookStr {Blue frogs on my shoulder makes me hap-py...}
	)

	(method (doVerb &tmp temp0)
		(= local2
			(Print ; "Where To?"
				531
				16
				#mode
				1
				#title
				{Time-O-Matic}
				#button
				{Estros}
				6
				#button
				{Mall}
				12
				#button
				{Xenon}
				18
				#button
				{Ulence}
				24
				#button
				{Ortega}
				0
			)
		)
		(cond
			((and (< global128 2) (== local2 6))
				(Print 531 17) ; "Debug - can't cheat for Estros - You need to enter two complete entries - second entry will be Estros' code from now on."
			)
			((and (< global128 2) (== local2 12))
				(Print 531 18) ; "Debug - can't go to the mall before you go to Estros"
			)
			(else
				(for ((= temp0 0)) (<= temp0 5) ((++ temp0))
					([local19 temp0] loop: 2 cel: [local56 (+ local2 temp0)])
				)
				(hand posn: 180 180)
				(gCurRoom setScript: timeToTimeWarpS)
			)
		)
	)
)

(instance heart of Prop
	(properties
		x 194
		y 131
		view 888
		cel 1
		priority 10
		signal 16400
	)
)

(instance ILoveLunacy of View
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
				(heart cycleSpeed: 4 setCycle: Fwd)
				(= cycles 2)
			)
			(1
				(local6 setPri: 0)
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
				(Print 531 19 #at -1 140) ; "It was the "I Love Lunacy" show! You must've briefly tuned into the electronic entrails of some long-lost civilization."
				(User canInput: 1)
				(gTheIconBar enable: 2)
				(gTheIconBar enable: 3)
				(gTheIconBar enable: 1)
				(heart dispose:)
			)
		)
	)
)

(instance musicDummy of Script
	(properties)

	(method (cue)
		(if (OneOf (gLongSong2 number:) 19 535 15)
			(gLongSong2 vol: 80 loop: -1 flags: 1 play:)
		)
	)
)

