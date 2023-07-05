;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 90)
(include sci.sh)
(use Main)
(use Interface)
(use RandCycle)
(use Count)
(use Sort)
(use RFeature)
(use Path)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm090 0
)

(local
	[local0 7] = [0 94 36 115 68 126 -32768]
	[local7 15] = [68 126 99 124 146 108 165 96 181 81 193 71 201 62 -32768]
	local22
	[local23 16] = [0 168 92 168 143 152 173 150 137 0 319 0 319 189 0 189]
	[local39 8] = [0 154 134 143 134 0 0 0]
)

(procedure (localproc_0)
	(cls)
	(h1Mouth cue:)
	(h2Mouth cue:)
	(h3Mouth cue:)
	(h4Mouth cue:)
)

(instance rm090 of Rm
	(properties
		picture 90
		west 50
	)

	(method (init)
		(super init:)
		(proc0_24 128 836 838 54 70)
		(switch gPrevRoomNum
			(91
				(Load rsVIEW 840)
				(harpy1 setScript: argueScript)
			)
			(50
				(if (IsFlag 56)
					(gGlobalSound number: 814 loop: -1 vol: 127 playBed:)
				)
				(gEgo
					view: (if (IsFlag 75) 659 else 2)
					posn: 40 162
					setStep: 2 2
					init:
				)
				(if (== (gEgo view:) 659)
					((gEgo head:) hide:)
				)
				(if (IsFlag 55)
					(harpy1 init: posn: -50 20 setScript: harpyInitScript)
				)
			)
			(else
				(Load rsVIEW 840)
				(gGlobalSound number: 816 loop: -1 vol: 127 playBed:)
				(self setScript: crtn5Script)
			)
		)
		(if (not (gEgo has: 31)) ; Fishhook
			(fishhook init: setScript: hookScript)
		)
		(self setFeatures: island room addObstacle: poly1 poly2)
		(poly1 points: @local23 size: 8)
		(poly2 points: @local39 size: 4)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(gCurRoom newRoom: temp0)
			)
			((& (gEgo onControl: 0) $0010)
				(HandsOff)
				(self setScript: fallScript)
			)
		)
	)

	(method (handleEvent event &tmp [temp0 100])
		(cond
			((event claimed:)
				(return)
			)
			(script
				(return)
			)
			(
				(and
					(== (event type:) evVERB)
					(proc0_18 gEgo event)
					(== (event message:) 5) ; Inventory
				)
				(switch global69
					(10 ; Harp
						(HandsOff)
						(gCurRoom setScript: playHarpScript)
						(event claimed: 1)
					)
					(28 ; Wand
						(event claimed: 0)
					)
					(else
						(PrintDC 90 0) ; "This situation seems to require very careful thought. Graham needs to spend more time on this."
						(event claimed: 1)
					)
				)
			)
		)
	)

	(method (dispose)
		(DisposeScript 983)
		(DisposeScript 751)
		(super dispose:)
	)
)

(instance harpyInitScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (> (Random 1 100) 50)
					0
				else
					(self dispose:)
				)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (> (gEgo x:) 88)
			(HandsOff)
			(gCurRoom setScript: harpyScript)
			(self dispose:)
		)
	)
)

(instance harpyScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlobalSound number: 815 loop: -1 vol: 90 playBed:)
				(harpy1
					view: 836
					setLoop: 0
					ignoreActors: 1
					setCycle: Fwd
					setMotion: MoveTo (gEgo x:) (- (gEgo y:) 30) self
				)
			)
			(1
				(if (IsObject (gEgo head:))
					((gEgo head:) dispose:)
				)
				(gEgo normal: 0 view: 838 setLoop: 0 setCycle: Fwd)
				(harpy1 setMotion: MoveTo 350 20 self)
			)
			(2
				(= global103 0)
				(= cycles 1)
			)
			(3
				(= global330
					{Hate to harp on the subject, but... Graham's dead!}
				)
				(EgoDead 247)
			)
		)
	)

	(method (doit)
		(if state
			(gEgo posn: (- (harpy1 x:) 5) (- (harpy1 y:) 3))
		)
		(super doit:)
	)
)

(instance fallScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((gEgo head:) hide:)
				(gEgo
					normal: 0
					view: (if (IsFlag 75) 838 else 70)
					setLoop: (if (IsFlag 75) 5 else 0)
					cel: 0
					cycleSpeed: 1
					setCycle: End self
					setPri: 1
					illegalBits: 0
				)
				(gGlobalSound2 number: 83 loop: 1 vol: 127 play:)
			)
			(1
				(gEgo
					yStep: 8
					setMotion: MoveTo (- (gEgo x:) 20) 230 self
				)
			)
			(2
				(= global103 0)
				(= seconds 2)
			)
			(3
				(= global330 {That last step was a doozy!})
				(EgoDead)
			)
		)
	)
)

(instance crtn5Script of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(DrawCel 2 0 0 400 0 0 3)
				(harpy2 init:)
				(harpy3 init:)
				(h3Mouth init:)
				(gEgo
					view: 838
					setLoop: 0
					x: -100
					setCycle: Fwd
					normal: 0
					init:
				)
				((gEgo head:) hide:)
				(harpy4 init: setCycle: Fwd setMotion: swoop1 self)
			)
			(1
				(harpy4 setMotion: swoop2 self)
				(gEgo
					posn: (+ (gEgo x:) 20) (+ (gEgo y:) 34)
					setLoop: 1
					setCel: 0
					cycleSpeed: 1
					setCycle: End self
				)
				(gEgo setMotion: MoveTo (+ (gEgo x:) 20) (gEgo y:))
				(harpy1 init: setScript: harpy1Script)
			)
			(2
				(gEgo
					view: 2
					posn: (+ (gEgo x:) 29) (gEgo y:)
					setMotion: 0
					loop: 11
					cel: 0
				)
				((gEgo head:) show:)
			)
			(3
				(harpy4 view: 840 setLoop: 5 setCel: 1 setPri: 9 setCycle: 0)
				(h4Mouth init:)
				(self dispose:)
			)
		)
	)

	(method (doit)
		(if (not state)
			(gEgo posn: (- (harpy4 x:) 5) (harpy4 y:))
		)
		(super doit:)
	)
)

(instance harpy1Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(harpy1 init: setCycle: Fwd setMotion: MoveTo 66 127 self)
			)
			(1
				(harpy1 setLoop: 3 setCel: 0 setCycle: End self)
			)
			(2
				(harpy1 setMotion: MoveTo 66 136 self)
			)
			(3
				(harpy1
					view: 840
					loop: 0
					posn: (+ (harpy1 x:) 3) (+ (harpy1 y:) 25)
				)
				(= seconds 3)
			)
			(4
				(gCurRoom newRoom: 91)
			)
		)
	)
)

(instance argueScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOn)
				(= global103 0)
				(NormalEgo 11 2)
				(gEgo
					cel: 0
					setStep: 2 2
					init:
					posn: 130 159
					view: 2
					loop: 11
				)
				(harpy1 view: 840 posn: 69 161 setLoop: 0 setCel: 1 init:)
				(harpy2 init: setCel: 1)
				(harpy3 init:)
				(harpy4
					view: 840
					setLoop: 5
					setCel: 1
					posn: 201 62
					init:
					setPri: 9
				)
				(h1Mouth init:)
				(h2Mouth init:)
				(h3Mouth init:)
				(h4Mouth init:)
				(= cycles 1)
			)
			(1
				(h2Mouth cue: 1)
				(PrintDC 90 1 #at 225 100 #width 70 #dispose) ; "I think he looks too old and tough. I like MY meals to be young and tender."
				(= seconds 6)
			)
			(2
				(localproc_0)
				(h4Mouth cue: 1)
				(PrintDC 90 2 #at 220 10 #width 80 #dispose) ; "Don't be so picky. I'm tired of fish. I haven't had a man in months."
				(= seconds 6)
			)
			(3
				(localproc_0)
				(h3Mouth cue: 1)
				(PrintDC 90 3 #at 10 10 #width 120 #dispose) ; "Yes, you did. I saw you steal a man off a raft just last week!"
				(= seconds 5)
			)
			(4
				(localproc_0)
				(h4Mouth cue: 1)
				(PrintDC 90 4 #at 220 10 #width 80 #dispose) ; "Oh, he doesn't count! He was already picked over by the time I got to him!"
				(= seconds 5)
			)
			(5
				(localproc_0)
				(h1Mouth cue: 1)
				(PrintDC 90 5 #at 10 -1 #width 120 #dispose) ; "Well, at least this one's fresh!"
				(= seconds 5)
			)
			(6
				(localproc_0)
				(h2Mouth cue: 1)
				(PrintDC 90 6 #at 225 100 #width 70 #dispose) ; "I don't know about you girls... but I'm ready to eat!"
				(= seconds 6)
			)
			(7
				(localproc_0)
				(h3Mouth cue: 1)
				(PrintDC 90 7 #at 10 10 #width 120 #dispose) ; "Oh, you're ALWAYS ready to eat. That's why you're so fat!"
				(= seconds 6)
			)
			(8
				(localproc_0)
				(h2Mouth cue: 1)
				(PrintDC 90 8 #at 225 100 #dispose) ; "I am NOT!"
				(= seconds 2)
			)
			(9
				(localproc_0)
				(h3Mouth cue: 1)
				(PrintDC 90 9 #at 60 10 #dispose) ; "You are TOO!"
				(= seconds 2)
			)
			(10
				(localproc_0)
				(h2Mouth cue: 1)
				(PrintDC 90 8 #at 225 100 #dispose) ; "I am NOT!"
				(= seconds 2)
			)
			(11
				(localproc_0)
				(h3Mouth cue: 1)
				(PrintDC 90 9 #at 60 10 #dispose) ; "You are TOO!"
				(= seconds 2)
			)
			(12
				(localproc_0)
				(h1Mouth cue: 1)
				(PrintDC 90 10 #at 10 -1 #width 120 #dispose) ; "Oh, quit arguing, girls! Let's eat!"
				(= seconds 5)
			)
			(13
				(localproc_0)
				(HandsOff)
				(client setScript: 0)
				(gCurRoom setScript: grabEgoScript)
			)
		)
	)

	(method (doit)
		(if (< (gEgo x:) (+ (harpy1 x:) 20))
			(HandsOff)
			(gCurRoom setScript: escapeScript)
		)
		(super doit: &rest)
	)
)

(instance escapeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_0)
				(harpy1 setScript: 0)
				(h1Mouth cue: 1)
				(PrintDC 90 11 #at 10 -1 #width 120 #dispose) ; "Trying to escape, huh?"
				(= seconds 3)
			)
			(1
				(localproc_0)
				(h1Mouth dispose:)
				(harpy1 view: 842 setLoop: 0 cel: 0 setCycle: End self)
			)
			(2
				(if (IsObject (gEgo head:))
					((gEgo head:) dispose:)
				)
				(gEgo dispose:)
				(harpy1 setLoop: 2 cel: 0 setCycle: End self)
			)
			(3
				(harpy1
					setLoop: 3
					setCycle: Walk
					setMotion: MoveTo -30 (harpy1 y:)
				)
				(h2Mouth dispose:)
				(harpy2
					view: 836
					setLoop: 5
					ignoreActors:
					setCel: 0
					posn: (- (harpy2 x:) 25) (- (harpy2 y:) 20)
					setCycle: End self
				)
			)
			(4
				(harpy3 setScript: harpy3Script)
				(harpy4 setScript: harpy4Script self)
				(harpy2 setCycle: Fwd setLoop: 2 setMotion: MoveTo -40 140)
			)
			(5
				(= global103 0)
				(= cycles 2)
			)
			(6
				(= global330
					{Hate to harp on the subject, but... Graham's dead!}
				)
				(EgoDead 247)
			)
		)
	)
)

(instance grabEgoScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_0)
				(h2Mouth dispose:)
				(harpy2
					view: 836
					setLoop: 5
					ignoreActors:
					setCel: 0
					posn: (- (harpy2 x:) 25) (- (harpy2 y:) 20)
					setCycle: End self
				)
				((gEgo head:) hide:)
				(gEgo
					normal: 0
					view: 838
					setLoop: 3
					posn: (- (gEgo x:) 18) (- (gEgo y:) 34)
					setCel: 0
					illegalBits: 0
					ignoreHorizon: 1
				)
			)
			(1
				(harpy2
					setLoop: 2
					setCycle: Fwd
					setPri: (+ (gEgo priority:) 1)
					setMotion:
						MoveTo
						(+ (gEgo x:) 17)
						(+ (gEgo y:) 6)
						self
				)
			)
			(2
				(gEgo setCycle: End self)
			)
			(3
				(gEgo setLoop: 4 setCel: 0 setCycle: Fwd)
				(harpy2 setLoop: 2 setMotion: MoveTo -40 70 self)
			)
			(4
				(localproc_0)
				(h1Mouth dispose:)
				(harpy1 setLoop: 4 setCycle: End self)
			)
			(5
				(harpy3 setScript: harpy3Script)
				(harpy4 setScript: harpy4Script self)
				(harpy1
					view: 836
					setLoop: 5
					setCel: 0
					posn: (- (harpy1 x:) 25) (- (harpy1 y:) 20)
					setCycle: End self
				)
			)
			(6
				(harpy1 setLoop: 2 setCycle: Fwd setMotion: MoveTo -40 70)
			)
			(7
				(= global103 0)
				(= cycles 2)
			)
			(8
				(= global330
					{Hate to harp on the subject, but... Graham's dead!}
				)
				(EgoDead 247)
			)
		)
	)

	(method (doit)
		(if (> state 2)
			(gEgo posn: (- (harpy2 x:) 4) (- (harpy2 y:) 1))
		)
		(super doit: &rest)
	)
)

(instance playHarpScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(+= gScore 4)
				(harpy1 setScript: 0)
				(localproc_0)
				(if (== global81 3)
					(note init: setScript: noteScript)
				)
				(harp posn: (gEgo x:) (gEgo y:) 1000 init:)
				((gEgo head:) view: 54 loop: 1)
				(gEgo
					normal: 0
					view: 54
					loop: 0
					cel: 0
					cycleSpeed: (if (== global286 0) 0 else 5)
					setCycle: RandCycle 50 self
				)
				(gGlobalSound number: 817 loop: -1 vol: 127 playBed:)
			)
			(1
				(gEgo setCycle: RandCycle)
				(h3Mouth cue: 1)
				(PrintDC 90 12 #at 10 10 #width 120 #dispose) ; "What's he doing? What's that thing?"
				(= seconds 4)
			)
			(2
				(localproc_0)
				(h2Mouth cue: 1)
				(PrintDC 90 13 #at 225 100 #width 70 #dispose) ; "I don't know but I want it!"
				(= seconds 4)
			)
			(3
				(localproc_0)
				(h2Mouth dispose:)
				(harpy2
					view: 836
					setLoop: 5
					setCel: 0
					posn: (- (harpy2 x:) 25) (- (harpy2 y:) 20)
					setCycle: End self
				)
			)
			(4
				(harpy2
					setLoop: 2
					setCycle: Fwd
					setPri: (+ (gEgo priority:) 1)
					setMotion: MoveTo (gEgo x:) (- (gEgo y:) 26) self
				)
			)
			(5
				(note dispose:)
				(gEgo setLoop: 2 cycleSpeed: 2 setCycle: End self)
				(gGlobalSound stop:)
			)
			(6
				(harpy2 setMotion: MoveTo -40 70 self)
				(harp z: 0)
				(gEgo
					normal: 1
					view: 2
					illegalBits: -32768
					loop: 4
					setLoop: -1
					put: 10 ; Harp
					cycleSpeed: 0
					setCycle: Walk
					setStep: 2 2
				)
				((gEgo head:) view: 2 loop: 4)
			)
			(7
				(h1Mouth cue: 1)
				(h3Mouth cue: 1)
				(h4Mouth cue: 1)
				(PrintDC 90 14 #dispose) ; "Hey, that's not fair! Let's get her, girls!"
				(= seconds 4)
			)
			(8
				(localproc_0)
				(h1Mouth dispose:)
				(harpy1 setLoop: 4 setCycle: End self)
			)
			(9
				(harpy3 setScript: harpy3Script)
				(harpy4 setScript: harpy4Script self)
				(harpy1
					view: 836
					setLoop: 5
					setCel: 0
					posn: (- (harpy1 x:) 25) (- (harpy1 y:) 20)
					setCycle: End self
				)
			)
			(10
				(harpy1 setLoop: 2 setCycle: Fwd setMotion: MoveTo -40 70)
			)
			(11
				(gGlobalSound number: 814 loop: -1 vol: 127 playBed:)
				(SetFlag 56)
				(harpy1 dispose:)
				(harpy2 dispose:)
				(harpy3 dispose:)
				(harpy4 dispose:)
				(self dispose:)
			)
		)
	)

	(method (doit)
		(if (> state 3)
			(harp posn: (- (harpy2 x:) 1) (+ (harpy2 y:) 3))
		)
		(super doit:)
	)
)

(instance noteScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(note
					x: (+ (gEgo x:) 5)
					y: (- (gEgo y:) 20)
					setCel: (Random 0 3)
					setMotion:
						MoveTo
						(+ (gEgo x:) 25)
						(- (gEgo y:) 40)
						self
				)
			)
			(1
				(self init:)
			)
		)
	)
)

(instance harpy3Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(h3Mouth dispose:)
				(harpy3
					view: 836
					setLoop: 6
					posn: (- (harpy3 x:) 3) (- (harpy3 y:) 20)
					setCycle: End self
				)
			)
			(1
				(harpy3
					setLoop: 2
					posn: (- (harpy3 x:) 35) (- (harpy3 y:) 19)
					setCycle: Fwd
					setMotion: MoveTo -40 10 self
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance harpy4Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 20)
			)
			(1
				(h4Mouth dispose:)
				(harpy4
					view: 836
					setLoop: 6
					posn: (- (harpy4 x:) 3) (- (harpy4 y:) 20)
					setCycle: End self
				)
			)
			(2
				(harpy4
					setLoop: 2
					posn: (- (harpy4 x:) 35) (- (harpy4 y:) 19)
					setCycle: Fwd
					setMotion: MoveTo -40 10 self
				)
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance wrongThingScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_0)
				(h3Mouth cue: 1)
				(PrintDC 90 15 #dispose) ; "What's that he's got?"
				(= seconds 3)
			)
			(1
				(localproc_0)
				(h4Mouth cue: 1)
				(PrintDC 90 16 #dispose) ; "I don't know, and I don't CARE!"
				(= seconds 3)
			)
			(2
				(localproc_0)
				(argueScript start: local22)
				(harpy1 setScript: argueScript)
				(= local22 1000)
				(HandsOn)
			)
		)
	)
)

(instance hookScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 5)
			)
			(1
				(fishhook setCycle: End self)
			)
			(2
				(fishhook setCycle: 0)
				(self init:)
			)
		)
	)
)

(instance getHookScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load rsVIEW 665)
				(gEgo
					setMotion:
						PolyPath
						(+ (fishhook x:) 10)
						(+ (fishhook y:) 1)
						self
				)
			)
			(1
				(if (gCast contains: harpy1)
					(PrintDC 90 17) ; "Graham quickly bends down and rescues the fishhook from the ground."
				else
					(PrintDC 90 18) ; "While keeping a sharp eye out for the harpies, Graham quickly bends down and rescues the fishhook from the ground."
				)
				(= register (gEgo view:))
				(if (== (gEgo view:) 2)
					((gEgo head:) hide:)
				)
				(gEgo
					normal: 0
					view: 665
					setLoop: (if (IsFlag 75) 3 else 4)
					cel: 0
					setCycle: CT 3 1 self
				)
			)
			(2
				(SetScore 2)
				(fishhook dispose:)
				(gEgo setCycle: End self)
			)
			(3
				(gEgo
					normal: 1
					view: register
					setLoop: -1
					loop: 3
					setCycle: Walk
					get: 31 ; Fishhook
				)
				(if (== (gEgo view:) 2)
					((gEgo head:) show:)
				)
				(HandsOn)
				(= global103 0)
				(self dispose:)
			)
		)
	)
)

(instance harpy1 of Act
	(properties
		y 120
		x -10
		yStep 7
		view 836
		priority 10
		signal 26640
		cycleSpeed 1
		illegalBits 0
		xStep 7
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (proc0_18 self event))
				(not (== (event type:) evVERB))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 90 19) ; "Several hungry-looking harpies eye Graham greedily as he frantically looks for a route of escape. Horribly, he sees none."
					(event claimed: 1)
				)
				(3 ; Do
					(PrintDC 90 20) ; "The harpies are vicious creatures whom Graham could never overpower."
					(event claimed: 1)
				)
				(4 ; Talk
					(PrintDC 90 21) ; "The harpies aren't paying any attention to Graham at the moment."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance harpy2 of Act
	(properties
		y 152
		x 211
		yStep 7
		view 840
		loop 9
		priority 12
		signal 26640
		cycleSpeed 1
		illegalBits 0
		xStep 7
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (proc0_18 self event))
				(not (== (event type:) evVERB))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 90 19) ; "Several hungry-looking harpies eye Graham greedily as he frantically looks for a route of escape. Horribly, he sees none."
					(event claimed: 1)
				)
				(3 ; Do
					(PrintDC 90 20) ; "The harpies are vicious creatures whom Graham could never overpower."
					(event claimed: 1)
				)
				(4 ; Talk
					(PrintDC 90 21) ; "The harpies aren't paying any attention to Graham at the moment."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance harpy3 of Act
	(properties
		y 61
		x 180
		yStep 7
		view 840
		loop 5
		priority 10
		signal 26640
		cycleSpeed 1
		illegalBits 0
		xStep 7
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (proc0_18 self event))
				(not (== (event type:) evVERB))
			)
			(return)
		else
			(harpy1 handleEvent: event)
			(switch (event message:)
				(2 ; Look
					(PrintDC 90 19) ; "Several hungry-looking harpies eye Graham greedily as he frantically looks for a route of escape. Horribly, he sees none."
					(event claimed: 1)
				)
				(3 ; Do
					(PrintDC 90 20) ; "The harpies are vicious creatures whom Graham could never overpower."
					(event claimed: 1)
				)
				(4 ; Talk
					(PrintDC 90 21) ; "The harpies aren't paying any attention to Graham at the moment."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance harpy4 of Act
	(properties
		y 125
		x -10
		yStep 7
		view 836
		priority 11
		signal 26640
		cycleSpeed 1
		illegalBits 0
		xStep 7
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (proc0_18 self event))
				(not (== (event type:) evVERB))
			)
			(return)
		else
			(switch (event message:)
				(harpy1
					--UNKNOWN-PROPERTY--
					event
				)
				(2 ; Look
					(PrintDC 90 19) ; "Several hungry-looking harpies eye Graham greedily as he frantically looks for a route of escape. Horribly, he sees none."
					(event claimed: 1)
				)
				(3 ; Do
					(PrintDC 90 20) ; "The harpies are vicious creatures whom Graham could never overpower."
					(event claimed: 1)
				)
				(4 ; Talk
					(PrintDC 90 21) ; "The harpies aren't paying any attention to Graham at the moment."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance h1Mouth of Prop
	(properties
		view 840
		loop 1
		signal 26640
		cycleSpeed 3
	)

	(method (init)
		(super init: &rest)
		(self
			posn: (+ (harpy1 x:) 4) (- (harpy1 y:) 28)
			priority: (+ (harpy1 priority:) 1)
		)
		(h1Arms init:)
	)

	(method (cue)
		(super cue: &rest)
		(if (not argc)
			(self setCycle: 0)
			(h1Arms setCycle: 0)
		else
			(self setCycle: RandCycle)
			(h1Arms setCycle: RandCycle)
		)
	)

	(method (dispose)
		(self setCycle: 0)
		(h1Arms dispose:)
		(super dispose:)
	)
)

(instance h2Mouth of Prop
	(properties
		view 840
		loop 10
		signal 26640
		cycleSpeed 3
	)

	(method (init)
		(super init: &rest)
		(self
			posn: (- (harpy2 x:) 9) (- (harpy2 y:) 18)
			priority: (+ (harpy2 priority:) 1)
		)
		(h2Arms init:)
	)

	(method (cue)
		(super cue: &rest)
		(if (not argc)
			(self setCycle: 0)
			(h2Arms setCycle: 0)
		else
			(self setCycle: RandCycle)
			(h2Arms setCycle: RandCycle)
		)
	)

	(method (dispose)
		(self setCycle: 0)
		(h2Arms dispose:)
		(super dispose:)
	)
)

(instance h3Mouth of Prop
	(properties
		view 840
		loop 6
		signal 26640
		cycleSpeed 3
	)

	(method (init)
		(super init: &rest)
		(self
			posn: (- (harpy3 x:) 6) (- (harpy3 y:) 20)
			priority: (+ (harpy3 priority:) 1)
		)
		(h3Arms init:)
	)

	(method (cue)
		(super cue: &rest)
		(if (not argc)
			(self setCycle: 0)
			(h3Arms setCycle: 0)
		else
			(self setCycle: RandCycle)
			(h3Arms setCycle: RandCycle)
		)
	)

	(method (dispose)
		(self setCycle: 0)
		(h3Arms dispose:)
		(super dispose:)
	)
)

(instance h4Mouth of Prop
	(properties
		view 840
		loop 6
		signal 26640
		cycleSpeed 3
	)

	(method (init)
		(super init: &rest)
		(self
			posn: (- (harpy4 x:) 7) (- (harpy4 y:) 21)
			priority: (+ (harpy4 priority:) 1)
		)
		(h4Arms init:)
	)

	(method (cue)
		(super cue: &rest)
		(if (not argc)
			(self setCycle: 0)
			(h4Arms setCycle: 0)
		else
			(self setCycle: RandCycle)
			(h4Arms setCycle: RandCycle)
		)
	)

	(method (dispose)
		(self setCycle: 0)
		(h4Arms dispose:)
		(super dispose:)
	)
)

(instance h1Arms of Prop
	(properties
		view 840
		loop 2
		signal 26640
		cycleSpeed 3
	)

	(method (init)
		(super init: &rest)
		(self
			posn: (+ (harpy1 x:) 1) (- (harpy1 y:) 23)
			priority: (+ (harpy1 priority:) 1)
		)
	)
)

(instance h2Arms of Prop
	(properties
		view 840
		loop 11
		signal 26640
		cycleSpeed 3
	)

	(method (init)
		(super init: &rest)
		(self
			posn: (- (harpy2 x:) 9) (- (harpy2 y:) 19)
			priority: (+ (harpy2 priority:) 1)
		)
	)
)

(instance h3Arms of Prop
	(properties
		view 840
		loop 7
		signal 26640
		cycleSpeed 3
	)

	(method (init)
		(super init: &rest)
		(self
			posn: (- (harpy3 x:) 7) (- (harpy3 y:) 17)
			priority: (+ (harpy3 priority:) 1)
		)
	)
)

(instance h4Arms of Prop
	(properties
		view 840
		loop 8
		signal 26640
		cycleSpeed 3
	)

	(method (init)
		(super init: &rest)
		(self
			posn: (- (harpy4 x:) 1) (- (harpy4 y:) 18)
			priority: (+ (harpy4 priority:) 1)
		)
	)
)

(instance swoop1 of Path
	(properties)

	(method (at param1)
		(return [local0 param1])
	)
)

(instance swoop2 of Path
	(properties)

	(method (at param1)
		(return [local7 param1])
	)
)

(instance harp of Prop
	(properties
		view 54
		loop 4
		signal 26624
	)
)

(instance room of RFeature
	(properties
		nsBottom 200
		nsRight 320
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (proc0_18 self event))
				(not (== (event type:) evVERB))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(if (gCast contains: harpy2)
						(PrintDC 90 22) ; "The sandy path ends at two narrow ledges overhanging the craggy island. Perched upon them, several monstrous harpies stare hungrily at Graham."
					else
						(PrintDC 90 23) ; "The sandy path ends at two narrow ledges overhanging the craggy island."
					)
					(event claimed: 1)
				)
				(5 ; Inventory
					(switch global69
						(10 ; Harp
							(HandsOff)
							(gCurRoom setScript: playHarpScript)
							(event claimed: 1)
						)
						(28 ; Wand
							(event claimed: 0)
						)
						(else
							(cond
								((not (gCast contains: harpy2)) 0)
								((== local22 1000)
									(cls)
									(PrintDC 90 24) ; "The hideous harpies don't pay any attention to it."
									(event claimed: 1)
								)
								(else
									(HandsOff)
									(= local22 (+ (argueScript state:) 1))
									(harpy1 setScript: wrongThingScript)
									(event claimed: 1)
								)
							)
						)
					)
				)
			)
		)
	)
)

(instance island of RFeature
	(properties)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (& (OnControl CONTROL (event x:) (event y:)) $0004))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 90 25) ; "In the distance, Graham can see a few islands."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance fishhook of Prop
	(properties
		y 160
		x 90
		view 652
		loop 4
		signal 24576
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (proc0_18 self event))
				(not (== (event type:) evVERB))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 90 26) ; "Half-hidden in the coarse island grass Graham notices an old fishhook."
					(event claimed: 1)
				)
				(3 ; Do
					(HandsOff)
					(gCurRoom setScript: getHookScript)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance note of Act
	(properties
		view 836
		loop 7
		signal 2048
		cycleSpeed 3
	)
)

(instance poly1 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly2 of Polygon
	(properties
		type PBarredAccess
	)
)

