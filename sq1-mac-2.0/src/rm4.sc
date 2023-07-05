;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4)
(include sci.sh)
(use Main)
(use Interface)
(use arcadaRegion)
(use eRS)
(use Elevator)
(use Osc)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use DPath)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm4 0
	beginGame 1
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
)

(instance rm4 of SQRoom
	(properties
		picture 4
		east 5
		west 3
	)

	(method (init &tmp [temp0 90])
		(LoadMany rsVIEW 104 4 400)
		(Load rsSOUND 311)
		(= local5 6)
		(gEgo init: setStep: 4 2)
		(body init:)
		(if (== global166 1)
			(self
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 0 0 319 0 319 52 162 78 121 78 103 69 103 48 99 48 99 68 82 77 0 77
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 187 94 319 72 319 189 0 189 0 94
						yourself:
					)
			)
			((ScriptID 700 0) ; arcadaRegion
				sarienEntryDir: 2
				s1startY: 54
				s2startY: 67
				s1gotoX: 229
				s1gotoY: 69
				s2gotoX: 231
				s2gotoY: 85
			)
		else
			(body approachVerbs: 2 3 5) ; Look, Do, Talk
			(if (== gPrevRoomNum 3)
				(gEgo setPri: 3)
			)
			(self
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 0 156 60 156 66 152 112 152 118 158 187 187 319 187 319 189 0 189
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 0 0 319 0 319 160 299 160 297 172 279 172 276 156 260 156 260 172 243 172 233 163 182 163 103 133 0 133
						yourself:
					)
			)
			((ScriptID 700 0) ; arcadaRegion
				sarienEntryDir: 1
				s1startY: 138
				s2startY: 154
				s1gotoX: 88
				s1gotoY: 140
				s2gotoX: 66
				s2gotoY: 155
			)
		)
		(self setRegions: 700) ; arcadaRegion
		((ScriptID 700 0) safeCode: egoSafe) ; arcadaRegion
		(alertSign init: setCycle: Fwd)
		(switch gPrevRoomNum
			(3
				(= style 12)
			)
			(5
				(= style 11)
			)
			(8
				(gEgo posn: 270 164)
				(= style 10)
			)
			(else
				(= style -32759)
				(LoadMany rsSOUND 998 983 309 357)
				(LoadMany rsVIEW 414)
				(gEgo loop: 2 posn: 100 65 heading: 180)
				(if (not gHowFast)
					(= global172 1801)
				else
					(= global172 901)
				)
				(alertSign cel: 0 setCycle: 0)
				(self setScript: beginGame)
			)
		)
		(closetDoor init: stopUpd:)
		(= local0 0)
		(super init:)
		(lowerDoor
			exiting: (== gPrevRoomNum 8)
			light: elevatorLight
			init:
			whereTo: 8
		)
		(if (OneOf gPrevRoomNum west east)
			(HandsOn)
		)
	)

	(method (notify)
		(if (== gPrevRoomNum 8)
			(HandsOff)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(if local1
					(Print
						{That's not possible. It's so dark that you couldn't find your own navel lint. Surely you MUST remember that this was the criteria by which you came to choose this location for your nap... er... work station.}
					)
				else
					(Print 4 0) ; "You're currently loitering on one of the upper deck hallways aboard the Starship Arcada."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (handleEvent event)
		(if
			(and
				(User controls:)
				local1
				(== (gTheIconBar curIcon:) (gTheIconBar at: 0))
				(or (== (event message:) JOY_UP) (& (event type:) $0040)) ; direction
			)
			(self setScript: walkOutCloset)
			(event claimed: 1)
		else
			(super handleEvent: event)
		)
	)

	(method (doit)
		(super doit:)
		(= local4 (gEgo onControl: 1))
		(if (== global166 2)
			(cond
				((< (gEgo x:) 186)
					(if (not (& (gEgo signal:) $0010))
						(gEgo setPri: 3)
					)
				)
				((& $0010 (gEgo signal:))
					(gEgo setPri: -1)
				)
			)
		)
		(cond
			(script 0)
			((and local1 (gEgo mover:))
				(self setScript: walkOutCloset)
			)
			((lowerDoor inFront:)
				(lowerDoor open:)
			)
			((and (& local4 $0002) (not local1))
				(= local1 1)
			)
			((and (gEgo inRect: 50 40 150 99) (& local4 $4000))
				(self setScript: walkInCloset)
			)
		)
	)
)

(instance searchBody of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setHeading: 180 self)
			)
			(1
				(if register
					(Print 4 1 (= state 2)) ; "You frisk the scorched body. Other than carbonized materials, your search reveals nothing. Boy, I hope this isn't becoming a new hobby."
				)
				(gEgo
					view: 4
					loop: (if (< (gEgo x:) ((CueObj client:) x:)) 1 else 0)
					cycleSpeed: 5
					moveSpeed: 5
					cel: register
					setCycle: (if register Beg else End) self
				)
			)
			(2
				(= state 0)
				(= register 3)
				(gEgo
					loop: (+ (gEgo loop:) 2)
					cel: 0
					setCycle: Osc 2 self
				)
			)
			(3
				(HandsOn)
				(= state -1)
				(= register 0)
				(NormalEgo 2 0 60)
				(self dispose:)
			)
		)
	)
)

(instance walkInCloset of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gSoundEffects number: 311 loop: 1 play:)
				(closetDoor startUpd: setCycle: End self)
			)
			(1
				(gSoundEffects stop:)
				(gEgo setMotion: PolyPath 101 54 self)
			)
			(2
				(= local1 1)
				(gSoundEffects number: 311 loop: 1 play:)
				(closetDoor stopUpd: setCycle: Beg self)
			)
			(3
				(gSoundEffects stop:)
				(if (not (proc700_1 556 8))
					(gSoundEffects number: 310 loop: 1 play: self)
				else
					(HandsOn)
					(self dispose:)
				)
			)
			(4
				(Print 4 2) ; "You have just stumbled into a small, dark, and very cluttered utility closet. Many things fall and most of them land on you. It doesn't say much for your cleaning prowess."
				((ScriptID 700 0) rFlag1: (| ((ScriptID 700 0) rFlag1:) $0008)) ; arcadaRegion, arcadaRegion
				(= cycles 6)
			)
			(5
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance walkOutCloset of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gSoundEffects number: 311 loop: 1 play:)
				(closetDoor startUpd: setCycle: End self)
			)
			(1
				(gSoundEffects stop:)
				(gEgo setMotion: MoveTo (gEgo x:) 78 self)
			)
			(2
				(= local1 0)
				(gSoundEffects number: 311 loop: 1 play:)
				(closetDoor stopUpd: setCycle: Beg self)
			)
			(3
				(gSoundEffects stop:)
				(if (not (client isKindOf: Script))
					(HandsOn)
				)
				(self dispose:)
			)
		)
	)
)

(instance beginGame of Script
	(properties)

	(method (init)
		(super init: &rest)
		(gKeyDownHandler addToFront: self)
		(gMouseDownHandler addToFront: self)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event)
		(if (and register (event type:))
			(if gModelessDialog
				(gModelessDialog seconds: 0 caller: 0 dispose:)
			)
			(= register 0)
			(= cycles 1)
			(event claimed: 1)
		)
	)

	(method (doit &tmp temp0)
		(super doit:)
		(gEgo moveHead: (not local2))
		(if local2
			(cond
				((< (panicDroid x:) 90)
					((gEgo _head:) cel: 5)
				)
				((> (panicDroid x:) 110)
					((gEgo _head:) cel: 2)
				)
				(else
					((gEgo _head:) cel: 4)
				)
			)
		)
	)

	(method (changeState newState &tmp [temp0 150])
		(switch (= state newState)
			(0
				(gTheIconBar enable:)
				(HandsOff)
				((ScriptID 700 0) cartNumber: (Random 1 5)) ; arcadaRegion
				(= global184
					(+
						(* (Random 1 9) 1000)
						(* (Random 1 9) 100)
						(* (Random 1 9) 10)
						(* (Random 1 9) 1)
					)
				)
				(= cycles 12)
			)
			(1
				(gLongSong number: 307 loop: -1 flags: 1 play:)
				(alertSign setCycle: Fwd)
				(= global166 1)
				(= local1 1)
				(= seconds 3)
			)
			(2
				(self setScript: walkOutCloset self)
			)
			(3
				(= seconds 2)
			)
			(4
				(if (< (gGame detailLevel:) (alertSign detailLevel:))
					(alertSign setCycle: 0)
				)
				(ShakeScreen 3 (Random 1 3))
				(gLongSong number: 339 loop: 1 play: self)
			)
			(5
				(= local2 1)
				(HandsOn)
				(gTheIconBar disable: 0 2 3 4 5 6 7)
				(panicDroid init: setCycle: Fwd)
				(gLongSong number: 300 loop: -1 play:)
			)
			(6
				(HandsOff)
				(gTheIconBar curIcon: (gTheIconBar at: 0))
				(= local2 0)
				(Print 4 3) ; "You're startled by the sound of an alarm. Breaking through it, the intercom crackles with the frightened voice of a technician shouting that the Arcada has been boarded by unknown intruders. The transmission ends abruptly in a soundstorm of white noise, soon overtaken by the cold din of silence."
				(= cycles 3)
			)
			(7
				(Format @temp0 4 4 (/ global172 60)) ; "You hear the overly cheerful voice of the ship's computer say: "Destruct sequence is engaged! %d minutes till detonation.""
				(Print @temp0 #mode 1 #at 123 24 #dispose)
				(gLongSong2 number: 309 loop: 1 play: self)
			)
			(8
				(= seconds 0)
				((ScriptID 700 0) ; arcadaRegion
					inGame: 1
					rFlag1: (| ((ScriptID 700 0) rFlag1:) $0004) ; arcadaRegion
				)
			)
			(9
				(if gModelessDialog
					(gModelessDialog caller: self seconds: 10)
				)
				(= register 1)
				0
			)
			(10
				(= register 0)
				(= cycles 1)
			)
			(11
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance egoSafe of Code
	(properties)

	(method (doit)
		(return
			(or (lowerDoor busy:) (!= global166 global173) (& local4 local5))
		)
	)
)

(instance elevatorLight of View
	(properties
		description {elevator light}
		sightAngle 45
		view 104
		loop 2
	)

	(method (doVerb theVerb)
		(if (== global166 2)
			(switch theVerb
				(2 ; Look
					(Print 4 5) ; "The light is off. Were it on, you'd notice something called illumination."
				)
				(12 ; Smell
					(Print 4 6) ; "The sign would yield no smell even if you did have the energy to find a step ladder (which you don't)."
				)
				(11 ; Taste
					(Print 4 6) ; "The sign would yield no smell even if you did have the energy to find a step ladder (which you don't)."
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		else
			(Print {You aren't on that level.})
		)
	)
)

(instance body of View
	(properties
		x 88
		y 158
		description {body}
		sightAngle 45
		approachX 97
		approachY 153
		view 400
		priority 14
		signal 16401
	)

	(method (doVerb theVerb invItem)
		(if (== global166 2)
			(switch theVerb
				(2 ; Look
					(Print 4 7) ; "This is Stuart, one of your crewmates. He appears to be non-functional. You used to kid him about it when he was alive but now it's true."
				)
				(3 ; Do
					(cond
						(local1
							(Print 4 8) ; "You have to come out of the closet first."
						)
						((!= global166 2)
							(Print 4 9) ; "Though you look like a cartoon character, you're not Stretchman."
						)
						(else
							(gCurRoom setScript: searchBody)
						)
					)
				)
				(5 ; Talk
					(Print 4 10) ; "Funny, no response."
				)
				(12 ; Smell
					(Print 4 11) ; "On second thought, maybe you shouldn't wipe your nose on Stuart's clothes."
				)
				(11 ; Taste
					(Print 4 12) ; "Oh, that's really sick. You really should seek professional help."
				)
				(4 ; Inventory
					(switch invItem
						(10 ; buckazoid
							(Print 4 13) ; "It's unlikely Stuart will be spending any money in the forseeable future."
						)
						(0 ; Cartridge
							(Print 4 14) ; "Stuart was never much help to you, but now he's ignoring you entirely."
						)
						(1 ; keyCard
							(Print 4 15) ; "Stuart doesn't plan to use one of the special elevators anytime soon."
						)
						(15 ; Widget
							(Print 4 16) ; "You wave the widget over Stuart's body. He's still dead."
						)
						(2 ; Gadget
							(Print 4 17) ; "Even using the translator gadget, you can't communicate with Stuart. He's still dead."
						)
						(else
							(super doVerb: theVerb invItem)
						)
					)
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		else
			(Print {You aren't on that level.})
		)
	)
)

(instance lowerDoor of Elevator
	(properties
		x 269
		y 167
		description {elevator door}
		sightAngle 45
		view 104
		loop 1
		cycleSpeed 4
		level 2
	)

	(method (doVerb theVerb)
		(if (== global166 2)
			(switch theVerb
				(2 ; Look
					(Print 4 18) ; "This is an elevator to one of the lower levels."
				)
				(12 ; Smell
					(Print 4 19) ; "Pressing your nose to the elevator door merely serves to cool off your nostril hairs. The door has no fragrance."
				)
				(11 ; Taste
					(Print 4 20) ; "People are going to start wondering about you if you keep applying your tongue to unusual places."
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		else
			(Print {You aren't on that level.})
		)
	)
)

(instance closetDoor of Prop
	(properties
		x 101
		y 68
		description {closet}
		sightAngle 90
		view 104
		priority 3
		signal 16400
		cycleSpeed 8
	)

	(method (doVerb theVerb)
		(if (== global166 1)
			(switch theVerb
				(2 ; Look
					(if local1
						(Print 4 21) ; "Nothing is visible because of the darkness in here. It's one of the reasons that this is your favorite room aboard the Arcada."
					else
						(Print 4 22) ; "This is the access device to your favorite area of the ship - the closet."
					)
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		else
			(Print {You aren't on that level.})
		)
	)
)

(instance alertSign of Prop
	(properties
		x 40
		y 46
		description {warning light}
		sightAngle 90
		view 104
		loop 3
		cycleSpeed 8
		detailLevel 2
	)

	(method (doVerb theVerb)
		(if (== global166 1)
			(switch theVerb
				(2 ; Look
					(if local1
						(Print 4 21) ; "Nothing is visible because of the darkness in here. It's one of the reasons that this is your favorite room aboard the Arcada."
					else
						(Print 4 23) ; "The light's flashing. Hmm, let's see...That seems to ring a distant bell. Oh yeah, now you remember! It means that all living things now aboard the ship could die due to some disastrous situation that currently exists. Whatever the case, some personal hide preservation is in order."
					)
				)
				(3 ; Do
					(Print 4 24) ; "Since the sign is recessed into the wall you can do nothing with it. A nice, distinct hand print now remains on the alert sign."
				)
				(12 ; Smell
					(Print 4 25) ; "You take a whiff and notice a smell common to electronics which haven't had power applied to them in a quite a while."
				)
				(11 ; Taste
					(Print 4 26) ; "Boy, was that a bad idea. Your tongue now bears the residue left behind by adventurers who, like yourself, have shown a need to press various and sundry organs against the sign."
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		else
			(Print {You aren't on that level.})
		)
	)
)

(instance panicDroid of Actor
	(properties
		x 337
		y 57
		description {panicking droid}
		lookStr {A somewhat spastic research droid blows by in a tizz. Perhaps you could provide some relaxation therapy instruction to reduce its level of tension.}
		yStep 6
		view 414
		cycleSpeed 5
		xStep 10
		moveSpeed 4
	)

	(method (doit &tmp temp0 temp1 temp2)
		(super doit:)
		(if (< (= temp0 (Abs (- (panicDroid x:) (gEgo x:)))) 0)
			(= temp0 0)
		)
		(if (> temp0 90)
			(= temp0 90)
		)
		(if
			(>
				(= temp1 (Abs (- (+ (- (gEgo x:) (panicDroid x:)) 63) 127)))
				127
			)
			(= temp1 127)
		)
		(if (< temp1 0)
			(= temp1 0)
		)
		(gLongSong2
			send: 7 10 temp1
			send: 8 10 temp1
			send: 9 10 temp1
			send: 11 10 temp1
			setVol: (- 127 temp0)
		)
		(if (< (- x (gEgo x:)) 0)
			(if (< (-= local3 6) -512)
				(= local3 -512)
			)
			(gLongSong2
				send: 7 224 local3
				send: 8 224 local3
				send: 9 224 local3
				send: 11 224 local3
			)
		)
	)

	(method (init)
		(super init: &rest)
		(gLongSong2 number: 357 loop: -1 play: 0)
		(self setLoop: 0 ignoreActors: 1 setMotion: DPath 159 89 -27 89 self)
	)

	(method (dispose)
		(gLongSong2 loop: 0 stop:)
		(super dispose:)
	)

	(method (cue)
		(beginGame cue:)
		(self dispose:)
	)
)

