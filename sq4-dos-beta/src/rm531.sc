;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 531)
(include sci.sh)
(use Main)
(use Interface)
(use SQRoom)
(use Feature)
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
	[local26 30] = [247 128 257 128 266 128 275 128 284 128 247 137 256 137 265 137 275 137 284 137 246 147 256 147 265 147 275 147 284 147]
	[local56 30] = [5 4 3 2 1 0 20 20 20 20 20 20 11 7 4 5 14 0 12 8 2 6 3 10 6 11 1 7 13 9]
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

(procedure (localproc_1 param1)
	(gCurRoom
		overlay:
			(switch param1
				(305
					(windshield
						lookStr:
							{Peering through the port you see an unusual land. Although these alterations are much more exaggerated, it's wind-carved pinnacles and buttes bring back memories of the planet Kerona where this whole adventure mess started.}
					)
					(= local2 6)
					533
				)
				(376
					(windshield
						lookStr:
							{This looks like some type of arcade where people mindlessly introduce coinage through insatiable slots to go adrenal amidst the electrons via the latest and not-so-late mind-toggling shoot-m-ups and maze games.}
					)
					(= local2 12)
					534
				)
				(530
					(windshield
						lookStr:
							{You look out at the city you were born in decades ago. The capital building stands (just barely) with a huge hole in it. You're sure glad you weren't here when it happened. You might've gotten hurt. On the bright side, you won't have to pay those delinquent traffic tickets.}
					)
					(= local2 18)
					532
				)
				(613
					(windshield
						lookStr:
							{Memories race through your mind. You know you've seen this place in your distant past. The rather low-res features look exactly like a place you once visited called Ulence Flats.}
					)
					(= local2 24)
					631
				)
				(650
					(windshield
						lookStr:
							{This view provides a flashback to a recent adventure. It looks real hot out there. Hot enough for ThermoWeave(tm).}
					)
					(= local2 0)
					532
				)
				(else
					(windshield
						lookStr:
							{You look out at the city you were born in decades ago. The capital building stands (just barely) with a huge hole in it. You're sure glad you weren't here when it happened. You might've gotten hurt. On the bright side, you won't have to pay those delinquent traffic tickets.}
					)
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
		(windshield init:)
		(localproc_1 (= local3 gPrevRoomNum))
		(if (and (OneOf gPrevRoomNum 305 376 530) (IsFlag 2))
			(ClearFlag 2)
		)
		(if (>= global128 2)
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
		((= local6 (butn new:)) posn: 295 147 cel: 15 init: setPri: 0 stopUpd:)
		(hand init:)
		(rogerHead init:)
		(keyDisplay init:)
		(mainScreen init:)
		(smallCompartment init:)
		(largeCompartment init:)
		(headRest init:)
		(cables init:)
		(entryPad init:)
		(exitButn init:)
		(restOfPod init:)
		(HandsOn)
		(User canControl: 0)
		(gIconBar disable: 0 2 3 6)
		(Load rsSOUND 14)
	)
)

(instance raiseHandS of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(hand setMotion: MoveTo local4 (+ local5 10) self)
			)
			(1
				(gGame setCursor: 69 1 local4 (+ local5 10))
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
				(gGame setCursor: gNormalCursor (HaveMouse) local4 (+ local5 10))
				(= local1 0)
				(self dispose:)
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
				(client setPri: 10)
				(= cycles 1)
			)
			(1
				(if (!= ([local19 5] loop:) 3)
					(for ((= temp0 5)) (>= temp0 0) ((-- temp0))
						([local19 temp0] loop: 3)
					)
				else
					(for ((= temp0 4)) (>= temp0 0) ((-- temp0))
						(if (!= ([local19 temp0] loop:) 3)
							([local19 (+ temp0 1)] loop: 1)
							([local19 (+ temp0 1)] cel: ([local19 temp0] cel:))
						)
					)
				)
				([local19 0] loop: 1 cel: (client cel:))
				(= cycles 7)
			)
			(2
				(client setPri: 0)
				(self dispose:)
			)
		)
	)
)

(instance timeToTimeWarpS of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(local6 setPri: 10)
				(= cycles 1)
			)
			(1
				(= local0
					(cond
						((localproc_0 0) 650)
						((localproc_0 12) 376)
						((localproc_0 18) 530)
						((localproc_0 24) 613)
						((and (== global128 1) (localproc_0 6))
							(for ((= temp0 0)) (<= temp0 5) ((++ temp0))
								([local19 temp0] loop: 3)
							)
							0
						)
						((and (== global128 0) (!= ([local19 5] loop:) 3))
							(= global128 1)
							(for ((= temp0 0)) (<= temp0 5) ((++ temp0))
								(= [global122 temp0]
									(= [local56 (+ 6 temp0)]
										([local19 temp0] cel:)
									)
								)
							)
							(for ((= temp0 0)) (<= temp0 5) ((++ temp0))
								([local19 temp0] loop: 3)
							)
							0
						)
						((and (== global128 1) (!= ([local19 5] loop:) 3))
							(= global128 2)
							(for ((= temp0 0)) (<= temp0 5) ((++ temp0))
								(= [global122 temp0]
									(= [local56 (+ 6 temp0)]
										([local19 temp0] cel:)
									)
								)
							)
							305
						)
						((localproc_0 6) 305)
						(else
							(for ((= temp0 0)) (<= temp0 5) ((++ temp0))
								([local19 temp0] loop: 3)
							)
							0
						)
					)
				)
				(= cycles 3)
			)
			(2
				(local6 setPri: 0)
				(= cycles 2)
			)
			(3
				(if (and local0 (!= local0 local3))
					(for ((= temp0 0)) (<= temp0 5) ((++ temp0))
						([local19 temp0] hide:)
					)
					(= register 200)
					(= cycles 1)
				else
					(for ((= temp0 0)) (<= temp0 5) ((++ temp0))
						([local19 temp0] loop: 3)
					)
					(if local0
						(Print 531 0) ; "Nothing happens. You're already there, Roger."
					else
						(Print 531 1) ; "Nothing happens."
					)
					(self dispose:)
				)
			)
			(4
				(gCurRoom overlay: 529)
				(= cycles 1)
			)
			(5
				(while (-- register)
					(Palette palANIMATE 234 254 -1)
				)
				(switch local0
					(650
						(gLongSong number: 15 loop: -1 vol: 90 playBed:)
					)
					(613
						(gLongSong number: 14 vol: 127 loop: 1 playBed:)
					)
				)
				(if (OneOf local0 305 376 530)
					(SetFlag 2)
					(SetFlag 28)
					(gCurRoom newRoom: local0)
				else
					(= local3 local0)
					(localproc_1 local0)
					(= cycles 1)
					(for ((= temp0 0)) (<= temp0 5) ((++ temp0))
						([local19 temp0] show:)
					)
					(self dispose:)
				)
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

	(method (doit &tmp temp0)
		(cond
			((and (not script) (== ((gIconBar curIcon:) message:) 4))
				(= temp0 (User curEvent:))
				(if (not (& (temp0 type:) $0007)) ; evMOUSEKEYBOARD | evMOUSERELEASE
					(GlobalToLocal temp0)
					(= local4 (temp0 x:))
					(= local5 (temp0 y:))
					(cond
						(
							(and
								(not local1)
								(InRect 230 108 308 154 local4 local5)
							)
							(self setScript: raiseHandS)
						)
						((InRect 230 108 308 154 local4 local5)
							(self posn: local4 (+ local5 10))
						)
						(local1
							(self setScript: lowerHandS)
						)
					)
				)
			)
			((and (not script) local1)
				(self setScript: lowerHandS)
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
		loop 2
		priority 10
		signal 16384
	)

	(method (cue)
		(super cue: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 0) ; Inventory
			(5 ; Talk
				(Print 531 2) ; "This is a manual keypad. The voice-activated model won't be out until SQ VIII or so."
			)
			(4 ; Do
				(if (and (not script) (not (hand script:)))
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
		lookStr {Just one of the time/space coordinates on the display.}
		view 531
		loop 1
		priority 10
	)
)

(instance windshield of Feature
	(properties
		description {windshield}
		lookStr {HOOK - What you see out the window msg goes here.}
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
			(6 0) ; Inventory
			(5 ; Talk
				(Print 531 3) ; "You talk to yourself."
			)
			(4 ; Do
				(Print 531 4) ; "Scratching your head doesn't make it work any better. It only loosens unsightly dandruff."
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
		lookStr {It's a rerun of "I Love Lunacy"}
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
		lookStr {This is a small panel which provides access to the innards of the time pod. For anyone with a 3P-223/4QR access panel access wrench, that is.}
	)

	(method (onMe param1)
		(return (== (OnControl CONTROL (param1 x:) (param1 y:)) 32))
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 0) ; Inventory
			(4 ; Do
				(Print 531 5) ; "The small access panel is inaccessable."
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
		lookStr {It's a large compartment, probably full of instruction manuals, code books, time maps, and the like.__But, you'll probably never know, since it's locked.}
	)

	(method (onMe param1)
		(return (== (OnControl CONTROL (param1 x:) (param1 y:)) 64))
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 0) ; Inventory
			(4 ; Do
				(Print 531 6) ; "The large compartment doesn't actually open."
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
			(6 0) ; Inventory
			(4 ; Do
				(Print 531 7) ; "The time pod's headrest is non-adjustable. Evidently, Sequel Police are all the same height."
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
		lookStr {Those are unshielded quark power cables. No telling what they're doing to your genetic DNA structures right now.}
	)

	(method (onMe param1)
		(return (== (OnControl CONTROL (param1 x:) (param1 y:)) 256))
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 0) ; Inventory
			(4 ; Do
				(Print 531 8) ; "You don't want to touch those. You might mutate your fingers."
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
			(6 0) ; Inventory
			(4 ; Do
				(if (== local3 650)
					(Print 531 9) ; "You don't want to go out THERE! Your thermoweave underwear ran out of power long ago."
				else
					(gCurRoom newRoom: local3)
				)
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
)

