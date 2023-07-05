;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 640)
(include sci.sh)
(use Main)
(use KQ6Print)
(use KQ6Room)
(use n913)
(use Scaler)
(use MCyc)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Rev)
(use Motion)
(use Actor)
(use System)

(public
	rm640 0
)

(local
	[local0 4] = [0 -3 12 11]
	[local4 4] = [0 8 9 9]
	[local8 37] = [2 0 124 93 2 1 128 74 2 2 143 61 2 3 152 60 2 4 153 75 2 5 154 94 2 6 159 121 2 7 161 149 2 8 159 167 -32768]
	[local45 17] = [2 9 166 154 2 10 178 153 2 11 182 156 2 12 185 167 -32768]
	[local62 41] = [0 0 194 135 0 1 197 135 0 2 214 120 0 3 226 116 0 4 226 110 0 5 238 95 0 6 252 87 0 7 239 108 0 8 205 130 0 9 205 130 -32768]
)

(instance rm640 of KQ6Room
	(properties
		noun 3
		picture 640
		horizon 0
		north 650
		south 630
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 189 0 -10 319 -10 319 189 227 189 191 160 181 142 149 120 156 108 140 98 148 91 142 86 142 42 135 42 135 87 119 95 119 99 135 107 121 117 122 126 132 139 142 150 142 175 27 175 49 189
					yourself:
				)
		)
		(super init: &rest)
		(Lock rsMESSAGE modNum 0)
		(gTheIconBar enable:)
		(gGame handsOff:)
		(gEgo init: reset: 3 setScale: Scaler 100 70 200 70)
		(doorMaster
			init:
			signal: (| (doorMaster signal:) $1000)
			approachVerbs: 2 0 ; Talk
		)
		(keyMaster init: signal: (| (keyMaster signal:) $1000) approachVerbs: 2) ; Talk
		(cond
			((gEgo has: 44) 0) ; skeletonKey
			((IsFlag 115)
				(boneKey
					init:
					view: 647
					setLoop: 0
					cel: 1
					posn: (+ (keyMaster x:) 78) (+ (keyMaster y:) 1)
					noun: 7
					ignoreActors: 1
				)
			)
			(else
				(boneKey
					init:
					posn: (+ (keyMaster x:) 16) (- (keyMaster y:) 14)
					ignoreActors: 1
				)
			)
		)
		(skelLeft init:)
		(skelRight init:)
		(boneMallet init:)
		(ghost init: setScript: ghostScr)
		(door init:)
		(theSkull init:)
		(xylophone init:)
		(if (IsFlag 44)
			(gGlobalSound stop:)
			(gGlobalSound2 stop:)
			(gGlobalSound3 stop:)
			(gGlobalSound4 stop:)
			(self setScript: deathCartoonScr)
		else
			(gEgo setScript: musicStuffScript)
			(lineGhost init: setScript: ghostLineScr)
			(switch gPrevRoomNum
				(650
					(gEgo posn: 133 97)
				)
				(else
					(gEgo posn: 109 187)
				)
			)
		)
	)

	(method (doit &tmp temp0)
		(super doit: &rest)
		(= temp0 (gEgo onControl: 1))
		(cond
			(script 0)
			((== temp0 16384)
				(gGame handsOff:)
				(self setScript: goNoFarther)
			)
		)
	)

	(method (dispose)
		(super dispose: &rest)
		(LoadMany 0 969 942)
	)
)

(instance musicStuffScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlobalSound number: 640 loop: 1 play: self)
			)
			(1
				(gGlobalSound stop:)
				(gGlobalSound number: 600 loop: -1 play:)
				(self dispose:)
			)
		)
	)
)

(instance goNoFarther of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(doorMaster
					view: 6407
					loop: 0
					cel: 0
					posn: (+ (doorMaster x:) 6) (+ (doorMaster y:) 19)
					setCycle: End self
				)
			)
			(1
				(= ticks 30)
			)
			(2
				(gEgo setHeading: 45 self)
			)
			(3
				(= ticks 15)
			)
			(4
				(gMessager say: 8 3 0 2 self) ; "Ticket, please!"
			)
			(5
				(if (> (gEgo x:) 129)
					(gEgo
						setLoop: 6
						setCycle: Rev
						setMotion:
							MoveTo
							(- (gEgo x:) 4)
							(+ (gEgo y:) 7)
							self
					)
				else
					(gEgo
						setLoop: 3
						setCycle: Rev
						setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 7) self
					)
				)
			)
			(6
				(gEgo setCycle: 0 setLoop: -1)
				(doorMaster cel: 5 setCycle: Beg self)
			)
			(7
				(doorMaster
					view: 642
					loop: 0
					cel: 0
					posn: (- (doorMaster x:) 6) (- (doorMaster y:) 19)
				)
				(= cycles 1)
			)
			(8
				(gEgo reset: 6)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance deathCartoonScr of Script
	(properties)

	(method (doit)
		(super doit:)
		(cond
			((or (gEgo has: 44) (IsFlag 115)) 0) ; skeletonKey
			((== (keyMaster view:) 6404)
				(boneKey posn: (+ (keyMaster x:) 14) (- (keyMaster y:) 14))
			)
			((== (keyMaster loop:) 1)
				(switch (keyMaster cel:)
					(7
						(boneKey
							posn: (+ (keyMaster x:) 9) (- (keyMaster y:) 16)
						)
					)
					(9
						(boneKey
							posn: (+ (keyMaster x:) 9) (- (keyMaster y:) 18)
						)
					)
					(10
						(boneKey
							posn: (+ (keyMaster x:) 16) (- (keyMaster y:) 14)
						)
					)
				)
			)
			((== (keyMaster loop:) 2)
				(boneKey posn: (+ (keyMaster x:) 13) (- (keyMaster y:) 16))
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlobalSound loop: 1 number: 975 flags: 1 play:)
				(keyMaster view: 643 loop: 1 cel: 0 setCycle: End self)
				(gEgo
					posn: 146 174
					view: 6402
					loop: 0
					cel: 0
					normal: 0
					cycleSpeed: 15
					setCycle: CT 4 1 self
				)
			)
			(1 0)
			(2
				(keyMaster loop: 1 cel: 0)
				(gEgo setCycle: End self)
			)
			(3
				(keyMaster
					view: 6404
					loop: 0
					cel: 0
					posn: (keyMaster x:) (- (keyMaster y:) 3)
				)
				(gEgo posn: 142 133 loop: 1 cel: 0 setCycle: CT 1 1 self)
			)
			(4
				(self setScript: modeLessScript)
				(doorMaster view: 6406 loop: 0 cel: 0 setCycle: CT 2 1 self)
			)
			(5
				(doorMaster setCycle: End)
				(gEgo setCycle: End self)
			)
			(6
				(doorMaster loop: 1 cel: 0 setCycle: End self)
			)
			(7
				(modeLessScript cue:)
				(doorMaster view: 6406 loop: 0 cel: 0)
				(gEgo loop: 2 cel: 0 cycleSpeed: 10 setCycle: End self)
			)
			(8
				(door setCycle: End self)
			)
			(9
				(gEgo dispose:)
				(door setCycle: Beg self)
			)
			(10
				(gCast eachElementDo: #addToPic)
				(= seconds 3)
			)
			(11
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(gGame setCursor: gNormalCursor)
				(repeat
					(switch
						(KQ6Print
							posn: -1 10
							addIcon: 649 0 0 67 1
							say: 0 0 global160 1 0 40 916
							addButton: 1 {Restore} 0 85
							addButton: 2 {Restart} 67 85
							addButton: 3 {Quit} 134 85
							init:
						)
						(1
							(gGame restore:)
						)
						(2
							(gGame restart: 1)
						)
						(3
							(= gQuit 1)
							(break)
						)
					)
				)
			)
		)
	)
)

(instance modeLessScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(KQ6Print
					font: gUserFont
					posn: 200 100
					say: 1 0 1 1 ; MISSING MESSAGE
					modeless: 1
					init:
				)
				(= seconds 3)
			)
			(1
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
			)
			(2
				(KQ6Print
					font: gUserFont
					posn: 200 100
					say: 1 0 1 2 ; MISSING MESSAGE
					modeless: 1
					init:
				)
				(= seconds 3)
			)
			(3
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
			)
		)
	)
)

(instance egoGiveTicketScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame givePoints: 3)
				(gEgo put: 28 640) ; ticket
				(gEgo setMotion: PolyPath 145 133 self)
			)
			(1
				(= cycles 2)
			)
			(2
				(gMessager say: 5 49 0 1 self) ; "I have a ticket."
			)
			(3
				(gEgo setHeading: 0 self)
			)
			(4
				(self setScript: takeTicketScr self)
			)
			(5
				(takeTicketScr cue:)
			)
			(6
				(gMessager say: 5 49 0 2 self) ; "Go on! Next!"
			)
			(7
				(gEgo reset: 0)
				(= cycles 1)
			)
			(8
				(gEgo setMotion: PolyPath 139 90 self)
			)
			(9
				(door setCycle: End self)
			)
			(10
				(gEgo dispose:)
				(door setCycle: Beg self)
			)
			(11
				(gCurRoom newRoom: (gCurRoom north:))
			)
		)
	)
)

(instance takeTicketScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (!= client egoGiveTicketScr)
					(gMessager say: 1 0 2 2 self) ; "Ticket, please!"
				else
					(= cycles 1)
				)
			)
			(1
				(doorMaster view: 6406 loop: 0 cel: 0 setCycle: CT 2 1 self)
			)
			(2
				(client cue:)
			)
			(3
				(doorMaster setCycle: End self)
			)
			(4
				(doorMaster loop: 1 cel: 0 setCycle: End self)
			)
			(5
				(doorMaster view: 642 loop: 0 cel: 0)
				(= cycles 2)
			)
			(6
				(if (!= client egoGiveTicketScr)
					(gMessager say: 1 0 2 3 self) ; "Next!"
				else
					(= cycles 1)
				)
			)
			(7
				(self dispose:)
			)
		)
	)
)

(instance ghostLineScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: End self)
			)
			(1
				(client cel: 0 loop: 0 posn: 141 167 setCycle: End self)
			)
			(2
				(client cel: 0 loop: 1 setCycle: Fwd)
				(keyMaster view: 643 loop: 1 cel: 0 setCycle: CT 9 1 self)
			)
			(3
				(client cel: 0 loop: 2 setCycle: End self)
				(keyMaster setCycle: End self)
			)
			(4 0)
			(5
				(keyMaster loop: 1 cel: 0)
				(= cycles 2)
			)
			(6
				(gMessager say: 1 0 2 1 self) ; "The skeleton to the left of the path hands something to the spirits that approach the Underworld entrance."
			)
			(7
				(client cel: 0 loop: 3 y: 136 setCycle: Fwd)
				(= ticks 30)
			)
			(8
				(self setScript: takeTicketScr self)
			)
			(9
				(script cue:)
			)
			(10
				(client cel: 0 loop: 4 setCycle: End self)
			)
			(11
				(door setCycle: End self)
			)
			(12
				(client hide:)
				(door setCycle: Beg self)
			)
			(13
				(keyMaster view: 6404 loop: 0 cel: 0)
				(client dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance playXylophone of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 200 185 self)
			)
			(1
				(gEgo
					normal: 0
					view: 641
					posn: (- (boneMallet x:) 3) (+ (boneMallet y:) 9)
					setLoop: 0
					cycleSpeed: 10
					cel: 0
					setCycle: End self
				)
				(boneMallet hide:)
			)
			(2
				(UnLoad 128 900)
				(if (IsFlag 100)
					(gMessager say: 6 5 4 1 self) ; "Alexander gears himself up for another round of 'dem bones."
				else
					(gMessager say: 6 5 3 1 self) ; "Alexander picks up the two bones on the ground. Now what do these bones remind him of?"
				)
			)
			(3
				(if (IsFlag 100)
					(= cycles 1)
				else
					(gGame givePoints: 2)
					(gMessager say: 6 5 3 2 self) ; "Ah, yes! Now I remember!"
					(SetFlag 100)
				)
				(if (gEgo script:)
					(gEgo setScript: 0)
				)
				(gGlobalSound stop:)
			)
			(4
				(gEgo
					posn:
						(+ (boneMallet x:) [local0 1])
						(+ (boneMallet y:) [local4 1])
					setLoop: 1
					setCycle: End self
				)
			)
			(5
				(gGlobalSound number: 641 loop: 1 play:)
				(gGlobalSound prevSignal: 0)
				(keyMaster setScript: keyDanceScript)
				(= register 2)
				(= cycles 1)
			)
			(6
				(gEgo
					posn:
						(+ (boneMallet x:) [local0 register])
						(+ (boneMallet y:) [local4 register])
					setLoop: register
					setCycle: End self
				)
			)
			(7
				(if (== (gGlobalSound prevSignal:) -1)
					(keyDanceScript cue:)
					(gGlobalSound number: 600 loop: -1 play:)
					(= cycles 1)
				else
					(= register (Random 2 3))
					(self start: 6 init:)
				)
			)
			(8
				(gEgo
					posn:
						(+ (boneMallet x:) [local0 1])
						(+ (boneMallet y:) [local4 1])
					setLoop: 1
				)
				(gEgo cel: (gEgo lastCel:) setCycle: Beg self)
			)
			(9
				(gEgo setLoop: 0 cel: 5 setCycle: Beg self)
			)
			(10
				(boneMallet show:)
				(gEgo reset: 0 posn: 198 181)
				(= cycles 1)
			)
			(11
				(gMessager say: 6 5 3 4 self) ; "Alexander finishes his tune and the skeletons resume their posts. Despite their frolic, they don't seem any friendlier!"
			)
			(12 0)
			(13
				(doorMaster view: 642 setLoop: 0 cel: 0 setCycle: 0)
				(gGame handsOn:)
				(self start: 0 dispose:)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (and (== state 6) (== (gGlobalSound prevSignal:) -1))
			(gEgo setCycle: 0)
			(self cue:)
		)
		(if (and (== state 12) (not (chorusRight script:)))
			(self cue:)
		)
	)
)

(instance keyDanceScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(if
			(and
				(gCast contains: chorusRight)
				(not (chorusRight script:))
				(== (gGlobalSound prevSignal:) 10)
			)
			(gGlobalSound prevSignal: 1)
			(chorusRight setScript: chorusScript 0 0)
			((skelLeft script:) cue:)
			((skelRight script:) cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register 0)
				(= seconds 3)
			)
			(1
				(self setScript: msgScript)
				(skelLeft setScript: skelLeftScript)
				(skelRight setScript: skelRightScript)
				(doorMaster view: 646 setLoop: 0 cel: 0)
				(chorusRight init:)
				(= seconds 10)
			)
			(2
				(doorMaster setScript: doorScript)
				(= seconds 10)
			)
			(3
				(keyMaster view: 645 setLoop: 0 cel: 0 setCycle: Fwd)
				(if (and (not (gEgo has: 44)) (not (IsFlag 115))) ; skeletonKey
					(boneKey view: 645 setLoop: 1 cel: 1)
					(= register 1)
				)
				(= seconds 20)
			)
			(4
				(= register 0)
				(if (and (not (gEgo has: 44)) (not (IsFlag 115))) ; skeletonKey
					(boneKey
						setLoop: 2
						cel: 0
						posn: (keyMaster x:) (keyMaster y:)
						cycleSpeed: 0
						setCycle: MCyc @local8 self
					)
					(gGlobalSound2 number: 825 loop: 1)
				else
					(= cycles 1)
				)
			)
			(5
				(if (and (not (gEgo has: 44)) (not (IsFlag 115))) ; skeletonKey
					(gGlobalSound2 play:)
					(boneKey setCycle: MCyc @local45 self)
				else
					(= cycles 1)
				)
			)
			(6
				(if (and (not (gEgo has: 44)) (not (IsFlag 115))) ; skeletonKey
					(gGlobalSound2 play:)
					(SetFlag 115)
					(boneKey view: 647 loop: 0 cel: 1 noun: 7)
				)
				((doorMaster script:) cue:)
			)
			(7
				(keyMaster view: 6404 setLoop: 0 cel: 0 setCycle: 0)
				(self dispose:)
			)
		)
	)
)

(instance msgScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (& gMsgType $0002)
					(gMessager say: 6 5 3 3 self) ; "The skeletons are overcome with the musical call of the bones. They begin to jiggle, then to dance!""
				else
					(KQ6Print
						font: gUserFont
						posn: -1 10
						addText: 6 5 3 3 ; "The skeletons are overcome with the musical call of the bones. They begin to jiggle, then to dance!""
						modeless: 1
						init:
					)
					(= seconds 8)
				)
			)
			(1
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(= cycles 1)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance skelLeftScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(skelLeft view: 6403 setLoop: 1 cel: 0 setCycle: Fwd)
			)
			(1
				(skelLeft view: 644 setLoop: 0 cel: 0 setCycle: 0)
				(self dispose:)
			)
		)
	)
)

(instance skelRightScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(skelRight view: 6403 setLoop: 0 cel: 0 setCycle: Fwd)
			)
			(1
				(skelRight view: 644 setLoop: 0 cel: 0 setCycle: 0)
				(self dispose:)
			)
		)
	)
)

(instance doorScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(doorMaster setCycle: Fwd)
			)
			(1
				(doorMaster setLoop: 0 cel: 0 setCycle: 0)
				(self dispose:)
			)
		)
	)
)

(instance chorusScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(chorusRight setCycle: Fwd setMotion: MoveTo 160 184 self)
				(chorusMid init:)
				(chorusLeft init:)
			)
			(1
				(chorusRight setCycle: Fwd setMotion: MoveTo -18 184 self)
			)
			(2
				(if (not register)
					(chorusMid dispose:)
					(chorusLeft dispose:)
					(chorusRight dispose:)
					(self dispose:)
				else
					(-- register)
					(self init:)
				)
			)
		)
	)
)

(instance getKeyScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setMotion: PolyPath (- (boneKey x:) 41) (boneKey y:) self
				)
			)
			(1
				(gEgo
					normal: 0
					view: 6405
					setLoop: 0
					cel: 0
					posn: (- (boneKey x:) 20) (+ (boneKey y:) 5)
					setCycle: CT 3 1 self
				)
			)
			(2
				(boneKey dispose:)
				(gEgo setCycle: End self)
			)
			(3
				(gEgo
					reset: 0
					posn: (- (gEgo x:) 21) (- (gEgo y:) 5)
					get: 44 ; skeletonKey
				)
				(gGame givePoints: 1)
				(ClearFlag 115)
				(= cycles 12)
			)
			(4
				(gMessager say: 7 5 0 1 self) ; "Alexander picks up the skeleton key."
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance ghostScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: MCyc @local62 self)
			)
			(1
				(if (== (gCurRoom script:) playXylophone)
					(client dispose:)
					(self dispose:)
				else
					(= seconds (Random 5 10))
				)
			)
			(2
				(self init:)
			)
		)
	)
)

(instance chorusRight of Actor
	(properties
		x -18
		y 184
		view 648
		loop 2
		signal 18432
	)
)

(instance chorusMid of Actor
	(properties
		x -18
		y 184
		view 648
		signal 18432
	)

	(method (doit)
		(self
			cel: (chorusRight cel:)
			x: (- (chorusRight x:) 25)
			y: (chorusRight y:)
		)
		(super doit:)
	)
)

(instance chorusLeft of Actor
	(properties
		x -18
		y 184
		view 648
		loop 1
		signal 18432
	)

	(method (doit)
		(self
			cel: (chorusRight cel:)
			x: (- (chorusRight x:) 50)
			y: (chorusRight y:)
		)
		(super doit:)
	)
)

(instance boneMallet of View
	(properties
		x 221
		y 177
		noun 6
		view 647
		signal 16384
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(gGame handsOff:)
			(gCurRoom setScript: playXylophone)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance skelLeft of Prop
	(properties
		x 85
		y 144
		noun 9
		view 644
		loop 1
	)
)

(instance skelRight of Prop
	(properties
		x 192
		y 132
		noun 9
		view 644
	)
)

(instance doorMaster of Prop
	(properties
		x 170
		y 118
		noun 5
		approachX 141
		approachY 134
		view 642
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gMessager say: noun theVerb 0 0) ; "Alexander has the feeling that trying to physically force his way past the skeleton at the door is not a good idea."
			)
			(1 ; Look
				(gMessager say: noun theVerb 0 0) ; "A uniformed skeleton stands guard at the entrance to the Underworld. He takes something from the passing spirits and then waves them on into the Underworld."
			)
			(2 ; Talk
				(gMessager say: noun theVerb 0 0) ; "I must see the Lord of the Dead. Please let me pass."
			)
			(50 ; handkerchief
				(gMessager say: noun theVerb 0 1) ; "The skeleton is unlikely to be interested in the mother ghost's problems."
			)
			(49 ; ticket
				(gGame handsOff:)
				(gCurRoom setScript: egoGiveTicketScr)
			)
			(35 ; skeletonKey
				(gMessager say: 5 35 0 0) ; "I have this key of bone. Will it get me into the Underworld?"
			)
			(else
				(gMessager say: 5 0 0 0) ; "Would this persuade you to let me pass?"
			)
		)
	)
)

(instance boneKey of Prop
	(properties
		noun 11
		view 647
		cel 1
	)

	(method (doit)
		(if (keyDanceScript register:)
			(self
				cel: (keyMaster cel:)
				x: (+ (keyMaster x:) 4)
				y: (- (keyMaster y:) 53)
			)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (IsFlag 115)
					(gGame handsOff:)
					(gCurRoom setScript: getKeyScript)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance keyMaster of Prop
	(properties
		x 101
		y 164
		noun 4
		approachX 109
		approachY 176
		view 6404
	)
)

(instance ghost of Actor
	(properties
		x 226
		y 96
		view 640
		priority 13
		signal 16
	)
)

(instance lineGhost of Prop
	(properties
		x 133
		y 183
		view 6401
		loop 5
	)
)

(instance door of Prop
	(properties
		x 141
		y 32
		approachX 140
		approachY 90
		view 647
		loop 1
		signal 16384
	)

	(method (init)
		(super init: &rest)
		(gWalkHandler addToFront: self)
	)

	(method (dispose)
		(gWalkHandler delete: self)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 5 3) ; Do, Walk
			(gMessager say: 8 3 0 1) ; "Alexander approaches the entrance to the Underworld."
			(gEgo setMotion: PolyPath approachX approachY)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance theSkull of Feature
	(properties
		noun 10
		onMeCheck 8
	)
)

(instance xylophone of Feature
	(properties
		noun 6
		onMeCheck 16
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(gGame handsOff:)
			(gCurRoom setScript: playXylophone)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

