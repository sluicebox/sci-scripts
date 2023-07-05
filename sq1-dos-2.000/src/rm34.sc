;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 34)
(include sci.sh)
(use Main)
(use Interface)
(use DScript)
(use Osc)
(use Feature)
(use LoadMany)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm34 0
)

(local
	local0
	local1
	local2
)

(instance rm34 of Rm
	(properties
		picture 99
	)

	(method (init &tmp temp0)
		(LoadMany rsSOUND 422 431 419)
		(LoadMany rsVIEW 24)
		(HandsOff)
		(gLongSong fade: loop: 0)
		(holodude init:)
		(super init:)
		(gEgo init: x: 180 y: 225)
		(NormalEgo 3 1 61)
		(self setScript: startUp)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 34 0) ; "It's pretty darn dark in here."
			)
			(3 ; Do
				(Print 34 1) ; "There's not much you can do to it ."
			)
			(5 ; Talk
				(Print 34 2) ; "Your words go unnoticed."
			)
			(12 ; Smell
				(Print 34 3) ; "The place smells electric."
			)
			(11 ; Taste
				(Print 34 4) ; "Go around licking rooms of others and you won't be getting invited back anywhere."
			)
			(4 ; Inventory
				(switch invItem
					(8 ; Orat_Part
						(gEgo setScript: egoDropOratPart)
					)
					(5 ; Dehydrated_Water
						(Print 34 5) ; "It's a hologram, pinhead - it doesn't need water."
					)
					(else
						(Print 34 6) ; "This isn't the object he wants to receive from you."
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance startUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(gEgo setMotion: MoveTo 180 175 self)
			)
			(2
				(= cycles 9)
			)
			(3
				(if (not (IsFlag 6))
					(Print 34 7 #at 10 80 #width 100) ; "As soon as you enter the room, you find yourself surrounded by darkness. Suddenly, you become aware of the fact that you cannot move or speak. A strange, unknown force has taken over."
					(Print 34 8 #at 10 80 #width 100) ; "A massive holographic image appears before you."
				)
				(= cycles 6)
			)
			(4
				(gLongSong
					number:
						(cond
							((and (gEgo has: 8) (IsFlag 48)) 434) ; Orat_Part
							((and (IsFlag 48) (not (gEgo has: 8))) 422) ; Orat_Part
							(else 431)
						)
					loop: -1
					play:
				)
				(gCurRoom overlay: 434 100)
				(= cycles 20)
			)
			(5
				(gCurRoom overlay: 334 100)
				(= cycles 20)
			)
			(6
				(gCurRoom overlay: 234 100)
				(= cycles 20)
			)
			(7
				(gCurRoom overlay: 134 100)
				(= cycles 20)
			)
			(8
				(gCurRoom drawPic: 34)
				(holoMouth init:)
				(= cycles 20)
			)
			(9
				(UnLoad 129 434)
				(UnLoad 129 334)
				(UnLoad 129 234)
				(UnLoad 129 134)
				(holoEyes init: setCycle: Fwd)
				(cond
					((IsFlag 49)
						(if (IsFlag 48)
							(self setScript: translatorOn2 self)
						else
							(self setScript: translatorOff2 self)
						)
					)
					((IsFlag 48)
						(self setScript: translatorOn1 self)
					)
					(else
						(self setScript: translatorOff1 self)
					)
				)
			)
			(10 0)
		)
	)
)

(instance translatorOn1 of DScript
	(properties)

	(method (restore)
		(super restore: &rest)
		(= local1 0)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Print 34 9 #at 10 80 #width 100) ; "It begins to speak ...."
				(= cycles 3)
			)
			(1
				(self
					save1:
						(Display ; "So, you have found your way to my hallowed chamber. Fortunately there is much more to you than meets the eye."
							34
							10
							dsALIGN
							alCENTER
							dsFONT
							0
							dsWIDTH
							150
							dsCOORD
							10
							40
							dsCOLOR
							global137
							dsSAVEPIXELS
						)
				)
				(= seconds 8)
			)
			(2
				(self restore:)
				(= seconds 2)
			)
			(3
				(self
					save1:
						(Display ; "I have been monitoring your travels on our planet. It appears that you are up the proverbial estuary without a means of locomotion."
							34
							11
							dsALIGN
							alCENTER
							dsFONT
							0
							dsWIDTH
							150
							dsCOORD
							10
							40
							dsCOLOR
							global137
							dsSAVEPIXELS
						)
				)
				(= seconds 8)
			)
			(4
				(self restore:)
				(= seconds 2)
			)
			(5
				(Print 34 12) ; "In other words, you're on the leather express, slapping the dogs, pounding the sand, you'd kill for a fine ride."
				(= cycles 2)
			)
			(6
				(self
					save1:
						(Display ; "You are obviously in need of transportation."
							34
							13
							dsALIGN
							alCENTER
							dsFONT
							0
							dsWIDTH
							150
							dsCOORD
							10
							40
							dsCOLOR
							global137
							dsSAVEPIXELS
						)
				)
				(= seconds 6)
			)
			(7
				(self restore:)
				(= seconds 2)
			)
			(8
				(self
					save1:
						(Display ; "Let us see if you are worthy of our assistance."
							34
							14
							dsALIGN
							alCENTER
							dsFONT
							0
							dsWIDTH
							150
							dsCOORD
							10
							40
							dsCOLOR
							global137
							dsSAVEPIXELS
						)
				)
				(= seconds 6)
			)
			(9
				(self restore:)
				(= seconds 2)
			)
			(10
				(self
					save1:
						(Display ; "On the surface lives a beast called Orat. He proves to be a bit of an annoyance on occasion. Dispose of him and bring back evidence of your conquest. Only then will I deal with your plight. Good luck, strange one."
							34
							15
							dsALIGN
							alCENTER
							dsFONT
							0
							dsWIDTH
							150
							dsCOORD
							10
							40
							dsCOLOR
							global137
							dsSAVEPIXELS
						)
				)
				(= seconds 13)
			)
			(11
				(self restore:)
				(= seconds 2)
			)
			(12
				(self
					save1:
						(Display ; "Bring to me evidence of the beast Orat's demise and we'll talk."
							34
							16
							dsALIGN
							alCENTER
							dsFONT
							0
							dsWIDTH
							150
							dsCOORD
							10
							40
							dsCOLOR
							global137
							dsSAVEPIXELS
						)
				)
				(= seconds 6)
			)
			(13
				(self restore:)
				(= cycles 6)
				(SetFlag 6)
				(SetFlag 49)
			)
			(14
				(if (gEgo has: 8) ; Orat_Part
					(= seconds 10)
					(HandsOn)
					(User canControl: 0)
					(gTheIconBar disable: 0)
				else
					(Print 34 17 #at 10 80 #width 100) ; "With that, you find yourself transported back to the surface."
					(gCurRoom newRoom: 22)
					(self dispose:)
				)
			)
			(15
				(if (= local2 0)
					(Print 34 18 #at 10 80 #width 100) ; "With that you find yourself being transported back to the surface."
					(gCurRoom newRoom: 22)
				)
				(self dispose:)
			)
		)
	)
)

(instance translatorOff1 of DScript
	(properties)

	(method (restore)
		(super restore: &rest)
		(= local1 0)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Print 34 19 #at 10 80 #width 100) ; "It begins to speak ...."
				(= cycles 3)
			)
			(1
				(self
					save1:
						(Display ; "Z jo jb! lvoo sd fj?"
							34
							20
							dsALIGN
							alCENTER
							dsFONT
							0
							dsWIDTH
							150
							dsCOORD
							10
							40
							dsCOLOR
							global137
							dsSAVEPIXELS
						)
				)
				(= seconds 4)
			)
			(2
				(self restore:)
				(= seconds 2)
			)
			(3
				(self
					save1:
						(Display ; "Jow wfiemss ekk wkkedkl ll ewlwl lqqfr fo slljnccv kwetsdlk?"
							34
							21
							dsALIGN
							alCENTER
							dsFONT
							0
							dsWIDTH
							150
							dsCOORD
							10
							40
							dsCOLOR
							global137
							dsSAVEPIXELS
						)
				)
				(= seconds 5)
			)
			(4
				(self restore:)
				(= seconds 2)
			)
			(5
				(self
					save1:
						(Display ; "Owr rjn maj jwwj? Pprdf rph pttqpt?"
							34
							22
							dsALIGN
							alCENTER
							dsFONT
							0
							dsWIDTH
							150
							dsCOORD
							10
							40
							dsCOLOR
							global137
							dsSAVEPIXELS
						)
				)
				(= seconds 5)
			)
			(6
				(self restore:)
				(= seconds 2)
			)
			(7
				(self
					save1:
						(Display ; "wpfi, iw? Der op oio fr tnm dcv ermiyn lk mnb weevxmqyhj em tae."
							34
							23
							dsALIGN
							alCENTER
							dsFONT
							0
							dsWIDTH
							150
							dsCOORD
							10
							40
							dsCOLOR
							global137
							dsSAVEPIXELS
						)
				)
				(= seconds 5)
			)
			(8
				(self restore:)
				(= seconds 2)
			)
			(9
				(Print 34 24 #at 10 80 #width 100) ; "As an apparent result of your inability to understand the alien tongue, the being has sent you back to the surface. You need some kind of help with that."
				(= cycles 3)
			)
			(10
				(gCurRoom newRoom: 22)
				(SetFlag 6)
				(self dispose:)
			)
		)
	)
)

(instance translatorOn2 of DScript
	(properties)

	(method (restore)
		(super restore: &rest)
		(= local1 0)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Print 34 25 #at 10 80 #width 100) ; "Again, the massive holographic image appears before you."
				(= cycles 3)
			)
			(1
				(self
					save1:
						(Display ; "So, you have returned. Do you have proof of the destruction of Orat? If so drop it before me."
							34
							26
							dsALIGN
							alCENTER
							dsFONT
							0
							dsWIDTH
							150
							dsCOORD
							10
							40
							dsCOLOR
							global137
							dsSAVEPIXELS
						)
				)
				(= seconds 3)
			)
			(2
				(if (gEgo has: 8) ; Orat_Part
					(= seconds 6)
					(HandsOn)
					(User canControl: 0)
					(gTheIconBar disable: 0)
				else
					(Print 34 27 #at 10 80 #width 100) ; "Due to your apparent failure to respond properly, you find yourself transported back to the surface."
					(gCurRoom newRoom: 22)
					(self dispose:)
				)
			)
			(3
				(self restore:)
				(= cycles 6)
			)
			(4
				(if (= local2 0)
					(Print 34 28 #at 10 80 #width 100) ; "You find yourself transported back to the surface."
					(gCurRoom newRoom: 22)
				)
			)
		)
	)
)

(instance translatorOff2 of DScript
	(properties)

	(method (restore)
		(super restore: &rest)
		(= local1 0)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Print 34 25) ; "Again, the massive holographic image appears before you."
				(= cycles 3)
			)
			(1
				(self
					save1:
						(Display ; "Dr, hgi hnhht hjutn. Kdfdrnlo ghfhr bb rhytt thrt ii mys aawr vcvvf xxc cdd."
							34
							29
							dsALIGN
							alCENTER
							dsFONT
							0
							dsWIDTH
							150
							dsCOORD
							10
							40
							dsCOLOR
							global137
							dsSAVEPIXELS
						)
				)
				(= seconds 3)
			)
			(2
				(self restore:)
				(= cycles 6)
			)
			(3
				(Print 34 30) ; "As an apparent result of your inability to understand the alien tongue, the being has sent you back to the surface. You need some kind of help with that. Something's not right."
				(gCurRoom newRoom: 22)
			)
		)
	)
)

(instance egoDropOratPart of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local2 1)
				(= cycles 3)
				(= local0 1)
			)
			(1
				(gEgo view: 24 cel: 0 cycleSpeed: 10 setCycle: CT 4 1 self)
			)
			(2
				(gSoundEffects number: 419 loop: 0 play:)
				(gEgo put: 8 34 setCycle: End self) ; Orat_Part
			)
			(3
				(Print 34 31 #at 10 80 #width 100) ; "You drop the Orat part to the ground. The vision is silent as the dainty morsel SPLATs to the dry soil. You are startled by a rumbling. Suddenly, an oddly-shaped door comes into view and slowly opens."
				(oratPart posn: (gEgo x:) (gEgo y:) init:)
				(= cycles 3)
				(NormalEgo 3 1 61)
			)
			(4
				(Print 34 32) ; "You hear a voice, different this time, beckoning you to step forward."
				(= cycles 3)
			)
			(5
				(gSoundEffects number: 433 loop: 1 play:)
				(door init: posn: 82 106 cycleSpeed: 8 setCycle: End self)
			)
			(6
				(gSoundEffects stop:)
				(gEgo setPri: 10 setMotion: MoveTo 88 112 self)
				(gLongSong fade:)
			)
			(7
				(gCurRoom newRoom: 35)
			)
		)
	)
)

(instance holoMouth of Prop
	(properties
		x 216
		y 123
		view 134
		loop 1
		priority 8
		signal 16
		cycleSpeed 6
	)

	(method (doit)
		(super doit:)
		(if
			(and
				(== local1 0)
				(startUp script:)
				((startUp script:) save1:)
				(not cycler)
			)
			(self setCycle: Osc 3)
			(= local1 1)
		)
	)

	(method (doVerb theVerb invItem)
		(holodude doVerb: theVerb invItem)
	)
)

(instance holoEyes of Prop
	(properties
		x 216
		y 71
		view 134
		priority 1
		signal 16400
		cycleSpeed 6
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Osc)
	)

	(method (doit)
		(super doit:)
		(if (holoMouth cel:)
			(self show:)
		else
			(self hide:)
		)
	)

	(method (doVerb theVerb invItem)
		(holodude doVerb: theVerb invItem)
	)
)

(instance head of Prop ; UNUSED
	(properties
		x 218
		y 146
		view 61
		loop 8
		cycleSpeed 6
	)

	(method (doVerb theVerb invItem)
		(holodude doVerb: theVerb invItem)
	)
)

(instance holodude of Feature
	(properties
		x 219
		y 55
		description {holodude}
		sightAngle 45
		onMeCheck 1024
		lookStr {holodude look string}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 34 33) ; "Before you floats a huge head. It appears to be a holographic projection of some sort, its source unknown."
			)
			(3 ; Do
				(Print 34 34) ; "You can have no effect on the hologram."
			)
			(12 ; Smell
				(Print 34 35) ; "It has no smell."
			)
			(11 ; Taste
				(Print 34 36) ; "It has no taste."
			)
			(5 ; Talk
				(Print 34 37) ; "It responds to actions, not words."
			)
			(4 ; Inventory
				(switch invItem
					(8 ; Orat_Part
						(gEgo setScript: egoDropOratPart)
					)
					(10 ; buckazoid
						(Print 34 38) ; "The big alien head is a hologram, pinhead. What does it need with money?"
					)
					(0 ; Cartridge
						(Print 34 39) ; "The big alien head only wants one object, and this ain't it."
					)
					(15 ; Widget
						(Print 34 40) ; "This isn't the object he want to receive from you."
					)
					(6 ; Broken_Glass
						(Print 34 41) ; "Appealing to its vanity will get you nowhere."
					)
					(5 ; Dehydrated_Water
						(Print 34 5) ; "It's a hologram, pinhead - it doesn't need water."
					)
					(4 ; Knife
						(Print 34 42) ; "Don't threaten this guy, okay?"
					)
					(else
						(super doVerb: theVerb invItem)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance door of Prop
	(properties
		view 234
		signal 18432
		cycleSpeed 10
	)
)

(instance oratPart of View
	(properties
		view 134
		loop 2
		signal 16384
	)
)

