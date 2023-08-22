;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 43)
(include sci.sh)
(use Main)
(use Interface)
(use forwardScript)
(use Talker)
(use Osc)
(use PolyPath)
(use Polygon)
(use Feature)
(use ForwardCounter)
(use LoadMany)
(use DPath)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm43 0
	someoneDied 1
	slot 2
)

(local
	local0
	local1
	local2 = 1
	local3
	[local4 46] = [0 0 319 0 319 111 298 104 285 107 273 111 250 106 233 99 243 91 232 88 195 83 175 83 194 95 192 103 178 107 140 114 121 115 106 114 85 106 67 97 50 94 43 90 0 101]
	[local50 42] = [0 0 319 0 319 111 298 104 279 107 255 98 251 89 232 88 195 83 175 83 194 95 192 103 178 107 140 114 121 115 106 114 85 106 67 97 50 94 43 90 0 99]
	local92
	local93
	local94
)

(instance rm43 of Rm
	(properties
		picture 43
	)

	(method (init)
		(LoadMany rsVIEW 30 143)
		(Load rsTEXT 143)
		(if (and (IsFlag 63) (== gPrevRoomNum 44))
			(Load rsVIEW 243)
		)
		(super init:)
		(if (!= gPrevRoomNum 44)
			(= global170 0)
		else
			(SetFlag 11)
		)
		(slotPoly type: PBarredAccess points: @local4 size: 23)
		(stagePoly type: PBarredAccess points: @local50 size: 21)
		(if (not (IsFlag 11))
			(self addObstacle: slotPoly)
			((ScriptID 303 1) init: setScript: (ScriptID 303 0)) ; slotGuy, prepareToDie
			((ScriptID 303 2) init: stopUpd:) ; slotGuyBody
		else
			(self addObstacle: stagePoly)
		)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 319 189 211 189 181 171 188 161 232 157 261 152 319 151
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 70 170 148 170 148 185 70 185
					yourself:
				)
		)
		(gFeatures
			add: slotMachine barTop kzitten fenrisBody slotLaser
			eachElementDo: #init
		)
		(switch
			(if global170
				global170
			else
				(= global170 (Random 2 (if (not (IsFlag 11)) 2 else 3)))
			)
			(1
				((ScriptID 302 2) init: setCycle: FROR 8 20 0 2) ; ZZTop
				((ScriptID 302 3) init: setCycle: Fwd) ; ZZTop2
				((ScriptID 302 4) init: setCycle: Fwd) ; ZZTop3
				(gAddToPics add: (ScriptID 302 1)) ; drum
				(gLongSong number: 611)
			)
			(2
				((ScriptID 300 1) init: setScript: (Clone (ScriptID 300 0))) ; jakeBlue, bluesBrothers
				((ScriptID 300 2) init: setScript: (Clone (ScriptID 300 0)) 0 3) ; elwoodBlue, bluesBrothers
				(gLongSong number: 612 send: 4 78 0 send: 5 78 0)
			)
			(3
				((ScriptID 301 1) init: setScript: (ScriptID 301 0)) ; madonna, madonnaScript
				((ScriptID 301 2) init: setCycle: Fwd hide:) ; madonnaFace
				(gLongSong number: 613 send: 6 78 0)
			)
		)
		(slugGuy init: stopUpd:)
		(triGirl init: stopUpd:)
		(fenris init: setScript: fenrisScript)
		(bartender init: setScript: bartendScript)
		(chp_dail init: setScript: beerJumping)
		(if (<= (gGame detailLevel:) 2)
			(slugGuy setScript: slugScript)
			(triGirl setScript: triScript)
		)
		(kzittenArm init: setPri: 12 stopUpd:)
		(kzittenHead init: setPri: 12 stopUpd:)
		(slugEyes init: hide:)
		(bartenderHead init:)
		(beerMug init: setCycle: Walk hide:)
		(C_DbeerMug init: setCycle: Walk)
		(gAddToPics eachElementDo: #init doit:)
		(slot init:)
		(if (or (not (IsFlag 11)) (IsFlag 39))
			(Load rsSOUND 312)
			(sweeper init: stopUpd:)
		)
		(if (== gPrevRoomNum 44)
			(NormalEgo 0 1 61)
			(gEgo
				init:
				posn: 256 105
				view: 77
				setLoop: 0
				cel: 5
				normal: 0
				illegalBits: -32768
			)
			(cond
				((IsFlag 63)
					(gCurRoom setScript: playSlots 0 2)
				)
				((IsFlag 12)
					(gCurRoom setScript: playSlots 0 3)
				)
				((IsFlag 39)
					(gEgoHead hide:)
					(gCurRoom setScript: someoneDied 0 gEgo)
				)
				(else
					(gCurRoom setScript: playSlots 0 1)
				)
			)
			(if (< 3 4)
				(gLongSong loop: -1 flags: 1 play:)
			)
		else
			(if (IsFlag 63)
				(slot view: 243 posn: 282 81 loop: 7 cel: 2 stopUpd:)
			)
			(gLongSong loop: -1 flags: 1 play:)
			(self setScript: walkIn)
		)
		(if (== (gLongSong number:) 612)
			(gLongSong send: 4 78 1 send: 5 78 1)
		)
		(if (== (gLongSong number:) 613)
			(gLongSong send: 6 78 1)
		)
		(if (IsFlag 13)
			(widget init: setCycle: Fwd)
		else
			(widget init: hide:)
		)
	)

	(method (doit &tmp temp0)
		(cond
			(script 0)
			((not (= temp0 (gEgo onControl: 1))) 0)
			((& temp0 $0020)
				(self setScript: walkOut)
			)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Printf ; "This is a seedy little place. Galactic riff-raff are seated at the bar. %s. There is a slot machine standing near the bar. You notice a sweeper in the corner of the room. It must get messy here. No one seems to notice or care that you have entered the bar."
					43
					0
					(switch global170
						(1 {A bearded band is cranking out some of the more popular tunes in the quadrant})
						(2 {These are a couple of nongalactic-looking humanoids cranking out some unfamiliar-sounding tunes. They seem interested solely in the music they are performing})
						(3 {On stage, a strangely attired woman performs her act (if that's what you want to call it). You haven't had a girlfriend for a long time (more like forever), but even that's not enough to make her attractive})
					)
					(switch global170
						(1 {Un grupo barbudo est\a0 tocando una de las canciones m\a0s populares del cuadrante})
						(2 {Hay un par de humanoides sin aspecto gal\a0ctico que est\a0n tocando algunas canciones desconocidas. Parecen estar interesados solamente en la m\a3sica que est\a0n tocando})
						(3 {En el escenario act\a3a (si lo quieres llamar as\a1) una mujer vestida de forma rara. Hace mucho (mejor nunca) que no tienes novia, pero ni siquiera eso consigue hacerla atractiva})
					)
				)
			)
			(12 ; Smell
				(Print 43 1) ; "Sour beer and stale sweat."
			)
			(11 ; Taste
				(if (<= global169 1)
					(Print 43 2) ; "Why don't you just buy two or three drinks instead."
				else
					(Print 43 3) ; "You've had a couple of drinks now. What do you think."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (dispose)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(if (!= newRoomNumber 44)
			(= global175 0)
		)
		(if (not (IsFlag 11))
			((ScriptID 303 1) dispose:) ; slotGuy
		)
		(super newRoom: newRoomNumber)
	)
)

(instance walkIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					init:
					setLoop: 6
					setPri: 14
					posn: -10 170
					setMotion: MoveTo 24 193 self
				)
			)
			(1
				(gEgo
					setPri: -1
					setLoop: -1
					setStep: 4 2
					setMotion: MoveTo 71 166 self
				)
			)
			(2
				(gEgo illegalBits: -32768)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance walkOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo illegalBits: 0 setMotion: PolyPath 24 193 self)
			)
			(1
				(gEgo setPri: 14 setLoop: 5 setMotion: MoveTo -10 170 self)
			)
			(2
				(gEgo setPri: -1 setLoop: -1)
				(gCurRoom newRoom: 41)
			)
		)
	)
)

(instance egoStaggersOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Print 43 4) ; "Whoa!"
				(= cycles 18)
			)
			(1
				(gEgo setCycle: Beg self)
			)
			(2
				(Print 43 5) ; "You wisely (although somewhat belatedly) decide to heed the bartender's advice."
				(beerMug show:)
				(gEgo
					posn: 238 134
					setPri: 11
					view: 30
					setLoop: 0
					cel: 0
					setCycle: End self
				)
			)
			(3
				(gEgo posn: 229 157 view: 32 setLoop: 0 cel: 0 setPri: 10)
				(= cycles 12)
			)
			(4
				(gEgo setLoop: 2 cel: 2)
				(= cycles 6)
			)
			(5
				(gEgo cel: 0)
				(= cycles 6)
			)
			(6
				(gEgo cel: 5)
				(= cycles 6)
			)
			(7
				(gEgo setLoop: 1 cel: 4)
				(= cycles 6)
			)
			(8
				(gEgo
					setCycle: Fwd
					cycleSpeed: 5
					moveSpeed: 5
					setMotion: MoveTo 132 164 self
				)
			)
			(9
				(kzittenHead setScript: scareEgo)
				(= cycles 30)
			)
			(10
				(gEgo setMotion: MoveTo 41 187 self)
			)
			(11
				(gEgo
					moveSpeed: 8
					cycleSpeed: 8
					setMotion: MoveTo 4 180 self
				)
			)
			(12
				(gEgo setPri: -1 setLoop: -1)
				(gCurRoom newRoom: 41)
			)
		)
	)
)

(instance scareEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (= register (User canControl:))
					(HandsOff)
				)
				(kzittenHead setCycle: End self)
			)
			(1
				(kzittenHead stopUpd:)
				(kzittenArm setCycle: End self)
			)
			(2
				(kzittenArm stopUpd:)
				(= cycles 10)
			)
			(3
				(kzittenHead setCycle: Beg)
				(kzittenArm setCycle: Beg self)
			)
			(4
				(kzittenHead stopUpd:)
				(kzittenArm stopUpd:)
				(if register
					(HandsOn)
				)
				(self dispose:)
			)
		)
	)
)

(instance slugScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(slugGuy stopUpd:)
				(= cycles (Random 12 60))
			)
			(1
				(if (Random 0 2)
					(= state -1)
					(slugGuy setLoop: 2 forceUpd:)
					(slugEyes show: setLoop: (Random 3 6) cel: 1)
					(= cycles (Random 15 60))
				else
					(= cycles 3)
				)
			)
			(2
				(slugEyes hide:)
				(slugGuy setLoop: 0 cel: 0 setCycle: End self)
			)
			(3
				(slugGuy setLoop: 1 cel: 0 setCycle: End self)
			)
			(4
				(= state -1)
				(slugGuy setLoop: 0 cel: 8 setCycle: Beg self)
			)
		)
	)
)

(instance triScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(triGirl stopUpd:)
				(= cycles (Random 30 180))
			)
			(1
				(if (Random 0 1)
					(= state -1)
					(triGirl
						setLoop: 3
						cycleSpeed: 8
						setCycle: Osc (Random 1 3) self
					)
				else
					(= cycles 3)
				)
			)
			(2
				(triGirl setLoop: 0 cycleSpeed: 8 cel: 0 setCycle: End self)
			)
			(3
				(= cycles (Random 30 90))
			)
			(4
				(= state -1)
				(triGirl setCycle: Beg self)
			)
		)
	)
)

(instance fenrisScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(fenris stopUpd:)
				(= cycles (Random 9 90))
			)
			(1
				(if (Random 0 1)
					(= state -1)
					(fenris setLoop: 1 cel: 0 setCycle: Fwd)
					(= cycles (Random 15 60))
				else
					(= cycles 3)
				)
			)
			(2
				(fenris setLoop: 0 cel: 2 setCycle: Beg self)
			)
			(3
				(fenris
					setLoop: 2
					cel: 0
					setCycle: ForwardCounter (Random 1 4) self
				)
			)
			(4
				(= state -1)
				(fenris setLoop: 0 cel: 0 setCycle: End self)
			)
		)
	)
)

(instance bartendScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(if
			(and
				(not local92)
				(or
					(>= (bartendScript register:) 4)
					(>= (bartendScript register:) 8)
				)
				(not (OneOf state 3 2 8))
			)
			(= local92 1)
			(bartenderT init: bartenderBust bartenderEyes bartenderMouth)
			(bartenderT say: 143 (Random 0 2) 0 1 0)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if
					(and
						register
						(not (>= (bartendScript register:) 4))
						(not (>= (bartendScript register:) 8))
					)
					(= state 4)
					(= local3 register)
					(= cycles 9)
				else
					(= cycles (Random 15 60))
				)
			)
			(1
				(if (not (>= (bartendScript register:) 4))
					(= state -1)
				)
				(if
					(and
						(not (>= (bartendScript register:) 8))
						(>= (bartendScript register:) 4)
					)
					(= state 2)
				)
				(bartender setLoop: 1)
				(bartenderHead show: posn: 284 135 cel: 0)
				(if (>= (bartendScript register:) 4)
					(bartenderHead setLoop: 3 setCycle: End self)
				else
					(bartenderHead setLoop: 2 setCycle: End self)
				)
			)
			(2
				(= local92 0)
				(bartenderT
					init: bartenderBust bartenderEyes bartenderMouth 143 3 0 1 ; "Here is your 5 buckazoids and your free beer."
				)
				(gEgo put: 17 43) ; Bar_Coupon
				(+= gBuckazoidCount 5)
				(self register: (- (bartendScript register:) 8))
				(self register: (+ (bartendScript register:) 2))
				(= state 4)
				(= cycles 5)
			)
			(3
				(bartenderT
					init:
						bartenderBust
						bartenderEyes
						bartenderMouth
						{"So, what's your beef, junior?"}
						0
						0
						0
						self
				)
			)
			(4
				(= local92 0)
				(if
					(or
						(and
							(not global169)
							(or (and gModelessDialog (gModelessDialog dispose:)) 1)
							(Print ; "Do you want a beer? It costs 2 Buckazoids."
								43
								6
								#at
								10
								10
								#button
								{ Yes }
								1
								#button
								{ No }
								0
							)
						)
						(and
							(< 0 global169 5)
							(or (and gModelessDialog (gModelessDialog dispose:)) 1)
							(Print ; "Want another drink?"
								43
								7
								#at
								10
								10
								#button
								{ Yes }
								1
								#button
								{ No }
								0
							)
						)
						(and
							(== global169 5)
							(or (and gModelessDialog (gModelessDialog dispose:)) 1)
							(Print ; "Listen, Mac, I shouldn't serve you any more. You're sledged! You'd better go sleep it off or something before you start making a public display of yourself."
								43
								8
								#at
								10
								10
								#button
								{ Gimme anudder un, ya jerr-erk! }
								1
								#button
								{ Ok. }
								0
							)
						)
					)
					(cond
						((< gBuckazoidCount 2)
							(bartenderT say: 143 5 0 1) ; "C'mon, bud. If you haven't got the money, hit the sand."
							(= global188 0)
							(if (not (someoneDied client:))
								(HandsOn)
								(User canControl: 0)
							)
							(= state -1)
						)
						((== gBuckazoidCount 2)
							(= gBuckazoidCount 0)
							(gEgo put: 10) ; buckazoid
							(self register: (+ (bartendScript register:) 2))
							(bartenderT
								say: {"Here ya go."} 0 0 1
							)
						)
						(else
							(-= gBuckazoidCount 2)
							(self register: (+ (bartendScript register:) 2))
							(bartenderT
								say: {"Here ya go."} 0 0 1
							)
						)
					)
					(= cycles 5)
				else
					(= global188 0)
					(if (not (someoneDied client:))
						(HandsOn)
						(User canControl: 0)
					)
					(bartenderT
						init:
							bartenderBust
							bartenderEyes
							bartenderMouth
							{"So stop botherin' me already."}
							0
							0
							1
							self
					)
					(= state -1)
				)
				(self register: (- (bartendScript register:) 4))
			)
			(5
				(= local3 register)
				(bartenderHead hide:)
				(bartender setLoop: 0 cel: 0 setCycle: End self)
			)
			(6
				(bartender setLoop: 4 cel: 0)
				(bartenderHead
					show:
					posn: 300 143
					setLoop: 5
					setCycle: CT 11 1 self
				)
			)
			(7
				(cond
					((>= local3 4)
						(self
							register: (- (bartendScript register:) 1)
							setScript: drinkDownBar self 1
						)
					)
					((>= local3 2)
						(self
							register: (- (bartendScript register:) 2)
							setScript: drinkDownBar self
						)
					)
					((>= local3 1)
						(self
							register: (- (bartendScript register:) 1)
							setScript: drinkDownBar self 1
						)
					)
				)
				(= local3 0)
				(bartenderHead setCycle: End self)
			)
			(8
				(= state -1)
				(bartenderHead posn: 248 135 hide:)
				(bartender setLoop: 0 cel: 3 setCycle: Beg)
			)
		)
	)
)

(instance drinkDownBar of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if register
					(C_DbeerMug
						show:
						posn: 289 141
						setMotion:
							DPath
							255
							140
							242
							144
							238
							151
							240
							165
							237
							167
							209
							187
							self
					)
				else
					(beerMug show: posn: 289 141 setMotion: MoveTo 252 136 self)
				)
			)
			(1
				(if register
					(= register 0)
					(C_DbeerMug cel: 0)
					(= local2 1)
					(beerJumping cue:)
				else
					(beerMug cel: 0)
					(moveEgoToBar cue:)
				)
				(self dispose:)
			)
		)
	)
)

(instance beerJumping of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(chp_dail cycleSpeed: 8)
				(= state (- (Random 1 3) 1))
				(= cycles (Random 12 90))
			)
			(1
				(= state -1)
				(if local2
					(C_DbeerMug show:)
				)
				(chp_dail setLoop: 2 cel: 0 cycleSpeed: 4 setCycle: Osc 1 self)
			)
			(2
				(= state -1)
				(if local2
					(C_DbeerMug hide:)
				)
				(chp_dail setLoop: 1 cel: 0 setCycle: End self)
			)
			(3
				(if local2
					(C_DbeerMug hide:)
				)
				(chp_dail setLoop: 0 cel: 0 setCycle: End self)
			)
			(4
				(chp_dail setLoop: 3 cel: 0 setCycle: Fwd)
				(= seconds (Random 2 5))
			)
			(5
				(chp_dail setLoop: 2 cel: 0 setCycle: 0)
				(bartendScript register: (+ (bartendScript register:) 1))
			)
			(6
				(= state -1)
				(chp_dail setLoop: 2 cel: 0)
				(= cycles 3)
			)
		)
	)
)

(instance moveEgoToBar of Script
	(properties)

	(method (init)
		(super init: &rest)
		(gDirectionHandler addToFront: self)
	)

	(method (dispose)
		(gDirectionHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event)
		(if
			(and
				(or (== state 4) (== state 9))
				(== (gTheIconBar curIcon:) (gTheIconBar at: 0))
				(or (& (event type:) $0040) (== (event message:) JOY_UP)) ; direction
			)
			(cond
				(global188
					(Print 43 9) ; "The bartender doesn't exactly jump at your request."
				)
				((== state 4)
					(self changeState: 10)
				)
				(else
					(self cue:)
				)
			)
			(event claimed: 1)
		else
			(super handleEvent: event)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (not (OneOf register 0 6))
					(self changeState: 4)
				else
					(= cycles 3)
				)
			)
			(1
				(gEgo setMotion: MoveTo 240 158 self)
			)
			(2
				(gEgo
					view: 30
					posn: 238 134
					setPri: 11
					loop: 0
					cel: 9
					setCycle: Beg self
				)
			)
			(3
				(= cycles 1)
			)
			(4
				(= local0 1)
				(kzittenHead approachVerbs:)
				(kzittenArm approachVerbs:)
				(kzitten approachVerbs:)
				(triGirl approachVerbs:)
				(fenris approachVerbs:)
				(fenrisBody approachVerbs:)
				(if (not local93)
					(if (not global188)
						(if (>= register 5)
							(= register 0)
							(Print 43 10) ; "I would like to redeem this coupon for 5 buckazoids and a free beer."
							(bartendScript
								register: (+ (bartendScript register:) 8)
							)
						else
							(if (not global169)
								(Print 43 11) ; "Excuse me, my good man. I would like a drink."
							else
								(Print 43 12) ; "Yo! How about a refill?"
							)
							(bartendScript
								register: (+ (bartendScript register:) 4)
							)
						)
						(= global188 1)
					)
				else
					(HandsOn)
				)
				(= local93 0)
				(= register 0)
				(User canControl: 0)
			)
			(5
				(if (< (++ global169) 6)
					(gEgo
						view: 90
						setLoop: 0
						cel: 0
						cycleSpeed: 8
						setCycle: CT 1 1 self
					)
				else
					(beerMug hide:)
					(gEgo
						view: 73
						setLoop: 0
						cel: 0
						cycleSpeed: 8
						setCycle: End self
					)
				)
			)
			(6
				(beerMug hide:)
				(if (>= global169 6)
					(gCurRoom setScript: egoStaggersOut)
					(self dispose:)
				else
					(gEgo setCycle: CT 7 1 self)
				)
			)
			(7
				(beerMug show: posn: 260 136 setMotion: MoveTo 291 136 self)
				(= global188 0)
				(gEgo setCycle: End)
			)
			(8
				(switch global169
					(1
						(Print 43 13) ; "Hmmm... It tastes better than it smells (thank goodness). Another one would be nice."
					)
					(2
						(Print 43 14) ; "Ah yes, that hits the spot. Just one more should do it."
					)
					(3
						(Printf ; "As you sip another of the odd brews, you overhear someone at the bar speaking: "There I was cruising through sector %s when I spot this blip on the scanner.""
							43
							15
							(switch global186
								(1 {AA})
								(2 {BB})
								(3 {CC})
								(4 {DD})
								(5 {EE})
								(6 {FF})
								(7 {GG})
								(8 {HH})
								(9 {II})
								(10 {AD})
								(11 {BF})
								(12 {BG})
								(13 {CH})
								(14 {CI})
								(15 {DG})
								(16 {EG})
								(17 {HA})
								(18 {HD})
								(19 {IB})
								(20 {IC})
							)
							(switch global186
								(1 {AA})
								(2 {BB})
								(3 {CC})
								(4 {DD})
								(5 {EE})
								(6 {FF})
								(7 {GG})
								(8 {HH})
								(9 {II})
								(10 {AD})
								(11 {BF})
								(12 {BG})
								(13 {CH})
								(14 {CI})
								(15 {DG})
								(16 {EG})
								(17 {HA})
								(18 {HD})
								(19 {IB})
								(20 {IC})
							)
						)
						(SetScore 5 155)
						(Print 43 16) ; "So, I head toward it, ya see, and right there in front of me sits the Deltaur. It's just sittin' there. My hearts start hyperwarping on me."
						(Print 43 17) ; "I figure my milliseconds are numbered. All I can think of doin' is getting my craft outta there. So, I'm reachin' for the throttle."
						(Print 43 18) ; "All of a sudden there's this incredible flash of light, ya see. And just like that this little planetoid explodes into a ball of fire! I tell ya, I've never seen anything like it. I mauled the throttle and got outta there quick you bet."
					)
					(4
						(Print 43 19) ; "You feel a strange tingling sensation. The taste of the beer doesn't seem to be bothering you so much now, hee, hee."
					)
					(5
						(Print 43 20) ; "Oh my, you're starting to feel a bit unstable."
					)
				)
				(= cycles 3)
			)
			(9
				(beerMug hide:)
				(HandsOn)
				(User canControl: 0)
				0
			)
			(10
				(HandsOff)
				(gEgo view: 30 setLoop: 0 cel: 0 setCycle: End self)
			)
			(11
				(gEgo posn: 240 158 setPri: -1)
				(= local0 0)
				(kzittenHead approachVerbs: 3 5) ; Do, Talk
				(kzittenArm approachVerbs: 3 5) ; Do, Talk
				(kzitten approachVerbs: 3 5) ; Do, Talk
				(triGirl approachVerbs: 5 3 12) ; Talk, Do, Smell
				(fenris approachVerbs: 5 3 12) ; Talk, Do, Smell
				(fenrisBody approachVerbs: 5 3 12) ; Talk, Do, Smell
				(if (not (> 6 global169 4))
					(NormalEgo 0 1 61)
					(gEgo illegalBits: -32768 loop: 4)
				else
					(Print 43 21) ; "You are supposed to walk out of the bar drunk, and pass out behind it. Waking up with an enormous headache and no earthly possessions. But for now you're normal."
					(NormalEgo 0 1 61)
					(gEgo illegalBits: -32768)
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance someoneDied of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== register gEgo)
					(HandsOff)
					(= cycles 4)
				else
					(self cue:)
				)
			)
			(1
				(if (== register gEgo)
					(= cycles 2)
				else
					((ScriptID 303 2) hide: forceUpd:) ; slotGuyBody
					((ScriptID 303 1) ; slotGuy
						view: 543
						setLoop: 0
						cel: 0
						ignoreActors: 1
						posn: 263 104
						setCycle: End self
					)
				)
			)
			(2
				(if (== register gEgo)
					(= local1 (Graph grSAVE_BOX 20 62 89 255 3))
					(Graph grDRAW_LINE 21 63 78 254 global137 1 0 0)
					(Graph grUPDATE_BOX 21 63 78 254 1)
					(Graph grREDRAW_BOX 20 62 89 255)
				else
					(= local1 (Graph grSAVE_BOX 20 62 89 250 3))
					(Graph grDRAW_LINE 21 63 88 249 global137 1 0 0)
					(Graph grUPDATE_BOX 21 63 88 249 1)
					(Graph grREDRAW_BOX 20 62 89 250)
				)
				(gSoundEffects number: 312 loop: 1 play:)
				(if (== register gEgo)
					(gEgo view: 78 setLoop: 0 cel: 2)
				else
					((ScriptID 303 1) ; slotGuy
						setLoop: 1
						cel: 0
						posn: 263 104
						setCycle: Fwd
					)
				)
				(register setCycle: Beg self)
				(= cycles 10)
			)
			(3
				(Graph grRESTORE_BOX local1)
				(if (== register gEgo)
					(Graph grREDRAW_BOX 20 62 89 255)
				else
					(Graph grREDRAW_BOX 20 62 89 250)
				)
				(= local1 0)
			)
			(4
				(if (== register gEgo)
					(gEgo
						view: 78
						setLoop: 1
						cel: 0
						ignoreActors: 1
						setCycle: End self
					)
				else
					((gCurRoom obstacles:) delete: slotPoly add: stagePoly)
					(SetFlag 11)
					((ScriptID 303 1) setLoop: 2 cel: 0 setCycle: End self) ; slotGuy
				)
			)
			(5
				(gLongSong2 number: 615 loop: -1 play:)
				(sweeper
					setMotion:
						PolyPath
						(- (register x:) 10)
						(- (register y:) 1)
						self
				)
			)
			(6
				(sweeper setLoop: 2 cel: 0 cycleSpeed: 8 setCycle: End self)
			)
			(7
				(register hide:)
				(sweeper setLoop: 3 cel: 0 setCycle: CT 1 1 self)
			)
			(8
				(gLongSong2 number: 616 loop: -1 play:)
				(sweeper setLoop: 3 cel: 2 setCycle: CT 5 1 self)
			)
			(9
				(gLongSong2 stop:)
				(sweeper setLoop: 3 cel: 6 setCycle: CT 10 1 self)
			)
			(10
				(gLongSong2 number: 616 loop: -1 play:)
				(sweeper setLoop: 3 cel: 11 setCycle: End self)
			)
			(11
				(gLongSong2 stop:)
				(= cycles 3)
			)
			(12
				(sweeper setLoop: 4 cel: 0 setCycle: End self)
			)
			(13
				(gLongSong2 number: 615 loop: -1 play:)
				(sweeper
					setLoop: 1
					cycleSpeed: 4
					setCycle: Fwd
					setMotion: PolyPath 325 115 self
				)
			)
			(14
				(if (== register gEgo)
					(gCurRoom newRoom: 42)
				else
					(sweeper dispose:)
					((ScriptID 303 1) dispose:) ; slotGuy
					(if (not global188)
						(HandsOn)
						(if local0
							(User canControl: 0)
						)
					)
				)
				(UnLoad 128 444)
				(UnLoad 128 443)
				(gLongSong2 stop:)
				(= register 0)
				(self dispose:)
			)
		)
	)
)

(instance playSlots of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (>= 3 register 1)
					(self changeState: 3)
				else
					(if (== register 4)
						(= state 3)
					)
					(if (IsFlag 11)
						(gEgo setMotion: PolyPath 256 105 self)
					else
						(Print 43 22) ; "Looks to be something playing it already."
						(HandsOn)
						(self dispose:)
					)
				)
			)
			(1
				(if (>= register 3)
					(widget show: setCycle: Fwd)
				)
				(gEgo view: 77 setLoop: 0 cel: 0 setCycle: End self)
			)
			(2
				(= register 0)
				(gCurRoom newRoom: 44 7)
			)
			(3
				(if (!= register 4)
					(gEgo view: 77 setLoop: 0 cel: 5 setCycle: Beg self)
				)
				(switch register
					(4
						(self changeState: 4)
					)
					(3
						(= state 3)
					)
					(2
						(= state 4)
					)
					(else
						(= state 4)
					)
				)
			)
			(4
				(= state 0)
				(SetFlag 12)
				(SetFlag 13)
				(SetScore 5 156)
				(gEgo view: 79 setLoop: 0 cel: 0 put: 15 setCycle: End self) ; Widget
			)
			(5
				(if (IsFlag 13)
					(ClearFlag 13)
					(widget hide:)
					(gEgo
						view: 79
						setLoop: 0
						cel: 6
						get: 15 ; Widget
						setCycle: Beg self
					)
				else
					(= cycles 3)
				)
			)
			(6
				(if (== register 2)
					(client setScript: breakSlots)
				else
					(NormalEgo 0 1 61)
					(= register 0)
					(gEgo illegalBits: -32768)
					(HandsOn)
					(self dispose:)
				)
			)
		)
	)
)

(instance breakSlots of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 58
					cel: 0
					loop: 4
					cycleSpeed: 4
					setCycle: End self
				)
				(gSoundEffects number: 411 loop: 1 play:)
				(slot
					view: 243
					posn: 282 81
					loop: 0
					cel: 0
					cycleSpeed: 9
					setCycle: End
				)
			)
			(1
				(NormalEgo 0 1 61)
				(= seconds 2)
			)
			(2
				(slot stopUpd:)
				(Print 43 23) ; "Wow, I guess you over-heated the poor old thing."
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance widget of Prop
	(properties
		x 268
		y 90
		description {widget}
		lookStr {It's the widget you got from the Star Generator's pedestal. Don't you remember?}
		view 143
		loop 3
		cycleSpeed 8
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Talk
				(Print 43 24) ; "Widgets don't talk."
			)
			(12 ; Smell
				(Print 43 25) ; "It smells magnetic."
			)
			(11 ; Taste
				(Print 43 26) ; "You now have a tongue-load of iron shavings. Congratulations."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance slugEyes of View
	(properties
		x 305
		y 110
		view 440
		cel 3
		priority 11
		signal 16400
	)

	(method (doVerb theVerb)
		(slugGuy doVerb: theVerb &rest)
	)
)

(instance kzittenArm of Prop
	(properties
		x 119
		y 143
		description {kzitten's arm}
		approachX 148
		approachY 185
		view 436
		loop 3
		signal 16384
		cycleSpeed 4
	)

	(method (doVerb theVerb)
		(kzittenHead doVerb: theVerb &rest)
	)
)

(instance kzittenHead of Prop
	(properties
		x 108
		y 151
		description {kzitten}
		approachX 148
		approachY 185
		lookStr {This character kinda reminds you of a cute, fluffy little kitten you had when you were a kid - except that he weighs about 400 kilos and has foot-long, razor-sharp claws and a bad attitude.}
		view 436
		loop 1
		signal 16384
		cycleSpeed 4
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 3 5) ; Do, Talk
		(kzittenArm approachVerbs: 3 5) ; Do, Talk
		(kzitten approachVerbs: 3 5) ; Do, Talk
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(self setScript: scareEgo self)
			)
			(5 ; Talk
				(if local0
					(Print 43 27) ; "You'll have to get closer."
				else
					(Print 43 28 #at 100 101) ; "Hi. The name's Wilco. Roger Wilco. What's yours?"
					(Print 43 29 #at 38 68) ; "I am sometimes called Speaker to Cartoons, and sometimes Flayer of Soft Pink Mammals."
					(Print 43 30 #at 177 141) ; "Mind if I sit down?"
					(Print 43 31 #at 48 108) ; "Buzz off, monkey-boy!"
				)
			)
			(11 ; Taste
				(Print 43 32) ; "The thought of your tongue laid out in four neat slices like luncheon meat puts this idea right out of your head."
			)
			(12 ; Smell
				(Print 43 33) ; "Could be Rid-O-Fleaz Shampoo, or just a really manly aftershave."
			)
			(4 ; Inventory
				(switch invItem
					(10 ; buckazoid
						(Print 43 34) ; "He might be insulted by an offer of money. You won't like him when he's insulted."
					)
					(0 ; Cartridge
						(Print 43 35) ; "Showing him the cartridge won't make him one bit friendlier."
					)
					(15 ; Widget
						(Print 43 36) ; "You can't see any reason to offer the widget to him."
					)
					(2 ; Gadget
						(Print 43 37) ; "This guy makes himself pretty clear without translation."
					)
					(4 ; Knife
						(Print 43 38) ; "Reality check! Does this seem like a good idea to you?"
					)
					(5 ; Dehydrated_Water
						(Print 43 39) ; "Cats are notorious for not liking water."
					)
					(11 ; Jetpack
						(Print 43 40) ; "If he decided to keep it, you wouldn't live to get it back."
					)
					(17 ; Bar_Coupon
						(Print 43 41) ; "He'll more than likely slice it up for practice, and then where'll you be, huh?"
					)
					(18 ; Droids-B-Us_coupon
						(Print 43 41) ; "He'll more than likely slice it up for practice, and then where'll you be, huh?"
					)
					(else
						(super doVerb: theVerb invItem)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)

	(method (cue)
		(switch (++ local94)
			(1
				(Print 43 42) ; "That would be my first clue not to bother this guy again."
			)
			(2
				(Print 43 43) ; "He doesn't want to be bothered."
			)
			(else
				(Print 43 44) ; "Leave him alone."
			)
		)
	)
)

(instance slugGuy of Prop
	(properties
		x 305
		y 110
		description {slug guy}
		lookStr {This guy appears to have blown in from Santa Cruz.}
		view 440
		priority 11
		signal 16400
		cycleSpeed 4
		detailLevel 3
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 43 45) ; "You'd rather not, really."
			)
			(11 ; Taste
				(Print 43 46) ; "You left your slug recipes in your other pair of pants."
			)
			(5 ; Talk
				(Print 43 47) ; "Forget it. This guy's not exactly a sparkling conversationalist."
			)
			(12 ; Smell
				(Print 43 48) ; "Ahh, the heady fragrance of Eau de Banana Slug."
			)
			(4 ; Inventory
				(switch invItem
					(10 ; buckazoid
						(Print 43 49) ; "What could you possibly be thinking of?"
					)
					(0 ; Cartridge
						(Print 43 50) ; "You decide against getting slug secretions on the cartridge."
					)
					(15 ; Widget
						(Print 43 51) ; "He's not at all interested in your widget."
					)
					(2 ; Gadget
						(Print 43 52) ; "Slugspeak is seldom improved by translation."
					)
					(4 ; Knife
						(Print 43 53) ; "Do you really want to get slime on your knife."
					)
					(5 ; Dehydrated_Water
						(Print 43 54) ; "He seems supremely disinterested in your water."
					)
					(11 ; Jetpack
						(Print 43 55) ; "You show him your jetpack. He shrugs. It's sort of a slug shrug. Spooky!"
					)
					(17 ; Bar_Coupon
						(Print 43 56) ; "Do you really want to get slug slime all over these? I thought not."
					)
					(18 ; Droids-B-Us_coupon
						(Print 43 56) ; "Do you really want to get slug slime all over these? I thought not."
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
	)
)

(instance triGirl of Prop
	(properties
		x 268
		y 119
		description {trigirl}
		approachX 223
		approachY 153
		lookStr {You must be getting dizzy - you're seeing triple.}
		view 439
		cel 7
		priority 11
		signal 16400
		cycleSpeed 4
		detailLevel 3
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 5 3 12) ; Talk, Do, Smell
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 43 57) ; "She'll make you SO sorry if you touch one of those."
			)
			(11 ; Taste
				(Print 43 58) ; "Most extraterrestrials won't do that on the first date. Maybe you should just listen to them."
			)
			(5 ; Talk
				(Print 43 59 #at 128 76) ; "So - you come here often?"
				(Print 43 60 #at 150 130) ; "Get outta my face, Pinky."
				(Print 43 61) ; "You've decided she's not your type. Heck, she's not even your species!"
			)
			(12 ; Smell
				(Print 43 62) ; "She smells as great as she looks, but maybe a little less green."
			)
			(4 ; Inventory
				(switch invItem
					(10 ; buckazoid
						(Print 43 63) ; "You're certain she will misunderstand your generous gesture."
					)
					(0 ; Cartridge
						(Print 43 64) ; "She ignores the cartridge, much as she ignores you."
					)
					(15 ; Widget
						(Print 43 65) ; "The thought of showing her your widget fills you with deep feelings of inadequacey."
					)
					(2 ; Gadget
						(Print 43 66) ; "She remains unimpressed."
					)
					(4 ; Knife
						(Print 43 67) ; "You can't imagine she'd care about your genuine Xenon Army Knife."
					)
					(5 ; Dehydrated_Water
						(Print 43 68) ; "Your dehydrated water couldn't possibly taste better than what she's drinking."
					)
					(11 ; Jetpack
						(Print 43 69) ; "She's pretty nearly as interested in your jetpack as she is in you, which is to say not much."
					)
					(17 ; Bar_Coupon
						(Print 43 70) ; "She's seen lots of coupons bigger and better than yours."
					)
					(18 ; Droids-B-Us_coupon
						(Print 43 70) ; "She's seen lots of coupons bigger and better than yours."
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
	)
)

(instance fenris of Prop
	(properties
		x 215
		y 172
		z 26
		description {fenris}
		approachX 205
		approachY 155
		lookStr {This character looks like an economy-size version of your Uncle Buck's toupee.}
		view 438
		cel 2
		priority 11
		signal 16400
		cycleSpeed 4
		detailLevel 2
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 5 3 12) ; Talk, Do, Smell
		(fenrisBody approachVerbs: 5 3 12) ; Talk, Do, Smell
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 43 71) ; "His fur has the texture of a nylon bath rug that has been microwaved on HIGH."
			)
			(11 ; Taste
				(Print 43 72) ; "Most extraterrestrials won't do that on the first date. Maybe you should just listen to them."
			)
			(5 ; Talk
				(Print 43 73 #at 100 68) ; "Can I offer you a Milk-Bone?" you inquire in an attempt to be friendly."
				(Print 43 74 #at 224 149) ; "Grrrrrrr!"
				(Print 43 75) ; "You decide you just can't make friends with everybody."
			)
			(12 ; Smell
				(Print 43 76) ; "Pretty much like wet dog."
			)
			(4 ; Inventory
				(switch invItem
					(10 ; buckazoid
						(Print 43 77) ; "This doesn't seem wise, even to you."
					)
					(0 ; Cartridge
						(Print 43 78) ; "He shows absolutely no interest in the cartridge."
					)
					(15 ; Widget
						(Print 43 79) ; "He seems less interested in the widget than in that cute drink in his paw."
					)
					(2 ; Gadget
						(Print 43 80) ; "Since he isn't inclined to talk to you, there's not much point trying to translate."
					)
					(4 ; Knife
						(Print 43 81) ; "On second thought, maybe you'd just better keep it in your pocket."
					)
					(5 ; Dehydrated_Water
						(Print 43 82) ; "He seems well taken care of in the drink department."
					)
					(11 ; Jetpack
						(Print 43 83) ; "You wonder why you're offering this giant hairball your new jetpack and are forced to admit you don't know."
					)
					(17 ; Bar_Coupon
						(Print 43 84) ; "You wisely decide that flashing your coupons at fur-face here would be a serious waste of your time."
					)
					(18 ; Droids-B-Us_coupon
						(Print 43 84) ; "You wisely decide that flashing your coupons at fur-face here would be a serious waste of your time."
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
	)
)

(instance bartender of Prop
	(properties
		x 296
		y 169
		description {bartender}
		approachX 240
		approachY 158
		lookStr {A fine example of his species - whatever THAT is.}
		view 442
		loop 1
		priority 15
		signal 16400
		cycleSpeed 4
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 4 5) ; Inventory, Talk
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 43 85) ; "You decide you'd rather live."
			)
			(5 ; Talk
				(cond
					((not local0)
						(gCurRoom setScript: moveEgoToBar)
					)
					((User input:)
						(gCurRoom setScript: moveEgoToBar 0 1)
					)
				)
			)
			(4 ; Inventory
				(switch invItem
					(17 ; Bar_Coupon
						(if (not local0)
							(gCurRoom setScript: moveEgoToBar 0 6)
						else
							(gCurRoom setScript: moveEgoToBar 0 5)
						)
					)
					(0 ; Cartridge
						(Print 43 86) ; "He doesn't seem willing to accept this in trade for a beer."
					)
					(15 ; Widget
						(Print 43 87) ; "The bartender only wants money."
					)
					(2 ; Gadget
						(Print 43 88) ; "He doesn't want this - he wants money."
					)
					(4 ; Knife
						(Print 43 89) ; "Threatening the bartender will probably get you Laze-O-Toasted. Try buying a drink instead."
					)
					(5 ; Dehydrated_Water
						(Print 43 90) ; "No, dummy - he's supposed to give YOU drinks."
					)
					(11 ; Jetpack
						(Print 43 91) ; "The bartender does not recognize your jetpack as currency. He wants to see Buckazoids."
					)
					(else
						(super doVerb: theVerb invItem &rest)
					)
				)
			)
			(11 ; Taste
				(Print 43 92) ; "Try it and this guy is likely to use his beer tap on your head."
			)
			(12 ; Smell
				(Print 43 93) ; "His armpits could etch glass."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance bartenderHead of Prop
	(properties
		x 284
		y 135
		approachX 240
		approachY 158
		view 442
		loop 2
		priority 15
		signal 16400
		cycleSpeed 4
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 4 5) ; Inventory, Talk
	)

	(method (doVerb theVerb)
		(bartender doVerb: theVerb &rest)
	)
)

(instance chp_dail of Prop
	(properties
		name {chp&dail}
		x 201
		y 185
		description {chip and dale}
		lookStr {Cute little purple guys, eh! They sure can put away the brew.}
		view 437
		loop 2
		priority 15
		signal 16400
		cycleSpeed 2
		detailLevel 2
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 43 94) ; "Maybe you'd better buy your own beer."
			)
			(11 ; Taste
				(Print 43 58) ; "Most extraterrestrials won't do that on the first date. Maybe you should just listen to them."
			)
			(5 ; Talk
				(Print 43 95) ; "What's the use? You can't understand a word they're saying."
			)
			(12 ; Smell
				(Print 43 96) ; "Sniffing others is a ritual best left to dogs and other four-legged creatures."
			)
			(4 ; Inventory
				(switch invItem
					(10 ; buckazoid
						(Print 43 97) ; "The little purple guy doesn't seem to understand your offer of money."
					)
					(0 ; Cartridge
						(Print 43 98) ; "The cartridge doesn't interest him in the least."
					)
					(15 ; Widget
						(Print 43 99) ; "He seems not to care about the widget."
					)
					(2 ; Gadget
						(Print 43 100) ; "Even translated, his speech is gibberish."
					)
					(4 ; Knife
						(Print 43 101) ; "He doesn't seem to be either interested or threatened by your knife."
					)
					(5 ; Dehydrated_Water
						(Print 43 102) ; "He doesn't seem to be thirsty."
					)
					(11 ; Jetpack
						(Print 43 103) ; "Careful! You don't want to hurt the little guy."
					)
					(17 ; Bar_Coupon
						(Print 43 104) ; "The little guy shows no interest in your coupon. Did you think he would?"
					)
					(18 ; Droids-B-Us_coupon
						(Print 43 104) ; "The little guy shows no interest in your coupon. Did you think he would?"
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
	)
)

(instance slot of Prop
	(properties
		x 279
		y 70
		view 143
	)

	(method (doVerb theVerb)
		(slotMachine doVerb: theVerb &rest)
	)
)

(instance sweeper of Actor
	(properties
		x 325
		y 115
		description {sweeper}
		lookStr {The sweeper is a small motorized device which scans the floor for debris and removes it within moments of detection. There is nothing special about it, otherwise.}
		view 444
		signal 16384
		cycleSpeed 4
		illegalBits 0
		moveSpeed 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(11 ; Taste
				(Print 43 105) ; "The robot observes that your teeth haven't been cleaned in a long time."
			)
			(12 ; Smell
				(Print 43 106) ; "The robot observes that your nostril hairs could use trimming."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance beerMug of Actor
	(properties
		x 252
		y 136
		description {beer mug}
		lookStr {The beer mug is in the shape of a rocket.}
		yStep 5
		view 143
		loop 4
		priority 11
		signal 18448
		cycleSpeed 1
		xStep 5
		moveSpeed 1
	)
)

(instance C_DbeerMug of Actor
	(properties
		name {C&DbeerMug}
		x 209
		y 187
		description {beer mug}
		lookStr {The beer mug is just a normal beer mug.}
		yStep 5
		view 143
		loop 2
		priority 15
		signal 18448
		cycleSpeed 1
		xStep 5
		moveSpeed 1
	)
)

(instance fenrisBody of Feature
	(properties
		description {fenris}
		sightAngle 45
		onMeCheck 128
		approachX 205
		approachY 155
		lookStr {not used}
	)

	(method (doVerb theVerb)
		(fenris doVerb: theVerb &rest)
	)
)

(instance kzitten of Feature
	(properties
		description {kzitten}
		sightAngle 45
		onMeCheck 64
		approachX 148
		approachY 185
		lookStr {not used}
	)

	(method (doVerb theVerb)
		(kzittenHead doVerb: theVerb &rest)
	)
)

(instance lightCannon of Feature ; UNUSED
	(properties
		x 41
		y 10
		description {light cannon}
		onMeCheck 512
		lookStr {This appears to be a 6 megawatt Kurtzman Kannon of the type used to signal the end of particularly bad acts on the old LaserGong show.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 43 107) ; "You'll only hurt yourself"
			)
			(12 ; Smell
				(Print 43 108) ; "A faint odor of ozone lingers in the air near the business end of the device."
			)
			(11 ; Taste
				(Print 43 109) ; "It's not likely you could taste it from here, or would want to, for that matter."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance barTop of Feature
	(properties
		description {barTop}
		onMeCheck 8
		approachX 240
		approachY 158
		lookStr {This is the bar top.}
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 3) ; Do
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(= x ((User curEvent:) x:))
				(= y ((User curEvent:) y:))
				(super doVerb: theVerb invItem &rest)
			)
			(3 ; Do
				(if (not local0)
					(= local93 1)
					(gCurRoom setScript: moveEgoToBar)
				else
					(= local93 1)
					(gCurRoom setScript: moveEgoToBar 0 1)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance slotMachine of Feature
	(properties
		x 282
		y 77
		nsTop 50
		nsLeft 259
		nsBottom 105
		nsRight 305
		description {slot machine}
		sightAngle 45
		onMeCheck 4
		lookStr {It appears to be an electronic slot machine.}
	)

	(method (doVerb theVerb invItem)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(switch theVerb
			(3 ; Do
				(cond
					((IsFlag 63)
						(Print 43 110) ; "The "Slots-O-Death" machine seems to have met its match. It will no longer be a deadly temptation for unsuspecting space-farers such as yourself."
					)
					((not (gCurRoom script:))
						(gCurRoom setScript: playSlots)
					)
					(else
						(super doVerb: theVerb invItem)
					)
				)
			)
			(4 ; Inventory
				(if (IsFlag 63)
					(Print 43 110) ; "The "Slots-O-Death" machine seems to have met its match. It will no longer be a deadly temptation for unsuspecting space-farers such as yourself."
				else
					(switch invItem
						(15 ; Widget
							(if (not (gCurRoom script:))
								(gCurRoom setScript: playSlots 0 4)
							else
								(super doVerb: theVerb invItem)
							)
						)
						(10 ; buckazoid
							(if (not (gCurRoom script:))
								(gCurRoom setScript: playSlots)
							else
								(super doVerb: theVerb invItem)
							)
						)
						(else
							(super doVerb: theVerb invItem)
						)
					)
				)
			)
			(11 ; Taste
				(Print 43 111) ; "Watch it or you'll get zapped."
			)
			(12 ; Smell
				(Print 43 112) ; "Hmmm...It smells vaguely like burnt flesh."
			)
			(2 ; Look
				(if (IsFlag 63)
					(Print 43 110) ; "The "Slots-O-Death" machine seems to have met its match. It will no longer be a deadly temptation for unsuspecting space-farers such as yourself."
				else
					(super doVerb: theVerb invItem &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance slotLaser of Feature
	(properties
		x 45
		y 178
		z 167
		nsTop -1
		nsLeft 25
		nsBottom 23
		nsRight 65
		description {slotLaser}
		sightAngle 45
		lookStr {It appears to be some sort of beam generation unit. The business end is pointed at the far wall.}
	)
)

(instance slotPoly of Polygon
	(properties
		type PBarredAccess
	)
)

(instance stagePoly of Polygon
	(properties
		type PBarredAccess
	)
)

(instance bartenderT of Talker
	(properties
		x 10
		y 10
		nsTop 6
		nsLeft 205
		view 511
	)
)

(instance bartenderBust of View
	(properties
		view 511
		cel 1
	)
)

(instance bartenderEyes of Prop
	(properties
		nsTop 13
		nsLeft 37
		view 511
		loop 1
		cycleSpeed 30
	)
)

(instance bartenderMouth of Prop
	(properties
		nsTop 23
		nsLeft 6
		view 511
		loop 2
		cycleSpeed 12
	)
)

