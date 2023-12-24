;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 600)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use HandsOffScript)
(use TargActor)
(use Interface)
(use LoadMany)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm600 0
)

(local
	oneTime
	stagCount
	darkTimer
	justTurnedOn
)

(procedure (Blind)
	(HighPrint 600 0) ; "It's too dark to see anything."
)

(instance rm600 of Rm
	(properties
		picture 600
		style 6
	)

	(method (init)
		(LoadMany rsVIEW 585 586 600 601 602 603)
		(LoadMany rsSOUND 601 602 603 551)
		(SolvePuzzle 637 7)
		(treas1 init: stopUpd:)
		(treas2 init: stopUpd:)
		(treas3 init: stopUpd:)
		(treas4 init: stopUpd:)
		(treas5 init: stopUpd:)
		(armor init: stopUpd:)
		(if (IsFlag 116) ; fLightOn
			(glow setPri: 0 init:)
			(floorShine init:)
		else
			(glow setPri: 0 init: stopUpd:)
			(floorShine init: hide:)
		)
		(dr1 init:)
		(dr2 init:)
		(dr3 init: stopUpd:)
		(gEgo posn: 295 61 init:)
		(= gSpellChecker gAllChecker)
		(if (IsFlag 116) ; fLightOn
			(= global61 0)
		else
			(= global61 2)
		)
		(super init:)
		(self setScript: comeIn)
	)

	(method (dispose)
		(= global61 0)
		(super dispose:)
	)

	(method (doit)
		(cond
			(
				(and
					(IsFlag 116) ; fLightOn
					(< (gEgo x:) (glow x:))
					(< (gEgo distanceTo: glow) 30)
				)
				(if (not (== (glow priority:) 1))
					(glow setPri: 1)
				)
			)
			((not (== (glow priority:) 0))
				(glow setPri: 0)
			)
		)
		(if (and (& (gEgo onControl: 1) $0002) (== oneTime 0))
			(= oneTime 1)
			(gEgo setScript: nextRoom)
		)
		(cond
			((not darkTimer))
			((-- darkTimer))
			(else
				(EgoDead 1 600 1) ; "You die wandering in the darkness"
			)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'search,look,look[<at,around][/room,area][/!*]')
				(if (IsFlag 116) ; fLightOn
					(HighPrint 600 2) ; "You are in a roughly-hewn cave or old mine."
				else
					(Blind)
				)
			)
			((Said 'look,look>')
				(cond
					((Said '<up')
						(if (IsFlag 116) ; fLightOn
							(HighPrint 600 3) ; "The lamp barely illuminates the dull rock above."
						else
							(Blind)
						)
					)
					((Said '<down')
						(if (IsFlag 116) ; fLightOn
							(HighPrint 600 4) ; "The floor of this chamber is smooth stone."
						else
							(Blind)
						)
					)
				)
			)
			((Said 'walk')
				(HighPrint 600 5) ; "Go ahead. Just do it."
			)
			((Said 'run,sneak')
				(HighPrint 600 6) ; "You are better off walking."
			)
			((Said 'use,rub,rub,light,(turn<on)/lamp,light')
				(DontMove 0)
				(= darkTimer 0)
				(SetFlag 116) ; fLightOn
				(gCast eachElementDo: #show)
				(gEgo view: 585 setCycle: Walk)
				(= global61 0)
				(gCurRoom drawPic: 600)
			)
			((Said 'put,drop,extinguish,douse,(turn<off)/lamp,light')
				(HighPrint 600 7) ; "OK, but you'd better keep it handy. There may be other dark caves to explore."
				(gEgo setScript: tooDark)
			)
			((Said 'grab,get,get,get/loot,gem,gold,chest,armor')
				(cond
					((not (IsFlag 116)) ; fLightOn
						(Blind)
					)
					(
						(or
							(< (gEgo distanceTo: treas1) 50)
							(< (gEgo distanceTo: treas2) 50)
							(< (gEgo distanceTo: treas3) 40)
							(< (gEgo distanceTo: treas4) 40)
							(< (gEgo distanceTo: treas5) 50)
						)
						(gEgo setScript: friedEgo)
					)
					((gEgo inRect: 113 86 201 108)
						(gEgo setScript: downTheTube)
					)
					(else
						(gEgo setScript: dropStag)
					)
				)
			)
			((Said 'look,look<at/loot,gem,gold')
				(if (not (IsFlag 116)) ; fLightOn
					(Blind)
				else
					(Print 600 8) ; "All that glitters is not gold."
				)
			)
			((Said 'cast/trigger,fetch')
				(cond
					((not (IsFlag 116)) ; fLightOn
						(Blind)
					)
					(
						(or
							(< (gEgo distanceTo: treas1) 60)
							(< (gEgo distanceTo: treas2) 60)
							(< (gEgo distanceTo: treas3) 60)
							(< (gEgo distanceTo: treas4) 60)
							(< (gEgo distanceTo: treas5) 70)
						)
						(gEgo setScript: friedEgo)
					)
					((< (gEgo distanceTo: armor) 35)
						(gEgo setScript: downTheTube)
					)
					(else
						(gEgo setScript: dropStag)
					)
				)
			)
			((Said 'cast/open,open')
				(if (IsFlag 116) ; fLightOn
					(gEgo setScript: downTheTube)
				else
					(Blind)
				)
			)
			((Said 'cast/flame')
				(gEgo setScript: friedEgo)
			)
			((Said 'cast/bolt')
				(gEgo setScript: dropStag)
			)
		)
	)
)

(instance floorShine of Actor
	(properties
		noun '/reflection,glow'
		description {the reflection of your lamp.}
		lookStr {It is the reflection of your lamp light.}
		view 586
		signal 18432
		illegalBits 0
	)

	(method (show)
		(= justTurnedOn 1)
		(super show: &rest)
	)

	(method (doit)
		(if (and (IsFlag 116) (== (gEgo view:) 585)) ; fLightOn
			(self setPri: (- (gEgo priority:) 1))
			(if (or (gEgo mover:) justTurnedOn)
				(if justTurnedOn
					(= justTurnedOn 0)
				)
				(cond
					((== (gEgo loop:) 0)
						(self posn: (+ (gEgo x:) 10) (+ (gEgo y:) 5))
					)
					((== (gEgo loop:) 1)
						(self posn: (- (gEgo x:) 10) (+ (gEgo y:) 5))
					)
					((== (gEgo loop:) 2)
						(self posn: (gEgo x:) (+ (gEgo y:) 5))
					)
					((== (gEgo loop:) 3)
						(self posn: (gEgo x:) (- (gEgo y:) 5))
					)
					((or (== (gEgo loop:) 4) (== (gEgo loop:) 6))
						(self posn: (+ (gEgo x:) 12) (gEgo y:))
					)
					((or (== (gEgo loop:) 5) (== (gEgo loop:) 7))
						(self posn: (- (gEgo x:) 20) (+ (gEgo y:) 5))
					)
				)
			)
		)
		(super doit:)
	)
)

(instance stag of Actor
	(properties
		description {the stalactite}
		lookStr {Part of the stalactite that fell on you.}
		view 601
		signal 16384
		illegalBits 0
	)
)

(instance stag2 of Actor
	(properties
		description {the stalactite}
		lookStr {Part of the stalactite that fell on you.}
		view 601
		loop 2
		signal 22528
		illegalBits 0
	)
)

(instance lamp of Actor
	(properties
		noun '/light,lamp'
		description {the lamp}
		lookStr {Its your lamp that you've been carrying around.}
		view 586
		loop 2
		signal 16384
		illegalBits 0
	)
)

(instance trapDoor of Prop
	(properties
		description {the trapdoor}
		lookStr {Bye bye!!}
		view 603
		signal 16384
	)
)

(instance treas1 of Prop
	(properties
		x 38
		y 152
		noun '/loot,gold,gem'
		description {the jewels and gold}
		view 601
		loop 5
		cel 2
		priority 14
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if cel
					(Print 600 9) ; "Something is piled up in the dark."
				else
					(Print 600 10) ; "It looks like treasure of jewels and gold."
				)
			)
			(7
				(cond
					((not (IsFlag 116)) ; fLightOn
						(Blind)
					)
					(
						(or
							(< (gEgo distanceTo: treas1) 50)
							(< (gEgo distanceTo: treas2) 50)
							(< (gEgo distanceTo: treas3) 40)
							(< (gEgo distanceTo: treas4) 40)
							(< (gEgo distanceTo: treas5) 50)
						)
						(gEgo setScript: friedEgo)
					)
					((gEgo inRect: 113 86 201 108)
						(gEgo setScript: downTheTube)
					)
					(else
						(gEgo setScript: dropStag)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (doit)
		(if (IsFlag 116) ; fLightOn
			(if (and (== (gEgo loop:) 6) (not cel))
				(self setCycle: End)
			)
			(cond
				(
					(and
						(< (gEgo distanceTo: self) 50)
						(!= (gEgo loop:) 6)
						cel
					)
					(self setCycle: Beg)
				)
				((and (> (gEgo distanceTo: self) 50) (not cel))
					(self setCycle: End)
				)
			)
			(if (and (not cycler) (not (& signal $0000)))
				(self stopUpd:)
			)
		)
		(super doit:)
	)
)

(instance treas2 of Prop
	(properties
		x 66
		y 176
		view 601
		loop 6
		cel 2
		priority 14
		signal 16400
	)

	(method (doit)
		(if (IsFlag 116) ; fLightOn
			(if (and (== (gEgo loop:) 3) (not cel))
				(self setCycle: End)
			)
			(cond
				(
					(and
						(< (gEgo distanceTo: self) 50)
						(!= (gEgo loop:) 3)
						cel
					)
					(self setCycle: Beg)
				)
				((and (> (gEgo distanceTo: self) 50) (not cel))
					(self setCycle: End)
				)
			)
			(if (and (not cycler) (not (& signal $0000)))
				(self stopUpd:)
			)
		)
		(super doit:)
	)
)

(instance treas3 of Prop
	(properties
		x 103
		y 182
		view 601
		loop 7
		cel 2
		priority 14
		signal 16400
	)

	(method (doit)
		(if (IsFlag 116) ; fLightOn
			(if (and (== (gEgo loop:) 3) (not cel))
				(self setCycle: End)
			)
			(cond
				(
					(and
						(< (gEgo distanceTo: self) 50)
						(!= (gEgo loop:) 3)
						cel
					)
					(self setCycle: Beg)
				)
				((and (> (gEgo distanceTo: self) 50) (not cel))
					(self setCycle: End)
				)
			)
			(if (and (not cycler) (not (& signal $0000)))
				(self stopUpd:)
			)
		)
		(super doit:)
	)
)

(instance treas4 of Prop
	(properties
		x 161
		y 189
		view 601
		loop 8
		cel 2
		priority 14
		signal 16400
	)

	(method (doit)
		(if (IsFlag 116) ; fLightOn
			(if (and (== (gEgo loop:) 3) (not cel))
				(self setCycle: End)
			)
			(cond
				(
					(and
						(< (gEgo distanceTo: self) 50)
						(!= (gEgo loop:) 3)
						cel
					)
					(self setCycle: Beg)
				)
				((and (> (gEgo distanceTo: self) 50) (not cel))
					(self setCycle: End)
				)
			)
			(if (and (not cycler) (not (& signal $0000)))
				(self stopUpd:)
			)
		)
		(super doit:)
	)
)

(instance treas5 of Prop
	(properties
		x 275
		y 161
		view 601
		loop 4
		cel 2
		priority 14
		signal 16400
	)

	(method (doit)
		(if (IsFlag 116) ; fLightOn
			(if (and (== (gEgo loop:) 7) (not cel))
				(self setCycle: End)
			)
			(cond
				(
					(and
						(< (gEgo distanceTo: self) 50)
						(!= (gEgo loop:) 7)
						cel
					)
					(self setCycle: Beg)
				)
				((and (> (gEgo distanceTo: self) 50) (not cel))
					(self setCycle: End)
				)
			)
			(if (and (not cycler) (not (& signal $0000)))
				(self stopUpd:)
			)
		)
		(super doit:)
	)
)

(instance armor of Prop
	(properties
		x 159
		y 99
		noun '/loot,gold,armor,gem'
		description {the jewels and gold}
		view 601
		loop 3
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if (== (self cel:) 3)
					(Print 600 11) ; "It looks like armour of gold."
				else
					(Print 600 9) ; "Something is piled up in the dark."
				)
			)
			(7
				(treas1 doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (doit)
		(if (IsFlag 116) ; fLightOn
			(if (and (== (gEgo loop:) 2) cel)
				(self setCycle: Beg)
			)
			(cond
				(
					(and
						(< (gEgo distanceTo: self) 30)
						(!= (gEgo loop:) 2)
						(not cel)
					)
					(self setCycle: CT 3 1)
				)
				((and (> (gEgo distanceTo: self) 30) cel)
					(self setCycle: Beg)
				)
			)
			(if (and (not cycler) (not (& signal $0000)))
				(self stopUpd:)
			)
		)
		(super doit:)
	)
)

(instance dr1 of TargActor
	(properties
		x 270
		y 57
		noun '/door'
		description {the door}
		lookStr {You cannot return the way you came.}
		view 600
		loop 2
		cel 4
		priority 1
		signal 16
		cycleSpeed 1
		illegalBits 0
	)

	(method (detectMe)
		(Print 600 12) ; "A strong aura of magic is around the treasure in this room. An even stronger sense of magic radiates from the room beyond the far door."
		(return 1)
	)
)

(instance dr2 of Prop
	(properties
		x 304
		y 68
		noun '/door'
		description {the door}
		lookStr {You cannot return the way you came.}
		view 600
		loop 1
		cel 4
		priority 1
		signal 16
		cycleSpeed 1
	)
)

(instance dr3 of Prop
	(properties
		x 69
		y 61
		noun '/door'
		description {the door}
		lookStr {Beyond this door awaits your fortune.}
		view 600
		cycleSpeed 1
	)
)

(instance glow of View
	(properties
		x 263
		y 101
		noun '/reflection,glow'
		description {the reflection of your lamp.}
		lookStr {It is the reflection of your lamp light.}
		view 586
		loop 1
		signal 16384
	)
)

(instance comeIn of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 262 78 self)
			)
			(1
				(gMiscSound number: 551 loop: 1 init: play:)
				(dr1 setCycle: Beg)
				(dr2 setCycle: Beg self)
			)
			(2
				(dr1 stopUpd:)
				(dr2 stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance nextRoom of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(dr3 setCycle: End self)
			)
			(1
				(gEgo setMotion: MoveTo 22 27 self)
			)
			(2
				(gCurRoom newRoom: 610)
				(self dispose:)
			)
		)
	)
)

(instance downTheTube of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self cue:)
			)
			(1
				(gMiscSound number: 601 loop: 1 play:)
				(if (OneOf (gEgo loop:) 1 3 5 7)
					(gEgo loop: 2)
				else
					(gEgo loop: 3)
				)
				(gEgo view: 603 cel: 2 cycleSpeed: 1 setCycle: End self)
				(trapDoor
					setPri: (- (gEgo priority:) 1)
					posn: (+ (gEgo x:) 4) (+ (gEgo y:) 8)
					init:
					setCycle: End
				)
				(floorShine hide:)
			)
			(2
				(lamp
					posn: (+ (gEgo x:) 20) (- (gEgo y:) 4)
					setLoop: 2
					setCel: 0
					init:
					setMotion: (lamp x:) (+ (lamp y:) 60)
				)
				(trapDoor loop: 1 cel: 0 setCycle: End self)
				(gEgo setPri: (+ (trapDoor priority:) 1) loop: 4 cel: 0)
			)
			(3
				(floorShine
					setPri: (- (lamp priority:) 1)
					posn: (lamp x:) (+ (lamp y:) 6)
					show:
				)
				(trapDoor hide:)
				(gEgo hide:)
				(= cycles 10)
			)
			(4
				(EgoDead 0 600 13 #icon 603 2 6 #title {Tripped by a Trap}) ; "You really fell for it. As the ground closes up around you, your last thoughts are: "This is really the pits!""
			)
		)
	)
)

(instance friedEgo of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(floorShine hide:)
				(= cycles 1)
			)
			(1
				(gMiscSound number: 602 loop: 1 play:)
				(gEgo
					view: 602
					loop: 0
					cel: 0
					cycleSpeed: 2
					setCycle: End self
				)
				(lamp
					posn: (+ (gEgo x:) 4) (- (gEgo y:) 21)
					setPri: (+ (gEgo priority:) 1)
					setLoop: 2
					setCel: 0
					yStep: 5
					init:
					setMotion: MoveTo (+ (gEgo x:) 18) (+ (gEgo y:) 6)
				)
			)
			(2
				(gEgo hide:)
				(floorShine
					posn: (lamp x:) (+ (lamp y:) 6)
					setPri: (- (lamp priority:) 4)
					show:
				)
				(= cycles 5)
			)
			(3
				(EgoDead 0 600 14 #icon 602 0 3 #title {A Zap for a Permanent Nap}) ; "Your animal magnetism obviously sparked this flash of brilliance. Next time you proceed, pay heed to the creed: "To succeed you need to be freed from greed.""
			)
		)
	)
)

(instance dropStag of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMiscSound number: 603 loop: 1 play:)
				(stag setPri: 15 posn: (gEgo x:) 8 init:)
				(= cycles 1)
			)
			(1
				(stag setPri: 15 posn: (stag x:) (+ (stag y:) 16))
				(= cycles 1)
			)
			(2
				(if (< (stag y:) (- (gEgo y:) 54))
					(self changeState: 1)
				else
					(if (IsFlag 116) ; fLightOn
						(gEgo cel: 1)
					)
					(stag setPri: 15 posn: (gEgo x:) (- (gEgo y:) 50))
					(= cycles 1)
				)
			)
			(3
				(if (OneOf (gEgo loop:) 1 2 5 7)
					(gEgo view: 601 setLoop: 9)
				else
					(gEgo view: 601 setLoop: 10)
				)
				(stag cel: 2)
				(= cycles 1)
			)
			(4
				(floorShine hide:)
				(gEgo cel: 0 setPri: 10 cycleSpeed: 2 setCycle: End)
				(stag
					setPri: 14
					setLoop: 1
					setCel: 0
					posn: (- (stag x:) 23) (+ (stag y:) 3)
				)
				(stag2 setPri: 14 posn: (+ (stag x:) 18) (+ (stag y:) 3) init:)
				(if (IsFlag 116) ; fLightOn
					(lamp posn: (+ (gEgo x:) 20) (- (gEgo y:) 15) init:)
				)
				(= cycles 1)
			)
			(5
				(stag
					setPri: 14
					loop: 1
					cel: 0
					posn: (- (stag x:) 12) (+ (stag y:) 23)
				)
				(stag2 setPri: 14 posn: (+ (stag2 x:) 5) (+ (stag2 y:) 7))
				(if (IsFlag 116) ; fLightOn
					(lamp posn: (lamp x:) (- (gEgo y:) 5))
				)
				(= cycles 1)
			)
			(6
				(stag
					setPri: 14
					loop: 1
					cel: 0
					posn: (- (stag x:) 11) (- (stag y:) 11)
				)
				(stag2 setPri: 14 posn: (+ (stag2 x:) 2) (+ (stag2 y:) 17))
				(if (IsFlag 116) ; fLightOn
					(lamp posn: (lamp x:) (- (gEgo y:) 5))
				)
				(= cycles 1)
			)
			(7
				(stag
					setPri: 14
					loop: 1
					cel: 0
					posn: (- (stag x:) 14) (- (stag y:) 2)
				)
				(stag2 setPri: 14 posn: (+ (stag2 x:) 8) (- (stag2 y:) 3))
				(if (IsFlag 116) ; fLightOn
					(lamp posn: (lamp x:) (- (gEgo y:) 5))
				)
				(= cycles 1)
			)
			(8
				(stag
					setPri: 14
					loop: 1
					cel: 0
					posn: (- (stag x:) 12) (+ (stag y:) 6)
				)
				(stag2 setPri: 14 posn: (+ (stag2 x:) 9) (- (stag2 y:) 4))
				(if (IsFlag 116) ; fLightOn
					(lamp posn: (lamp x:) (- (gEgo y:) 5))
				)
				(= cycles 1)
			)
			(9
				(stag
					setPri: 14
					loop: 1
					cel: 0
					posn: (- (stag x:) 11) (- (stag y:) 2)
				)
				(stag2 setPri: 14 posn: (+ (stag2 x:) 4) (+ (stag2 y:) 6))
				(floorShine posn: (lamp x:) (lamp y:) show:)
				(if (IsFlag 116) ; fLightOn
					(lamp posn: (lamp x:) (- (gEgo y:) 5))
				)
				(= cycles 1)
			)
			(10
				(stag2 setPri: 14 posn: (+ (stag2 x:) 14) (- (stag2 y:) 6))
				(= cycles 1)
			)
			(11
				(stag2 setPri: 14 posn: (+ (stag2 x:) 7) (+ (stag2 y:) 4))
				(= cycles 1)
			)
			(12
				(EgoDead 0 600 15 #icon 601 0 2 #title {Knocked by a Rock}) ; "The stalactite (or is it a stalagmite?) has shattered your dreams of becoming a hero. You feel crushed."
			)
		)
	)
)

(instance tooDark of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(DontMove 1)
				(= cycles 12)
			)
			(1
				(gCast eachElementDo: #hide)
				(gEgo setMotion: 0)
				(ClearFlag 116) ; fLightOn
				(gCurRoom drawPic: 2)
				(= seconds 2)
			)
			(2
				(Print 600 16) ; "It is far too dark to be without your lamp. Maybe you should light the lamp again?"
				(= seconds 5)
			)
			(3
				(if (not (IsFlag 116)) ; fLightOn
					(= darkTimer 50)
					(Print 600 17) ; "Light the lamp!!!!"
				)
				(self dispose:)
			)
		)
	)
)

