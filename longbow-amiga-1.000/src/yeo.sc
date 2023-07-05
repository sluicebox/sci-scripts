;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 24)
(include sci.sh)
(use Main)
(use n013)
(use n121)
(use Wat)
(use verseScript)
(use rhEgo)
(use RTEyeCycle)
(use PChase)
(use PolyPath)
(use Polygon)
(use LoadMany)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	yeo 0
	yeoScript 1
)

(local
	[local0 9] = [133 0 2 4 24 37 20 24 16]
	[local9 9] = [133 3 2 4 24 37 20 24 16]
	local18
	local19
	local20
	local21 = 10
	local22
	[local23 6] = [1024 0 2 1 2 0]
	[local29 5] = [1024 3 1 2 0]
	[local34 5] = [1024 20 1 2 0]
	[local39 6] = [1024 5 2 1 2 0]
	[local45 10] = [1024 12 1 2 1 2 1 2 2 0]
	[local55 5] = [1024 10 1 1 0]
	[local60 4] = [1024 19 1 0]
	[local64 4] = [1024 22 1 0]
	[local68 6] = [1024 23 2 1 2 0]
	[local74 17] = [1024 26 1 2 1 2 1 2 1 2 1 2 1 2 2 2 0]
	[local91 6] = [1024 40 1 2 2 0]
	[local97 15] = [1024 43 1 2 1 1 1 2 1 2 1 2 1 1 0]
	[local112 12] = [1024 55 1 2 1 2 1 2 1 1 2 0]
	[local124 10] = [1024 64 3 1 1 1 2 1 2 0]
	[local134 7] = [1024 71 1 2 1 2 0]
	[local141 6] = [1024 75 2 1 2 0]
	[local147 4] = [1024 78 1 0]
	[local151 4] = [1024 79 1 0]
	[local155 7] = [1024 80 2 2 1 2 0]
	[local162 5] = [1024 84 2 1 0]
	[local167 4] = [1024 86 1 0]
)

(instance yeo of Actor
	(properties
		x 285
		y -5
		view 132
		loop 1
		signal 10240
	)

	(method (init)
		(gSFX number: 125 loop: -1 play:)
		(gTheIconBar disable: 5)
		(super init:)
	)

	(method (doit)
		(cond
			((and global199 (not (-- local21)) (not local22))
				(= local22 1)
				(= global199 0)
				(Converse @local39 3 @local0 0) ; "What's that ye be doing with your hand? I've never seen such a thing."
			)
			((and (not local20) (gEgo mover:) (not (gEgo script:)))
				(= local20 1)
				(if (<= (Wat weMeetAgain:) 1)
					(gEgo setScript: dropIt)
				else
					(gEgo setScript: noMoreChances)
				)
			)
		)
		(super doit:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1024 9 1) ; "He's a sturdy, honest looking fellow. His clothes are worn, but well mended."
			)
			(5 ; Talk
				(if (Wat charFirstTalk:)
					(Converse 1 @local55 @local0 3) ; "Ye waste me precious time, outlaw. I must reach the Nottingham Fair today or lose me chance at the golden arrow."
				else
					(Converse @local45 3 @local0) ; "What manner of archer are you, to think you can compete with the finest archers in the shire?"
					(Wat charFirstTalk: 1)
				)
			)
			(10 ; Longbow
				(gCurRoom setScript: twoBirds)
			)
			(4 ; Inventory
				(switch invItem
					(1 ; horn
						(Converse 1 @local60 @local0 3) ; "That's a fine horn, but I've nae use for it."
					)
					(0 ; bucks
						(gEgo setScript: buyClothes)
					)
					(14 ; amethyst
						(Converse @local23 3 @local0) ; "What's this then?"
					)
					(2 ; halfHeart
						(Converse @local23 3 @local0) ; "What's this then?"
					)
					(10 ; fireRing
						(Converse @local29 3 @local0) ; "If you'll bargain with me, I'll give you this."
					)
					(18 ; waterRing
						(Converse @local29 3 @local0) ; "If you'll bargain with me, I'll give you this."
					)
					(16 ; fulkScroll
						(Converse 1 @local64 @local0 3) ; "I don't know how to read."
					)
					(17 ; handScroll
						(Converse 1 @local64 @local0 3) ; "I don't know how to read."
					)
					(4 ; net
						(Converse @local68 3 @local0) ; "What's this? A net of solid gold!"
					)
					(12 ; puzzleBox
						(Converse @local34 1 @local0) ; "I'll give you this fine box in exchange for your clothes."
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(3 ; Do
				(gEgo setMotion: MoveTo (yeo x:) (yeo y:))
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (dispose)
		(gSFX fade: 0 30 8 1)
		(gCurRoom notify:)
		(self setCycle: 0 setMotion: 0)
		(if (Wat whichChar:)
			(Wat weMeetAgain: (+ (Wat weMeetAgain:) 1))
		)
		(super dispose:)
		(self delete:)
		(gTheIconBar enable: 5)
		(DisposeScript 24)
	)
)

(instance yeoScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo actions: egoActions)
				(Wat setScript: 0)
				(if (Wat weMeetAgain:)
					(client setScript: repeatEncounter)
				else
					(if (not (gCast contains: yeo))
						(yeo init:)
					)
					(yeo
						posn: 235 50
						setCycle: Walk
						setMotion: MoveTo 205 70 self
					)
				)
			)
			(1
				(yeo ignoreActors: 1 setLoop: 0 setCel: 0 setCycle: End self)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 202 52 243 52 243 65 202 65
							yourself:
						)
				)
			)
			(2
				(Converse @local74 3 @local0 self) ; "I bid you welcome to Sherwood Forest, good Yeoman."
				0
				1
			)
			(3
				(HandsOn)
				(gTheIconBar disable: 5)
				(self dispose:)
			)
		)
	)
)

(instance repeatEncounter of TScript
	(properties)

	(method (dispose)
		(HandsOn)
		(gTheIconBar disable: 5)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(gEgo actions: egoActions)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 202 52 243 52 243 65 202 65
							yourself:
						)
				)
				(= ticks 30)
			)
			(2
				(Converse @local91 3 @local0) ; "Ho, good Yeoman. Let us talk again."
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance buyClothes of Script
	(properties)

	(method (dispose)
		(HandsOn)
		(SetFlag 57)
		(proc125_2)
		(SetIcon 0)
		((ScriptID 20) dispose:) ; Will
		(super dispose:)
		(yeo dispose:)
	)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(HandsOff)
				(Converse @local97 3 @local0) ; "I'll make you a bargain. You see, I've a need to enter Nottingham today, and your clothes would make a fine disguise."
				(yeo stopUpd:)
				(self setScript: (ScriptID 5 1) self) ; blowinIt
			)
			(1
				(= ticks 12)
			)
			(2
				(gEgo stopUpd:)
				(self setScript: (ScriptID 125 1) self) ; merryMenEntrance
			)
			(3
				((ScriptID 23) setMotion: PChase gEgo 30 self) ; Tuck
				(Face gEgo (ScriptID 23)) ; Tuck
			)
			(4
				(Converse @local112 3 15 self) ; "This good Yeoman has made a fair bargain with me. Tuck, I've promised him a purse of silver worth 50 marks."
			)
			(5
				(gSFX number: 128 loop: -1 play:)
				(= cycles 2)
			)
			(6
				(gCurRoom drawPic: 803 -32761)
				(yeo setLoop: 3 posn: 219 64)
				(= gDisguiseNum 4) ; yeoman
				(gInventory eachElementDo: #perform (ScriptID 125 3)) ; putStuff
				(NormalEgo)
				(gEgo loop: 4 cel: 0 posn: 188 55)
				(gEgoHead posn: 188 55)
				(gCast eachElementDo: #hide)
				((ScriptID 23) dispose:) ; Tuck
				((ScriptID 19) dispose:) ; John
				(= ticks 60)
			)
			(7
				(gCast eachElementDo: #show)
				((ScriptID 20) loop: 1 posn: 249 74) ; Will
				(gCurRoom drawPic: 120 -32761)
				(proc121_0)
				(= ticks 12)
			)
			(8
				(Converse 3 @local124 6 2 @local9 3 14 3 self) ; "The eyepatch has completed your disguise nicely, Robin. But if you enter the tournament--"
			)
			(9
				(SetScore 100)
				(yeo
					setLoop: 2
					ignoreHorizon: 1
					setCycle: Walk
					setMotion: MoveTo 285 -5 self
				)
				((ScriptID 20) setMotion: MoveTo (yeo x:) (yeo y:) self) ; Will
			)
			(10
				((ScriptID 20) setMotion: MoveTo 285 -5 self) ; Will
			)
			(11)
			(12
				(self dispose:)
			)
		)
	)
)

(instance twoBirds of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(LoadMany rsVIEW 4 5 792)
				(HandsOff)
				(Converse @local134 2 @local0) ; "I've a need for those clothes you wear. Will you give them to me, or must I test your courage?"
				(= ticks 30)
			)
			(1
				(gEgo view: 4 setCel: 0 cycleSpeed: 3 setCycle: CT 2 1 self)
			)
			(2
				(gEgo setCycle: End self)
				(yeo setLoop: 4 setCel: 0 cycleSpeed: 3 setCycle: End self)
			)
			(3
				(shootSound play:)
				(gEgo view: 5 setCel: 0 setCycle: End)
			)
			(4
				(= ticks 30)
			)
			(5
				(gEgo
					view: 792
					setLoop: 0
					setCel: 0
					cycleSpeed: 12
					setCycle: CT 6 1 self
				)
				(shootSound number: 907 loop: 1 play:)
				(yeo setLoop: 5 setCel: 0 cycleSpeed: 12 setCycle: End)
			)
			(6
				(gSFX number: 127 loop: -1 play:)
				(gEgo setCel: 7)
				((View new:)
					view: 792
					loop: 4
					cel: 2
					posn: (- (gEgo x:) 33) (+ (gEgo y:) 6)
					init:
				)
				(= ticks 60)
			)
			(7
				(= gDeathNum 2)
				(shootSound dispose:)
				(gCurRoom newRoom: 170) ; robinDeath
			)
		)
	)
)

(instance egoSkewered of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(self setScript: (ScriptID 5 1) self) ; blowinIt
			)
			(1
				(= ticks 30)
			)
			(2
				(Converse @local141 3 @local0 self) ; "Why do ye sound that horn?"
			)
			(3
				(yeo setLoop: 4 setCel: 0 cycleSpeed: 3 setCycle: End self)
			)
			(4
				(shootSound number: 907 loop: 1 play:)
				(gGame setSpeed: global141)
				(gEgo
					view: 792
					setLoop: 0
					setCel: 0
					cycleSpeed: 12
					setCycle: CT 6 1 self
				)
				(= ticks 30)
			)
			(5
				(yeo cycleSpeed: 6 setCycle: Beg)
			)
			(6
				(gEgo setCel: 7)
				((View new:)
					view: 792
					loop: 4
					cel: 2
					posn: (- (gEgo x:) 33) (+ (gEgo y:) 6)
					init:
				)
				(= ticks 30)
			)
			(7
				(gSFX number: 127 loop: -1 play:)
				(Converse 1 @local147 @local0 3 self) ; "Bloody stupid outlaw. D'ye think I'd stand here and be surrounded like a lamb to slaughter?"
			)
			(8
				(= gDeathNum 1)
				(shootSound dispose:)
				(gCurRoom newRoom: 170) ; robinDeath
			)
		)
	)
)

(instance noMoreChances of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 20)
			)
			(1
				(yeo setLoop: 4 setCel: 0 cycleSpeed: 3 setCycle: End self)
				(gEgo setMotion: 0)
				(Face gEgo yeo)
			)
			(2
				(shootSound number: 907 loop: 1 play:)
				(yeo cel: 4)
				(gEgo
					view: 792
					setLoop: 0
					setCel: 0
					cycleSpeed: 12
					setCycle: End self
				)
				(= ticks 48)
			)
			(3
				(yeo cycleSpeed: 12 setCycle: Beg)
			)
			(4
				(= ticks 30)
			)
			(5
				(Converse 1 @local151 @local0 3 self) ; "Bloody thick-headed for an outlaw, 'e was."
			)
			(6
				(= gDeathNum 1)
				(shootSound dispose:)
				(gCurRoom newRoom: 170) ; robinDeath
			)
		)
	)
)

(instance dropIt of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(yeo dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gGame setSpeed: global141)
				(= ticks 30)
			)
			(1
				(gEgo setCycle: 0 setMotion: 0)
				(yeo setLoop: 4 setCel: 0 cycleSpeed: 3 setCycle: CT 5 1 self)
			)
			(2
				(shootSound number: 900 loop: -1 play:)
				(Converse @local155 1 @local0) ; "Stand fast! I'll take no chances with ye, outlaw, for time's a-wasting."
				(= ticks 30)
			)
			(3
				(gEgo setHeading: 45 self)
			)
			(4
				(= ticks 60)
			)
			(5
				(gEgo
					view: 15
					posn: (+ (gEgo x:) 5) (+ (gEgo y:) 5)
					setLoop: 2
					setCel: 0
					cycleSpeed: 12
					setCycle: End self
				)
				((= local18 (Prop new:))
					view: 15
					ignoreActors: 1
					posn: (gEgo x:) (gEgo y:)
					loop: 6
					cel: 0
					cycleSpeed: 12
					init:
					setCycle: End
				)
			)
			(6
				(gEgo setCycle: Beg self)
			)
			(7
				(gEgo
					posn: (- (gEgo x:) 9) (- (gEgo y:) 3)
					setLoop: 3
					setCycle: CT 5 1 self
				)
			)
			(8
				(NormalEgo 2 702 703)
				(Face gEgo yeo self)
				((= local19 (View new:))
					view: 15
					ignoreActors: 1
					posn: (+ (gEgo x:) 6) (+ (gEgo y:) 2)
					loop: 4
					cel: 0
					init:
				)
			)
			(9
				(= ticks 12)
			)
			(10
				(Converse @local162 1 @local0) ; "Stand ye aside and make no move until I am gone."
				(= ticks 30)
			)
			(11
				(gGame setSpeed: global157)
				(gEgo
					setMotion:
						PolyPath
						(if (< (gEgo x:) 160) 10 else 305)
						(gEgo y:)
						self
				)
			)
			(12
				(Face gEgo yeo self)
			)
			(13
				(= ticks 12)
			)
			(14
				(Converse @local167 1) ; "The road is yours."
				(local19 setPri: 0)
				(local18 setPri: 0)
				(yeo cycleSpeed: 6 setCycle: Beg self)
			)
			(15
				(shootSound stop: dispose:)
				(yeo
					setLoop: 1
					cycleSpeed: global157
					moveSpeed: global157
					setCycle: Walk
					setMotion: MoveTo -10 235 self
				)
			)
			(16
				(gEgo
					setMotion:
						PolyPath
						(- (local19 x:) 6)
						(- (local19 y:) 2)
						self
				)
			)
			(17
				(gEgo
					view: 15
					setLoop: 3
					setCel: 5
					cycleSpeed: 12
					setCycle: Beg self
				)
				(local19 dispose:)
			)
			(18
				(gEgo
					setLoop: 2
					setCel: 0
					posn: (+ (gEgo x:) 9) (+ (gEgo y:) 3)
					setCycle: End self
				)
			)
			(19
				(gEgo setCycle: Beg self)
				(local18 setCycle: Beg)
			)
			(20
				(local18 dispose:)
				(gEgo posn: (- (gEgo x:) 5) (- (gEgo y:) 5))
				(NormalEgo)
				(= ticks 30)
			)
			(21
				(if (not (Wat weMeetAgain:))
					(Say 1024 87 self) ; "By the Virgin, I admire a man so bold as to hold me at bay!"
				else
					(+= state 1)
					(self cue:)
				)
			)
			(22
				(Say 1024 88 self) ; "He's hurried on, but if I'm clever, I can yet catch him further south upon the street."
			)
			(23
				(Wat
					setScript: (Wat theTimer:)
					hurry: 1
					charObj: 0
					travelSect: (+ (Wat section:) 1)
				)
				(HandsOn)
				(SetIcon 0)
				(self dispose:)
			)
		)
	)
)

(instance egoActions of SpecialDoVerb
	(properties)

	(method (doVerb theVerb invItem)
		(return
			(switch theVerb
				(3 ; Do
					(if (and (IsFlag 34) local22)
						(Say 1024 8 1) ; "Clearly, he knows nothing of the Hand Code. I've no need to test him again."
					)
				)
				(4 ; Inventory
					(if (== invItem 1) ; horn
						(gEgo setScript: egoSkewered)
						1
					)
				)
			)
		)
	)
)

(instance shootSound of Sound
	(properties
		flags 1
		number 906
	)
)

