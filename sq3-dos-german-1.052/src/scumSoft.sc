;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 702)
(include sci.sh)
(use Main)
(use Interface)
(use FileSelector)
(use Chase)
(use Timer)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	scumSoft 0
)

(local
	local0
	local1
	local2
	local3
	[local4 63] = [0 10 161 0 41 160 0 74 154 1 101 149 1 123 145 1 145 136 2 166 128 2 182 110 2 194 98 3 203 75 3 208 55 3 203 34 3 191 17 4 174 8 4 159 11 4 146 16 4 136 27 5 136 40 5 140 51 5 148 54 5 161 57]
)

(instance scumSoft of Rgn
	(properties)

	(method (init)
		(SL enable:)
		(super init: &rest)
		(= global56 0)
		(HandsOn)
		(Load rsVIEW 92)
		(Load rsVIEW 0)
		(Load rsVIEW 256)
		(Load rsVIEW 113)
		(Load rsVIEW 114)
		(Load rsVIEW (LangSwitch 115 323))
		(Load rsSOUND 46)
		(Load rsSOUND 47)
		(Load rsSOUND 44)
		(Load rsSOUND 55)
		(Load rsSOUND 84)
		(Load rsSOUND 102)
		(Load rsSOUND 103)
		(jelloSound init:)
		(vaporizeSound init:)
		(if (not (== gCurRoomNum 93))
			(gLongSong number: 102 loop: -1 play:)
		else
			(gLongSong stop:)
		)
		(announce state: global242)
		(if global233
			(if (== gPrevRoomNum 90)
				(= global233 0)
				(= global236 0)
				(= global237 0)
			else
				(if (== 0 global236 global237)
					(= global236 166)
					(= global237 97)
				)
				(User canInput: 0)
				(droidScript changeState: 1)
			)
		)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return)
		)
		(switch (event type:)
			(evSAID
				(cond
					(
						(Said
							'look,look[/area,department,deck,dirt,ceiling,left,right,up,down]'
						)
						(Print 702 0) ; "You are in the cost-efficient corporate accounting department of ScumSoft, Inc. These hard-working accountants are trying to figure out where the company spends its money."
					)
					((Said 'look,look/partition,partition')
						(Print 702 1) ; "Just another section in this maze of partitions."
					)
					((Said '/cabinet,cabinet')
						(Print 702 2) ; "The cabinet is locked (regardless, you wouldn't find anything useful)."
					)
					(
						(Said
							'talk,talk,look,look/man,folk,bystander,accountant,programmer'
						)
						(Print 702 3) ; "Everyone here looks related. It's like a secret society of nerds."
					)
					((Said 'look,look/junk,debris,can,can,basket')
						(Print 702 4) ; "Such a sight."
					)
					(
						(Said
							'look,look/chart,paper,passenger,calendar,board,board,desk,chair'
						)
						(Print 702 5) ; "Look but don't touch."
					)
					(
						(Said
							'sit,explore,get,get,hit,hit,get,feel/chart,passenger,calendar,board,board,chair,man,desk,paper,partition'
						)
						(Print 702 6) ; "Hardly an appropriate action for a janitor."
					)
				)
			)
		)
	)

	(method (doit)
		(if (and (not global233) (== 700 (Random 1 1400)))
			(announce cue:)
		)
	)
)

(instance announce of Script
	(properties)

	(method (changeState newState)
		(++ global242)
		(switch (= state newState)
			(1
				(Print 702 7) ; "Attention Attention: We have a very special birthday today! Our founder Mr. Pug has just turned 14; so stop by and give Elmo a big ol' hug."
			)
			(2
				(Print 702 8) ; "Attention everyone: Mr. Pug has just announced that Sunday will be a half-day!"
			)
		)
	)
)

(class TrashBasket of Prop
	(properties
		vaporized 0
		misses 0
		egoHere 0
		egoNear 0
		myNerd 0
		myID 0
		nearWest 0
		nearNorth 0
		nearEast 0
		nearSouth 0
	)

	(method (init)
		(super init:)
		(self
			vaporized: [global567 myID]
			view: (LangSwitch 115 323)
			ignoreActors: 0
			setLoop: 4
			setCel: [global567 myID]
			stopUpd:
		)
		(if (and vaporized myID)
			(self addToPic:)
		)
	)

	(method (doit)
		(cond
			(global233
				(self egoNear: 0)
			)
			(
				(and
					(<= nearWest (gEgo x:) nearEast)
					(<= nearNorth (gEgo y:) nearSouth)
				)
				(if
					(and
						(gEgo has: 12) ; Coveralls
						(gEgo has: 13) ; Vaporizer
						(not vaporized)
						myNerd
					)
					(self egoNear: 1)
				)
			)
			((and egoNear (not vaporized) myNerd)
				(self egoNear: 0)
				(alertScript init: (self myNerd:))
			)
			(
				(and
					(not (gEgo mover:))
					(not global243)
					(not global233)
					myNerd
					(== 50 (Random 1 100))
				)
				(myNerd setCel: (if (myNerd cel:) 0 else 3))
				(if (and (not (== gCurRoomNum 93)) (== 1 (Random 1 2)))
					(gLongSong
						number: (if (== 1 (Random 1 2)) 103 else 102)
						play:
					)
				)
			)
		)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return)
		)
		(switch (event type:)
			(evSAID
				(if (gEgo has: 13) ; Vaporizer
					(cond
						((Said 'look,look/debris<mr')
							((gInventory at: 13) showSelf:) ; Vaporizer
						)
						(
							(or
								(Said 'blast[/junk,debris]')
								(Said 'use/mrgarbage')
								(Said 'use/debris<mr')
							)
							(if (self perform: egoIsHere species)
								(self egoHere: 1)
							)
							(self vaporize:)
						)
						((Said 'blast/')
							(Print 702 9) ; "Mr. Garbage is not a toy!"
						)
					)
				)
			)
		)
	)

	(method (vaporize)
		(HandsOff)
		(gEgo view: 114 setCel: 0 setCycle: End self)
		(vaporizeSound play:)
	)

	(method (cue)
		(cond
			(egoHere
				(if vaporized
					(Print 702 10) ; "Tsk. Tsk. Such a waste of vaporfuel."
				else
					(self vaporized: 1 setCel: (= [global567 myID] 1) misses: 0)
					(cond
						((not (== gCurRoomNum 93))
							(self addToPic:)
						)
						((not myNerd)
							(Print 702 11) ; "Aren't you taking this janitor-bit a little too seriously?"
						)
					)
				)
				(self egoHere: 0)
			)
			(egoNear
				(switch (++ misses)
					(1
						(Print 702 12) ; "Oops! You missed."
					)
					(2
						(Print 702 13) ; "William Tell you are not."
					)
					(3
						(Print 702 14) ; "Stand closer -- it's shorter than you think."
					)
					(4
						(Print 702 15) ; "You just put a nasty burn mark in the carpet."
					)
					(5
						(Print 702 16) ; "You're starting to arouse suspicion with your marksmanship."
					)
					(6
						(if global233
							(-- misses)
						else
							(self egoNear: 0)
							(alertScript init: (self myNerd:))
						)
					)
				)
			)
			(else
				(Print 702 17) ; "That didn't accomplish much."
			)
		)
		(gEgo view: 113 cycleSpeed: 0 setCycle: Walk)
		(HandsOn)
	)
)

(instance egoIsHere of Code
	(properties)

	(method (doit param1)
		(if global233
			(return 0)
		)
		(switch (gEgo loop:)
			(0
				(if
					(or
						(> (gEgo brTop:) (param1 brBottom:))
						(< (gEgo brBottom:) (param1 brTop:))
						(> (gEgo brRight:) (param1 brLeft:))
						(<
							(+ (gEgo brRight:) (gEgo xStep:))
							(param1 brLeft:)
						)
					)
					(return 0)
				)
			)
			(1
				(if
					(or
						(> (gEgo brTop:) (param1 brBottom:))
						(< (gEgo brBottom:) (param1 brTop:))
						(< (gEgo brLeft:) (param1 brRight:))
						(>
							(- (gEgo brLeft:) (gEgo xStep:))
							(param1 brRight:)
						)
					)
					(return 0)
				)
			)
			(2
				(if
					(or
						(< (gEgo brRight:) (param1 brLeft:))
						(> (gEgo brLeft:) (param1 brRight:))
						(> (gEgo brBottom:) (param1 nsTop:))
						(<
							(+ (gEgo brBottom:) (gEgo yStep:))
							(param1 nsTop:)
						)
					)
					(return 0)
				)
			)
			(3
				(if
					(or
						(< (gEgo brRight:) (param1 brLeft:))
						(> (gEgo brLeft:) (param1 brRight:))
						(< (gEgo brTop:) (param1 nsBottom:))
						(>
							(- (gEgo brTop:) (gEgo yStep:))
							(param1 nsBottom:)
						)
					)
					(return 0)
				)
			)
		)
		(return 1)
	)
)

(class Nerd of Prop
	(properties
		seeProblem 0
		speakX 0
		speakY 0
		speakCel 0
	)

	(method (init)
		(super init:)
		(self view: (LangSwitch 115 323) setCel: 0 stopUpd:)
	)
)

(class Fink of Act
	(properties
		seeProblem 0
		speakX 0
		speakY 0
		speakCel 0
	)

	(method (init)
		(super init:)
		(self view: (LangSwitch 115 323) xStep: 4 stopUpd:)
	)

	(method (doit)
		(super doit:)
		(if seeProblem
			(if global233
				(= seeProblem 0)
			else
				(alertScript init: self)
			)
		)
	)
)

(instance alertScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(User canInput: 0)
				(= global233 1)
				(gEgo setMotion: 0)
				(= local0 (self client:))
				(alertBalloon init:)
				(gLongSong number: 84 loop: -1 play:)
				(= local1 5)
				(if (> (local0 loop:) 3)
					(self cue:)
				else
					(local0 setCycle: End self)
				)
			)
			(1
				(if (and (-- local1) (not (gEgo mover:)))
					(-- state)
					(Timer setReal: self 2)
				else
					(= cycles 1)
				)
			)
			(2
				(if (> (local0 loop:) 3)
					(= cycles 1)
				else
					(local0 setCycle: Beg self)
				)
			)
			(3
				(local0 stopUpd:)
				(alertBalloon dispose:)
				(if (< (local0 loop:) 3)
					(Print 702 18) ; "Uh-oh! You're in deep trouble now. These guys know that a real janitor would never bypass a full waste basket."
				)
				(gCurRoom setScript: droidScript)
			)
		)
	)
)

(instance alertBalloon of View
	(properties)

	(method (init)
		(super init:)
		(self
			posn: (local0 speakX:) (local0 speakY:)
			view: (LangSwitch 115 323)
			setLoop: (if (== gCurRoomNum 93) 9 else 5)
			setCel: (local0 speakCel:)
			setPri: 15
			stopUpd:
		)
	)
)

(instance shadowDroid of Act
	(properties)

	(method (init)
		(super init:)
		(self
			setPri: 0
			view: 256
			setLoop: 2
			setCel: 1
			setCycle: Fwd
			xStep: (if (gEgo has: 12) 3 else 8) ; Coveralls
			yStep: (if (gEgo has: 12) 2 else 5) ; Coveralls
			ignoreHorizon: 1
			ignoreActors: 1
			ignoreControl: -1
		)
		(cond
			((== global236 global237 0)
				(self posn: (+ (swoopDroid x:) 5) (+ (swoopDroid y:) 40))
				(swoopDroid dispose:)
			)
			((or (== gPrevRoomNum 90) (== gPrevRoomNum 94))
				(self posn: global236 global237)
			)
			(else
				(switch (gEgo loop:)
					(0
						(self
							posn:
								(if (>= global236 0)
									(- global236 320)
								else
									global236
								)
								global237
						)
					)
					(1
						(self
							posn:
								(if (<= global236 320)
									(+ global236 320)
								else
									global236
								)
								global237
						)
					)
					(2
						(self
							ignoreHorizon: 1
							posn:
								global236
								(if (>= global237 0)
									(- global237 190)
								else
									global237
								)
						)
					)
					(3
						(self
							posn:
								global236
								(if (<= global237 190)
									(+ global237 190)
								else
									global237
								)
						)
					)
				)
			)
		)
	)
)

(instance securityDroid of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			setPri:
				(if (and (not (== gCurRoomNum 93)) (< (gEgo y:) 116))
					14
				else
					15
				)
			view: 256
			setLoop: 1
			doit:
		)
	)

	(method (doit)
		(= global236 (shadowDroid x:))
		(= global237 (shadowDroid y:))
		(self posn: global236 (- global237 40) setCel: (shadowDroid cel:))
	)
)

(instance swoopDroid of Prop
	(properties)

	(method (init)
		(super init:)
		(self setPri: 15 view: 256 setLoop: 0 ignoreActors: 1)
	)

	(method (doit)
		(if (not local2)
			(return)
		)
		(if (<= 0 local3 62)
			(if (> local2 0)
				(self
					setCel: [local4 local3]
					x: [local4 (++ local3)]
					y: [local4 (++ local3)]
				)
				(++ local3)
			else
				(self
					y: [local4 local3]
					x: (- 320 [local4 (-- local3)])
					setCel: [local4 (-- local3)]
				)
				(-- local3)
			)
		else
			(= local2 0)
			(droidScript cue:)
		)
	)
)

(instance zapper of Prop
	(properties)

	(method (init)
		(super init:)
		(shadowDroid posn: (gEgo x:) (gEgo y:))
		(self
			setPri: (gEgo priority:)
			view: 256
			posn: (+ (shadowDroid x:) 1) (- (shadowDroid y:) 20)
			setLoop: 3
			setCycle: Fwd
			ignoreActors: 1
		)
	)

	(method (doit)
		(super doit:)
		(if (gEgo has: 12) ; Coveralls
			(gEgo
				view: (if cel 113 else 92)
				setLoop: (if cel 2 else 5)
				setCel: 0
			)
		else
			(gEgo view: (if cel 0 else 92) setLoop: 2 setCel: 0)
		)
	)
)

(instance droidScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local2 1)
				(= local3 0)
				(gLongSong number: 46 loop: 1 play:)
				(swoopDroid init:)
			)
			(1
				(gLongSong number: 47 loop: -1 play:)
				(shadowDroid init:)
				(securityDroid init:)
				(= local1 6)
				(self cue:)
			)
			(2
				(if
					(and
						(-- local1)
						(not (gEgo mover:))
						(== global236 166)
						(== global237 97)
					)
					(-- state)
					(Timer setReal: self 2)
				else
					(self cue:)
				)
			)
			(3
				(shadowDroid setMotion: Chase gEgo 0 self)
			)
			(4
				(if
					(or
						(& (gEgo onControl: -1) $0002)
						(>= (gEgo y:) 191)
						(>= (gEgo x:) 320)
					)
					(-= state 2)
				else
					(HandsOff)
				)
				(Timer setCycle: self 1)
			)
			(5
				(zapper init:)
				(jelloSound play:)
				(Timer setCycle: self 4)
			)
			(6
				(if (!= (jelloSound prevSignal:) -1)
					(-- state)
					(Timer setCycle: self 4)
				else
					(zapper dispose:)
					(jelloSound stop:)
					(Timer setCycle: self 1)
				)
			)
			(7
				(gEgo
					view: 92
					setLoop: (if (gEgo has: 12) 5 else 2) ; Coveralls
					setCycle: Fwd
					cycleSpeed: 2
				)
				(Timer setCycle: self 1)
			)
			(8
				(shadowDroid
					xStep: 6
					yStep: 4
					setMotion: MoveTo (- [local4 61] 3) (+ [local4 62] 40) self
				)
			)
			(9
				(securityDroid dispose:)
				(shadowDroid dispose:)
				(gLongSong number: 46 loop: 1 play:)
				(= local2 -1)
				(= local3 62)
				(swoopDroid init:)
			)
			(10
				(swoopDroid dispose:)
				(if (not (== gCurRoomNum 93))
					(gLongSong number: 102 loop: -1 play:)
				)
				(= global233 0)
				(Timer setReal: self 6)
			)
			(11
				(gLongSong stop:)
				(EgoDead 901 0 7 (if (gEgo has: 12) 9 else 15)) ; Coveralls
			)
		)
	)
)

(instance jelloSound of Sound
	(properties
		number 44
		priority 3
	)
)

(instance vaporizeSound of Sound
	(properties
		number 55
		priority 2
	)
)

