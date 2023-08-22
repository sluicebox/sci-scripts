;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 331)
(include sci.sh)
(use Main)
(use Teller)
(use buy)
(use n814)
(use Print)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Rev)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm331 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10
	local11
	local12
	local13
	local14
	local15
	[local16 8] = [0 6 -23 27 25 22 -26 999]
	[local24 5] = [0 20 24 21 999]
	[local29 5]
	[local34 4] = [0 -23 999 3]
	[local38 6] = [0 3 4 6 5 999]
	[local44 8]
	[local52 2] = [0 999]
	[local54 6] = [0 34 4 6 5 999]
	[local60 8]
	[local68 2] = [0 999]
	[local70 12] = [0 22 40 41 25 46 47 44 42 43 45 999]
	[local82 4]
	[local86 2] = [0 999]
)

(instance rm331 of Rm
	(properties
		noun 20
		picture 331
		style 2
	)

	(method (init)
		(self setRegions: 801) ; Town
		(gWalkHandler add: self)
		(= [local29 0] @local16)
		(= [local29 1] @local24)
		(= [local29 2] 999)
		(= [local44 0] @local38)
		(= [local44 1] 999)
		(= [local60 0] @local54)
		(= [local60 1] 999)
		(= [local82 0] @local70)
		(= [local82 1] 999)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 189 306 189 306 162 197 162 181 146 143 146 137 152 88 152 51 189 0 189
					yourself:
				)
		)
		(LoadMany rsSOUND 2044 2043)
		(barTune play:)
		(super init:)
		(= local11 0)
		(= local5 0)
		(if (>= gTimeOfDay 4)
			(windowShudder init:)
		)
		(barKeepTeller init: bartender @local16 @local29 @local34)
		(bartender init: actions: barKeepTeller setScript: bartenderScript)
		(crusherTeller init: crusher @local70 @local82 @local86)
		(crusher init: posn: 31 164 stopUpd:)
		(ClearFlag 113)
		(cond
			((or (>= global120 6) (and (> global120 0) (not (IsFlag 161))))
				(SetFlag 113)
			)
			((IsFlag 261)
				(= global120 6)
				(SetFlag 113)
			)
			((and (IsFlag 235) (== global120 3))
				(= global120 4)
			)
			((and (IsFlag 161) (<= global120 1))
				(= global120 2)
			)
			((== global120 3)
				(SetFlag 113)
			)
		)
		(onWindow init: setOnMeCheck: 26505)
		(onFloor init: setOnMeCheck: 26505)
		(onTableBottom init: setOnMeCheck: 26505)
		(onRtTableTop init: setOnMeCheck: 26505)
		(onLtTable init: setOnMeCheck: 26505)
		(onKeg1 init: setOnMeCheck: 26505)
		(onKeg2 init: setOnMeCheck: 26505)
		(onKeg3 init: setOnMeCheck: 26505)
		(onKeg4 init: setOnMeCheck: 26505)
		(onWholeKeg init: setOnMeCheck: 26505)
		(onBar init: setOnMeCheck: 26505)
		(onFloor init: setOnMeCheck: 1 4)
		(SetFlag 255)
		(ClearFlag 254)
		(= local5 0)
		(= local4 0)
		(= local6 0)
		(if (not (IsFlag 113))
			(paper init: approachVerbs: 4 stopUpd:) ; Do
		)
		(rtStool init:)
		(guck init:)
		(puddle init:)
		(barb setPri: 6 ignoreActors: addToPic: init:)
		(ctrStool
			init:
			approachVerbs:
				4 ; Do
				34 ; acorn
				42 ; candelabra
				44 ; candleSticks
				46 ; cheetaurClaw
				16 ; dagger
				38 ; fairyDust
				21 ; flask
				36 ; flowers
				39 ; flyingWater
				32 ; fruit
				29 ; ghostOil
				37 ; greenFur
				22 ; healingPotion
				26 ; brassKey
				14 ; leather
				17 ; lockPick
				27 ; magicGem
				23 ; manaPotion
				31 ; mandrake
				30 ; magicMirror
				40 ; mushroom
				43 ; musicBox
				45 ; pearls
				53 ; paper
				11 ; rations
				28 ; ring
				20 ; rock
				35 ; seed
				15 ; shield
				10 ; silver
				24 ; staminaPotion
				12 ; sword
				18 ; thiefKit
				19 ; thiefLicense
				47 ; trollBeard
				41 ; vase
				33 ; vegetables
			ignoreActors:
		)
		(playerTeller init: player1 @local54 @local60 @local68)
		(player1
			init:
			actions: playerTeller
			setScript: cardScript
			setCycle: Fwd
		)
		(playerTeller2 init: player2 @local38 @local44 @local52)
		(player2 init: actions: playerTeller2 setCycle: Fwd)
		(smoke init: setPri: 4 setCycle: Fwd startUpd:)
		(trap init: setPri: 5)
		(caddy init:)
		(barSound number: 2044 init:)
		(NormalEgo)
		(switch gPrevRoomNum
			(332
				(ooze init: setScript: oozeDrip)
				(gEgo init: posn: 120 180 loop: 0)
			)
			(else
				(self setScript: sEnter)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Walk
				(if (IsFlag 254)
					(gEgo setScript: standUpScript)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(1 ; Look
				(gEgo setScript: describeTavern)
			)
			(2 ; Talk
				(if (IsFlag 254)
					(gMessager say: noun theVerb 33 1) ; "Talking to nobody in particular, you explain that your life has been one big mistake. Women don't understand you, and your career as a Hero is going nowhere fast. Everyone ignores you. You suddenly feel much better."
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (doit)
		(cond
			(script)
			((gEgo script:) 0)
			((== (gEgo edgeHit:) EDGE_BOTTOM)
				(gCurRoom setScript: sExit)
			)
		)
		(super doit:)
	)

	(method (cue)
		(switch (++ local0)
			(1
				(paper hide:)
				(SetFlag 113)
				(= local9 1)
				(++ global120)
				(SolvePuzzle 731 2)
				(gMessager say: 18 4 0 1 self) ; "You pick up the note."
			)
			(2
				(gMessager say: 20 0 71 1 self) ; "You smooth out the piece of paper and read:"
			)
			(3
				(cond
					((== global120 1)
						(gMessager say: 20 0 76) ; "B - He's starting to get suspicious. Hold off on our meetings for a bit, but I'll keep you posted by these notes. - B."
					)
					((== global120 3)
						(gMessager say: 20 0 66) ; "B - Meet me at the archery range as soon as possible. Urgent!"
					)
					(else
						(gMessager say: 20 0 68) ; "B - That new adventurer is getting too nosy. Deal with him. - B"
						(= global120 6)
					)
				)
				(= local0 0)
			)
		)
	)

	(method (dispose)
		(SetFlag 98)
		(gWalkHandler delete: self)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(DisposeScript 342)
		(super newRoom: newRoomNumber)
	)
)

(instance egoOnChair of Feature
	(properties
		x 65
		y 142
		z 100
		nsTop 91
		nsLeft 137
		nsBottom 142
		nsRight 167
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Walk
				(gEgo setScript: standUpScript)
			)
			(2 ; Talk
				(if (IsFlag 254)
					(gMessager say: noun theVerb 33 1)
				else
					(chair doVerb: theVerb &rest)
				)
			)
			(else
				(chair doVerb: theVerb &rest)
			)
		)
	)

	(method (handleEvent event)
		(if
			(and
				(not (== (event message:) JOY_NULL))
				(== (gTheIconBar curIcon:) (gTheIconBar walkIconItem:))
				(& (event type:) $0040) ; direction
			)
			(gCurRoom setScript: standUpScript)
			(event claimed: 1)
			(return)
		else
			(super handleEvent: event)
		)
	)

	(method (init)
		(super init: &rest)
		(gDirectionHandler add: self)
	)

	(method (dispose)
		(gDirectionHandler delete: self)
		(super dispose:)
	)
)

(instance onWindow of Feature
	(properties
		x 23
		y 94
		noun 25
		nsTop 50
		nsBottom 94
		nsRight 63
	)
)

(instance onBar of Feature
	(properties
		x 164
		y 107
		noun 4
		nsTop 103
		nsLeft 70
		nsBottom 112
		nsRight 258
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (IsFlag 254)
					(head setCel: 1 stopUpd:)
				)
				(gMessager say: 4 1 33) ; "It doesn't look like the Barkeeper ever wipes up spills, and the glasses are just as filthy."
			)
			(else
				(gCurRoom doVerb: theVerb &rest)
			)
		)
	)
)

(instance onRtTableTop of Feature
	(properties
		x 243
		y 158
		z 27
		noun 22
		nsTop 124
		nsLeft 229
		nsBottom 138
		nsRight 258
	)
)

(instance onLtTable of Feature
	(properties
		x 96
		y 134
		noun 17
		nsTop 121
		nsLeft 68
		nsBottom 148
		nsRight 124
	)
)

(instance onTableBottom of Feature
	(properties
		x 250
		y 149
		noun 5
		nsTop 143
		nsLeft 235
		nsBottom 155
		nsRight 266
	)
)

(instance onKeg1 of Feature
	(properties
		x 97
		y 75
		noun 16
		nsTop 49
		nsLeft 83
		nsBottom 87
		nsRight 111
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 16 1) ; "The world-famous Troll's Sweat is always fresh. It looks lean, mean, and green."
			)
			(4 ; Do
				(if local8
					(cond
						((not (IsFlag 254))
							(gMessager say: 3 0 16) ; "Sit down first!"
						)
						((> local5 0)
							(gMessager say: 13 0 9) ; "You'll need the bartender's help on that one."
						)
						(else
							(gMessager say: 3 0 8 2) ; "You'll need to buy one."
							(= local4 0)
						)
					)
				else
					(gMessager say: 16 0 9) ; "Sounds potent, but you'd better go see the bartender if you want some."
				)
			)
			(else
				(gCurRoom doVerb: theVerb &rest)
			)
		)
	)
)

(instance onKeg2 of Feature
	(properties
		x 165
		y 68
		noun 12
		nsTop 49
		nsLeft 149
		nsBottom 87
		nsRight 182
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 12 1) ; "Dragon's Breath is the house specialty, and it's Crusher's personal favorite. The fumes hurt your eyes."
			)
			(4 ; Do
				(if local8
					(cond
						((not (IsFlag 254))
							(gMessager say: 3 0 16) ; "Sit down first!"
						)
						((> local5 0)
							(gMessager say: 13 0 9) ; "You'll need the bartender's help on that one."
						)
						(else
							(gMessager say: 3 0 8 2) ; "You'll need to buy one."
							(= local4 0)
						)
					)
				else
					(gMessager say: 12 0 9) ; "Well then! Belly up to the bar and get some Dragon's Breath!"
				)
			)
			(else
				(gCurRoom doVerb: theVerb &rest)
			)
		)
	)
)

(instance onKeg3 of Feature
	(properties
		x 239
		y 73
		noun 13
		nsTop 49
		nsLeft 222
		nsBottom 86
		nsRight 256
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 13 1) ; "Some of the finest ale in the valley."
			)
			(4 ; Do
				(if local8
					(cond
						((not (IsFlag 254))
							(gMessager say: 3 0 16) ; "Sit down first!"
						)
						((> local5 0)
							(gMessager say: 13 0 9) ; "You'll need the bartender's help on that one."
						)
						(else
							(gMessager say: 3 0 8 2) ; "You'll need to buy one."
							(= local4 0)
						)
					)
				else
					(gMessager say: 13 0 9) ; "You'll need the bartender's help on that one."
				)
			)
			(else
				(gCurRoom doVerb: theVerb &rest)
			)
		)
	)
)

(instance onKeg4 of Feature
	(properties
		x 199
		y 82
		noun 14
		nsTop 77
		nsLeft 187
		nsBottom 96
		nsRight 211
	)
)

(instance onWholeKeg of Feature
	(properties
		x 166
		y 48
		noun 15
		nsTop 21
		nsLeft 64
		nsBottom 75
		nsRight 268
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (IsFlag 254)
					(head setCel: 2 stopUpd:)
				)
				(gMessager say: 15 1) ; "From the size of the ancient oak kegs, you surmise that the drinking of large quantities of beverages is the main pastime in this establishment."
			)
			(else
				(gCurRoom doVerb: theVerb &rest)
			)
		)
	)
)

(instance onFloor of Feature
	(properties
		x 171
		y 169
		noun 10
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (and (gEgo inRect: 137 138 180 155) (not (IsFlag 113)))
					(gMessager say: 18 1 48) ; "You see a crumpled piece of paper under the stool."
				else
					(gMessager say: 10 1 9) ; "It looks like something you'd expect to see in a tavern, but a little dirtier."
				)
			)
			(4 ; Do
				(if (IsFlag 254)
					(gEgo setScript: standUpScript)
				else
					(gMessager say: 10 4 9) ; "Go ahead and pick the dirt up, but if you want my opinion... Nothing on Shapier would induce me to remove the years of accumulated dirt!"
				)
			)
			(53 ; paper
				(gEgo setScript: putItBack)
			)
			(else
				(gCurRoom doVerb: theVerb &rest)
			)
		)
	)
)

(instance deadMug of View
	(properties
		x 168
		y 106
		noun 26
		view 331
		cel 1
		priority 14
		signal 16400
	)
)

(instance ctrStool of View
	(properties
		x 151
		y 143
		noun 9
		approachX 151
		approachY 155
		view 331
		loop 3
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (IsFlag 254)
					(gMessager say: 9 1 33) ; "Yup, You're sitting on a stool."
				else
					(gMessager say: 9 1 9) ; "Looks like the only place to sit is at the bar."
				)
			)
			(4 ; Do
				(if (IsFlag 254)
					(gMessager say: 9 4 33) ; "You are already sitting on the stool."
				else
					(gEgo setScript: sitDown)
				)
			)
			(else
				(gCurRoom doVerb: theVerb &rest)
			)
		)
	)
)

(instance rtStool of View
	(properties
		x 197
		y 143
		noun 21
		view 331
		loop 3
		signal 16384
	)
)

(instance guck of View
	(properties
		x 191
		y 118
		noun 11
		view 331
		loop 3
		cel 3
		priority 11
		signal 16400
	)
)

(instance puddle of View
	(properties
		x 197
		y 144
		z 1
		noun 11
		view 331
		loop 3
		cel 2
		priority 10
		signal 16400
	)
)

(instance caddy of View
	(properties
		x 240
		y 126
		view 331
		loop 8
		priority 12
		signal 17
	)
)

(instance windowShudder of View
	(properties
		x 23
		y 95
		noun 25
		view 331
		loop 9
		signal 1
	)
)

(instance barb of View
	(properties
		x 72
		y 240
		z 100
		noun 2
		view 331
		loop 3
		cel 1
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (IsFlag 254)
					(head setCel: 1 stopUpd:)
				)
				(gMessager say: 2 1) ; "So this is where the Barber has lunch. That guy's had so much to drink he looks embalmed."
			)
			(2 ; Talk
				(gMessager say: 2 2) ; "The drunken barber at the end of the bar isn't in any shape to talk, at least not coherently."
			)
			(else
				(gCurRoom doVerb: theVerb &rest)
			)
		)
	)
)

(instance paper of View
	(properties
		x 137
		y 143
		noun 18
		approachX 137
		approachY 150
		view 331
		priority 11
		signal 16401
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 18 1 48) ; "You see a crumpled piece of paper under the stool."
			)
			(4 ; Do
				(if (not (IsFlag 254))
					(gEgo get: 39) ; paper
					(= local9 1)
					(if local1
						(cond
							((== global120 1)
								(gMessager say: 20 0 76) ; "B - He's starting to get suspicious. Hold off on our meetings for a bit, but I'll keep you posted by these notes. - B."
							)
							((== global120 3)
								(gMessager say: 20 0 66) ; "B - Meet me at the archery range as soon as possible. Urgent!"
							)
							(else
								(gMessager say: 20 0 68) ; "B - That new adventurer is getting too nosy. Deal with him. - B"
								(= global120 6)
							)
						)
					else
						(gCurRoom cue:)
					)
				else
					(gMessager say: 8 4 33) ; "You need to get up first."
				)
			)
			(2 ; Talk
				(gCurRoom doVerb: theVerb &rest)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance deck of View ; UNUSED
	(properties
		x 240
		y 126
		view 331
		loop 8
		priority 12
		signal 16400
	)
)

(instance head of Prop
	(properties
		x 150
		y 100
		view 504
		loop 2
		cel 3
		priority 15
		signal 16400
		cycleSpeed 1
	)
)

(instance chair of Prop
	(properties
		x 34
		y 163
		view 338
		loop 2
		signal 16384
	)
)

(instance smoke of Prop
	(properties
		x 170
		y 139
		z 92
		noun 23
		view 331
		loop 1
		signal 16384
		cycleSpeed 12
		detailLevel 2
	)
)

(instance ooze of Prop
	(properties
		x 191
		y 118
		view 331
		loop 4
		priority 11
		signal 16400
		detailLevel 2
	)
)

(instance trap of View
	(properties
		x 12
		y 163
		noun 24
		view 331
		loop 2
	)
)

(instance dB of Prop
	(properties
		view 337
		loop 2
		priority 3
		signal 16400
		cycleSpeed 12
		detailLevel 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if local8
					(cond
						((not (IsFlag 254))
							(gMessager say: 3 0 16) ; "Sit down first!"
						)
						((> local5 0)
							(gMessager say: 13 0 9) ; "You'll need the bartender's help on that one."
						)
						(else
							(gMessager say: 3 0 8 2) ; "You'll need to buy one."
							(= local4 0)
						)
					)
				else
					(gMessager say: 12 0 9) ; "Well then! Belly up to the bar and get some Dragon's Breath!"
				)
			)
			(else
				(gCurRoom doVerb: theVerb &rest)
			)
		)
	)
)

(instance player1 of Prop
	(properties
		x 226
		y 151
		noun 6
		view 331
		loop 5
		priority 12
		signal 16
		cycleSpeed 40
		detailLevel 2
	)

	(method (cue)
		(super cue:)
		(self doVerb: 2)
	)
)

(instance playerTeller of Teller
	(properties)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(1 ; Look
				(if (IsFlag 254)
					(head setCel: 2 stopUpd:)
				)
				(gMessager say: 6 1) ; "The butcher is wearing a blood-stained apron. He seems to be deeply involved in the game."
				(return 1)
			)
			(2 ; Talk
				(if (and (!= (gEgo x:) 252) (!= (gEgo y:) 162))
					(if (not (IsFlag 254))
						(gEgo setMotion: PolyPath 252 162 player2)
					else
						(gCurRoom doVerb: theVerb &rest)
					)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(gCurRoom doVerb: theVerb &rest)
			)
		)
		(return 1)
	)
)

(instance player2 of Prop
	(properties
		x 262
		y 148
		noun 1
		view 331
		loop 7
		cel 12
		priority 12
		signal 16
		cycleSpeed 48
		detailLevel 2
	)

	(method (cue)
		(super cue:)
		(self doVerb: 2)
	)
)

(instance playerTeller2 of Teller
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (IsFlag 254)
					(head setCel: 2 stopUpd:)
				)
				(gMessager say: 1 1) ; "The baker seems to be deeply involved in the game. They seem to be using "Old Maid" cards, but it looks like these guys aren't playing with a full deck."
				(return 1)
			)
			(2 ; Talk
				(if (and (!= (gEgo x:) 252) (!= (gEgo y:) 162))
					(if (not (IsFlag 254))
						(gEgo setMotion: PolyPath 252 162 player2)
					else
						(gCurRoom doVerb: theVerb &rest)
					)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(gCurRoom doVerb: theVerb &rest)
			)
		)
		(return 1)
	)
)

(instance barKeepTeller of Teller
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (IsFlag 254)
					(if (> (bartender x:) (gEgo x:))
						(head setCel: 2 stopUpd:)
					else
						(head setCel: 1 stopUpd:)
					)
				)
				(gMessager say: 3 1) ; "This bartender looks tough from his crewcut to his boots. The only thing soft about him is his tattoo which says "MAMA"."
			)
			(2 ; Talk
				(if (IsFlag 254)
					(bartender setScript: 0)
					(super doVerb: theVerb &rest)
				else
					(gMessager say: 3 2 28) ; "The bartender's ignoring you. Maybe you'd better sit down first."
				)
			)
			(4 ; Do
				(if local8
					(if (== gHeroType 2) ; Thief
						(gMessager say: 3 4 28) ; "You'd better talk to Crusher."
					else
						(gMessager say: 3 4) ; "Keep your mitts offa me."
					)
				else
					(gMessager say: 3 4 9) ; "You'll have to get the bartender's attention first."
				)
			)
			(10 ; silver
				(if (IsFlag 254)
					((= gList (List new:))
						add:
							((Clone Ware) name: {Ale} price: {1})
							((Clone Ware) name: {Sweat} price: {5})
							((Clone Ware) name: {Breath} price: {25})
					)
					(switch ((ScriptID 551 0) doit:) ; buy
						(-1
							(gMessager say: 3 10 30) ; "Hey, whaddya doing comin' inta my joint with an empty purse?"
						)
						(1
							(gMessager say: 3 10 32) ; "One well-aged house brew, coming up!"
							(= local4 1)
							(bartender setScript: getAMug)
						)
						(2
							(= local4 2)
							(gMessager say: 3 10 31) ; "One mug of my fine Troll's Sweat, coming up!"
							(bartender setScript: getAMug)
						)
						(3
							(gMessager say: 3 10 29) ; "If you want a mug of Dragon's Breath, house rules say it'll have to be cash up front!"
							(= local4 3)
							(bartender setScript: getAMug)
						)
					)
				else
					(gMessager say: 3 10 9) ; "The bartender can't reach your money. You're not close enough."
				)
			)
			(else
				(gCurRoom doVerb: theVerb &rest)
			)
		)
		(return 1)
	)

	(method (showDialog &tmp temp0)
		(if (== (= temp0 (super showDialog: -26 (== gHeroType 2))) -26) ; Thief
			(= temp0 (Abs temp0))
		)
		(return temp0)
	)
)

(instance bartender of Actor
	(properties
		x 162
		y 102
		noun 3
		view 336
		loop 2
		priority 5
		signal 16400
	)

	(method (doit)
		(cond
			((and (< (gEgo y:) 113) (not (IsFlag 254)) (not local7))
				(= local7 1)
				(bartender setScript: askEgo)
			)
			((and (> (gEgo y:) 113) local7)
				(= local7 0)
				(bartender setScript: bartenderScript)
			)
			((or local7 (IsFlag 254))
				(= local8 1)
			)
			((and (not local7) (not (IsFlag 254)))
				(= local8 0)
			)
		)
		(super doit: &rest)
	)
)

(instance crusher of Prop
	(properties
		noun 8
		approachX 75
		approachY 163
		view 331
		loop 6
	)

	(method (cue param1 &tmp temp0)
		(super cue:)
		(if param1
			(HandsOff)
			(gCast eachElementDo: #stopUpd)
			(crusher view: 338 loop: 0 cycleSpeed: 18 setCycle: End)
			(if (<= (gEgo distanceTo: crusher) 25)
				(if (== (= temp0 (gEgo priority:)) (crusher priority:))
					(++ temp0)
				)
				(gEgo
					setPri: temp0
					setLoop: 1
					setCycle: Rev
					ignoreActors: 1
					setMotion: MoveTo 125 163 param1
				)
			else
				(param1 cue:)
			)
		)
	)
)

(instance crusherTeller of Teller
	(properties)

	(method (showDialog &tmp temp0)
		(if
			(==
				(= temp0
					(super
						showDialog:
							22
							(== local11 1)
							40
							(== local11 2)
							41
							(== local11 3)
							25
							(== local11 1)
							46
							(== local11 2)
							47
							(== local11 3)
							44
							(== local11 1)
							42
							(== local11 2)
							43
							(== local11 3)
					)
				)
				41
			)
			(gEgo setScript: 0)
			(HandsOff)
			(crusher setScript: crusherThrows)
		)
		(if (== temp0 47)
			(gEgo setScript: 0)
			(HandsOff)
			(crusher setScript: crusherThrows)
		)
		(if (== temp0 43)
			(gEgo setScript: 0)
			(HandsOff)
			(crusher setScript: crusherThrows)
		)
		(if (== temp0 45)
			(HandsOff)
			(gCurRoom setScript: talkToHeroScript)
		)
		(return temp0)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(1 ; Look
				(if (IsFlag 254)
					(head setCel: 1 stopUpd:)
				)
				(gMessager say: 8 1) ; "This Goon looks really tough and mean. He's not someone you'd want to fight."
			)
			(4 ; Do
				(if (IsFlag 254)
					(gMessager say: 8 4 33) ; "You need to get up first."
				else
					(gEgo setScript: moveToCrusher)
				)
			)
			(2 ; Talk
				(cond
					((IsFlag 254)
						(gMessager say: 8 4 33) ; "You need to get up first."
					)
					((> argc 1)
						(super doVerb: theVerb)
					)
					(else
						(if (< local11 3)
							(++ local11)
						)
						(gEgo setScript: moveToCrusher 0 1)
					)
				)
			)
			(else
				(gCurRoom doVerb: theVerb &rest)
			)
		)
		(return 1)
	)
)

(instance oozeDrip of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ooze cycleSpeed: (* gHowFast 6) setCycle: CT 7 1 self)
			)
			(1
				(dripSound play:)
				(ooze cycleSpeed: (* gHowFast 2) setCycle: End)
				(= cycles (Random 30 50))
			)
			(2
				(self init:)
			)
		)
	)
)

(instance sitDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 254)
				(HandsOff)
				(gEgo setMotion: MoveTo 162 (gEgo y:) self)
			)
			(1
				(gEgo setMotion: MoveTo 162 148 self)
			)
			(2
				(egoOnChair init:)
				(ctrStool x: 151 y: 143 signal: (| (ctrStool signal:) $4000))
				(gEgo
					view: 504
					loop: 0
					setCel: 0
					signal: (| (gEgo signal:) $4000)
					setPri: 14
				)
				(self cue:)
			)
			(3
				(gEgo signal: (| (gEgo signal:) $4000) setCycle: End self)
			)
			(4
				(gEgo setLoop: 2 posn: 150 140 cel: 0 stopUpd:)
				(head init: setScript: headMove)
				(bartender setScript: askEgo)
				(= local8 1)
				(= ticks 30)
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance standUpScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(egoOnChair dispose:)
				(head dispose: setScript: 0)
				(bartender ignoreActors:)
				(gEgo posn: 162 148 setLoop: 0 setCycle: Beg self)
			)
			(1
				(NormalEgo)
				(gEgo posn: 162 148 setMotion: MoveTo 162 160 self)
			)
			(2
				(ClearFlag 254)
				(= local8 0)
				(HandsOn)
				(bartender setScript: bartenderScript)
				(= ticks 6)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance bartenderScript of Script
	(properties)

	(method (doit)
		(cond
			((> local12 1)
				(-- local12)
				(if local13
					(bartender posn: (bartender x:) 102)
				else
					(bartender posn: (bartender x:) 102)
				)
			)
			((== local12 1)
				(= local12 0)
				(self cue:)
				(if local13
					(= local13 0)
				else
					(= local13 1)
				)
			)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOn)
				(= ticks (Random 20 80))
			)
			(1
				(= cycles 0)
				(bartender
					setCycle: Walk
					loop: 0
					setMotion: MoveTo 240 102 self
				)
			)
			(2
				(bartender loop: 2 cel: 0 setCycle: End self)
			)
			(3
				(= ticks (Random 150 300))
			)
			(4
				(bartender
					setCycle: Walk
					loop: 1
					cel: -1
					setMotion: MoveTo 105 102 self
				)
			)
			(5
				(bartender loop: 2 cel: 0 setCycle: End self)
			)
			(6
				(= ticks (Random 150 300))
			)
			(7
				(self changeState: 1)
			)
		)
	)
)

(instance askEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 1)
			)
			(1
				(if (> (bartender distanceTo: gEgo) 15)
					(bartender
						setCycle: Walk
						cel: 0
						setLoop: (if (< (gEgo x:) (bartender x:)) 1 else 0)
						setMotion:
							MoveTo
							(if (IsFlag 254)
								(+ (gEgo x:) 15)
							else
								(gEgo x:)
							)
							102
							self
					)
				else
					(self cue:)
				)
			)
			(2
				(bartender setLoop: 2 setCel: 2 stopUpd:)
				(if (IsFlag 254)
					(head setCel: 2)
				)
				(= cycles 2)
			)
			(3
				(gMessager say: 3 0 14) ; "Whaddaya want?"
				(HandsOn)
				(User canControl: 0)
				(self dispose:)
			)
		)
	)
)

(instance getAMug of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(deadMug hide:)
				(if (== (gEgo loop:) 3)
					(gEgo loop: 2 cel: 0 stopUpd:)
					(head show:)
				)
				(switch local4
					(2
						(bartender
							setLoop: (if (IsFlag 255) 1 else 6)
							setCycle: Walk
							ignoreActors:
							setMotion: MoveTo 96 102 self
						)
					)
					(else
						(bartender
							setLoop: (if (IsFlag 255) 0 else 5)
							setCycle: Walk
							ignoreActors:
							setMotion: MoveTo 236 102 self
						)
					)
				)
			)
			(1
				(head hide:)
				(gEgo setLoop: 3 setCel: 0)
				(if (IsFlag 255)
					(bartender setLoop: 4 cel: 2 setPri: 5 setCycle: End self)
				else
					(self cue:)
				)
			)
			(2
				(ClearFlag 255)
				(switch local4
					(1
						(self cue:)
					)
					(2
						(self cue:)
					)
					(3
						(User canInput: 1)
						(dB setScript: breathScript)
					)
				)
			)
			(3
				(bartender setLoop: 7 setCel: 0 setCycle: End self)
			)
			(4
				(bartender
					posn: (if (== local4 2) 96 else 236) 102
					setLoop: 3
					setCel: 0
					setCycle: End self
				)
			)
			(5
				(bartender setCycle: Beg self)
			)
			(6
				(bartender
					setCycle: Walk
					setLoop: (if (== local4 2) 5 else 6)
					setCel: -1
					setMotion: MoveTo 167 102 self
				)
			)
			(7
				(bartender setLoop: (if (== local4 2) 0 else 1) cel: 0)
				(gMessager say: 3 0 13) ; "There ya go!"
				(User canInput: 1)
				(= local5 local4)
				(= local4 0)
				(= ticks 36)
			)
			(8
				(if (IsFlag 254)
					(gEgo loop: 3 cel: 0)
				)
				(bartender loop: 2 cel: 2 stopUpd:)
				(if 1
					(++ local6)
				)
				(gEgo setScript: drinkDown)
			)
		)
	)
)

(instance breathScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(bartender
					setLoop: 6
					setCycle: Walk
					setMotion: MoveTo 177 102 self
				)
			)
			(1
				(bartender
					view: 337
					setLoop: 0
					cel: 0
					posn: 164 102
					ignoreActors:
					setCycle: CT 5 1 self
				)
			)
			(2
				(smoke hide:)
				(dB
					init:
					setLoop: 2
					posn: 166 86
					ignoreActors:
					setCycle: CT 6 1 self
				)
			)
			(3
				(barSound number: 2044 play:)
				(bartender setCycle: CT 8 1 self)
				(dB setCycle: End self)
			)
			(4)
			(5
				(dB loop: 3 cel: 0 posn: 169 50)
				(bartender setCycle: End self)
			)
			(6
				(barSound number: 2043 play:)
				(dB setCycle: End self)
			)
			(7
				(smoke show:)
				(bartender cel: 2 setCycle: Beg self)
			)
			(8
				(bartender view: 336 posn: 169 102 loop: 2 cel: 0)
				(self cue:)
			)
			(9
				(bartender setCycle: End self)
				(gMessager say: 3 0 13) ; "There ya go!"
			)
			(10
				(if (IsFlag 254)
					(head hide:)
					(gEgo loop: 3 cel: 0)
				)
				(= local4 0)
				(= local5 3)
				(gEgo setScript: drinkDown)
				(self dispose:)
			)
		)
	)
)

(instance drinkDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setCycle: End self)
			)
			(1
				(switch local5
					(1
						(switch local6
							(1
								(gMessager say: 20 0 52 1 self) ; "This tastes as sour as it smells, and burns your throat as you swallow it. Still, it isn't the worst beer you've ever drunk."
							)
							(2
								(gMessager say: 20 0 53 1 self) ; "You know, that actually tasted fine. This really isn't such a bad place after all, and the bartender reminds you of an old friend you used to know."
							)
							(3
								(gMessager say: 20 0 54 1) ; "Suddenly, you don't feel so good..."
								(client setScript: tooDrunk)
							)
						)
					)
					(2
						(gMessager say: 20 0 81) ; "Smells like Troll's Sweat. Tastes like Troll's Sweat. By golly, it IS Troll's Sweat..."
						(client setScript: tooDrunk)
					)
					(3
						(gMessager say: 20 0 51 1 self) ; "You've never tasted anything like it before."
					)
				)
			)
			(2
				(if (== local5 3)
					(client setScript: breathDeath)
				else
					(gEgo setCycle: Beg self)
				)
			)
			(3
				(= local5 0)
				(User canInput: 1)
				(deadMug init: show:)
				(if 1
					(head show:)
					(gEgo loop: 2 cel: 0)
				)
				(HandsOn)
				(User canControl: 0)
				(client setScript: 0)
			)
		)
	)
)

(instance tooDrunk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setCycle: Beg)
				(= cycles 15)
			)
			(1
				(deadMug show:)
				(= ticks 18)
			)
			(2
				(switch local5
					(1
						(gMessager say: 20 0 82) ; "You seem to have gone a little overboard on the ale (or at least falling off the seat)."
					)
					(2
						(gMessager say: 20 0 83) ; "... and one Troll's Sweat is too many."
					)
				)
				(= ticks 18)
			)
			(3
				(gEgo loop: 6 cel: 0 posn: 152 155 setCycle: End self)
			)
			(4
				(bartenderScript dispose:)
				(gCast eachElementDo: #dispose)
				(gCurRoom drawPic: 400 -32761)
				(self cue:)
			)
			(5
				(SolvePuzzle 605 -5)
				(SetFlag 118)
				(gCurRoom newRoom: 330)
			)
		)
	)
)

(instance breathDeath of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo moveSpeed: 6 cycleSpeed: 6)
				(= seconds 2)
			)
			(1
				(deadMug show:)
				(gMessager say: 20 0 55 1 self) ; "Ohhhhhhhhh woooowwwwwww!!!"
				(gEgo loop: 5 cel: 0 posn: 151 136)
			)
			(2
				(barSound number: 2044 play:)
				(gEgo cycleSpeed: (* gHowFast 3) setCycle: End self)
			)
			(3
				(= seconds 2)
			)
			(4
				(EgoDead 140 141 2 3 337) ; "Maybe you really shouldn't have tried the Dragon's Breath! Better luck next time, and we hope you saved your game."
			)
		)
	)
)

(instance crusherThrows of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(crusher cue: self)
			)
			(1
				(gEgo setCycle: Walk)
				(chair init: ignoreActors: setCycle: End)
				(crusher
					view: 338
					ignoreActors:
					loop: 1
					cel: 0
					cycleSpeed: 18
					setCycle: End self
				)
			)
			(2
				(crusher cel: 2)
				(= cycles 3)
			)
			(3
				(barSound number: 2106 loop: -1 play:)
				(crusher setCycle: Fwd)
				(= seconds 3)
			)
			(4
				(gCast eachElementDo: #dispose)
				(gCurRoom drawPic: 400 -32762)
				(SetFlag 117)
				(gCurRoom newRoom: 330)
			)
		)
	)
)

(instance crusherEscorts of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 1)
			)
			((gEgo setCycle: Walk setMotion: PolyPath 50 175)
				(= ticks 30)
			)
			(1
				(crusher cue: self)
			)
			(2
				(chair init: ignoreActors: setCycle: End)
				(crusher
					ignoreActors:
					setLoop: 1
					setCel: 0
					setCycle: 0
					stopUpd:
				)
				(= ticks 180)
			)
			(3
				(gCast eachElementDo: #dispose)
				(gCurRoom drawPic: 400 -32762)
				(gCurRoom newRoom: 332)
			)
		)
	)
)

(instance moveToCrusher of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 1)
			)
			(1
				(= local14 (gEgo cycleSpeed:))
				(= local15 (gEgo moveSpeed:))
				(= ticks 30)
			)
			(2
				(gEgo setMotion: PolyPath 79 165 self)
			)
			(3
				(if register
					(crusherTeller doVerb: 2 1)
					(self cue:)
				else
					(gMessager say: 20 0 79 1 self) ; "Oh yeah? What's the password?"
				)
			)
			(4
				(gEgo cycleSpeed: local14 moveSpeed: local15)
				(= cycles 1)
			)
			(5
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance talkToHeroScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(gGame setCursor: 999 1 140 80)
				(if (IsFlag 123)
					(switch
						(Print
							addText: 19 0 50 1 0 0 331 ; "Pick the right password!"
							addButton: 1 19 0 49 1 0 14 331 ; "Ach Du Lieber"
							addButton: 2 19 0 49 2 0 30 331 ; "Schweinhund"
							addButton: 3 19 0 49 3 0 46 331 ; "Antwerp"
							addButton: 4 19 0 49 4 0 62 331 ; "Rheingold"
							addButton: 5 19 0 49 5 0 78 331 ; "Schwertfisch"
							addButton: 6 19 0 49 6 0 94 331 ; "Purple Saurus"
							init:
						)
						(1
							(self cue:)
						)
						(2
							(self cue:)
						)
						(3
							(self cue:)
						)
						(4
							(self cue:)
						)
						(5
							(if (and (not [gEgoStats 8]) (not [gEgoStats 9])) ; stealth, pick locks
								(gMessager say: 20 0 77) ; "Hey, he's not one of us! Take care of him!"
								(self setScript: crusherThrows)
							else
								(self setScript: crusherEscorts)
							)
						)
						(6
							(self cue:)
						)
					)
				else
					(Print
						addText: 19 0 50 1 0 0 331 ; "Pick the right password!"
						addButton: 1 19 0 49 1 0 14 331 ; "Ach Du Lieber"
						addButton: 2 19 0 49 2 0 30 331 ; "Schweinhund"
						addButton: 3 19 0 49 3 0 46 331 ; "Antwerp"
						addButton: 4 19 0 49 4 0 62 331 ; "Rheingold"
						addButton: 5 19 0 49 7 0 78 331 ; "Deutschmark"
						addButton: 6 19 0 49 6 0 94 331 ; "Purple Saurus"
						init:
					)
					(self cue:)
				)
			)
			(2
				(switch local11
					(1
						(gMessager say: 8 0 37 1 self) ; "The goon seems to be ignoring you."
					)
					(2
						(gMessager say: 8 0 36 1 self) ; "As you ask him questions, the goon's eyes darken."
					)
					(3
						(gMessager say: 8 0 35 1) ; "Uh oh! It looks like you got Crusher upset!"
						(gEgo setScript: 0)
						(HandsOff)
						(self setScript: crusherThrows)
					)
				)
			)
			(3
				(User canControl: 1 canInput: 1)
				(gGame setCursor: 943 1 140 80)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance headMove of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(head cel: (Random 1 3))
				(-- state)
				(= ticks 120)
			)
		)
	)
)

(instance describeTavern of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Platform 0 4 3 -1)
				(= ticks 1)
			)
			(1
				(gMessager say: 20 1 86 0 self) ; "The small window lets little light into this tavern. It smells like stale ale and other more unpleasant things. The floor is covered with dirt, and the bar with sticky beer."
			)
			(2
				(if (not local2)
					(gMessager say: 20 1 85 1 self) ; "The bartender glares at you as you enter, and so does the ugly goon on the left. You get the impression that you are not welcome."
					(= local2 1)
				else
					(self cue:)
				)
			)
			(3
				(Platform 0 4 2 -1)
				(self dispose:)
			)
		)
	)
)

(instance putItBack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo use: 39) ; paper
				(HandsOff)
				(gEgo setMotion: PolyPath 137 150 self)
			)
			(1
				(gEgo setHeading: 0)
				(= ticks 60)
			)
			(2
				(paper show:)
				(= local9 0)
				(ClearFlag 113)
				(gMessager say: 20 0 78 1 self) ; "You put back the note."
			)
			(3
				(self dispose:)
				(HandsOn)
			)
		)
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(NormalEgo)
				(gEgo init: posn: 162 240 setMotion: MoveTo 156 175 self)
			)
			(1
				(NormalEgo)
				(= cycles 2)
			)
			(2
				(if (not (IsFlag 98))
					(crusher setScript: describeTavern)
				)
				(HandsOn)
				(ooze init: setScript: oozeDrip)
				(self dispose:)
			)
		)
	)
)

(instance sExit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(barTune fade:)
				(gEgo setMotion: MoveTo (gEgo x:) 240 self)
			)
			(1
				(gCurRoom newRoom: 330)
			)
		)
	)
)

(instance cardScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 30] temp30)
		(switch (= state newState)
			(0
				(= ticks (Random 250 400))
			)
			(1
				(if (gEgo inRect: 190 140 310 166)
					(Printf
						@temp0
						(Format @temp0 331 0 (= temp30 (Random 1 1000))) ; "Got any %d's?"
					)
				)
				(= ticks (Random 250 350))
			)
			(2
				(if (gEgo inRect: 190 140 310 166)
					(switch (Random 1 2)
						(1
							(gMessager say: 1 0 1) ; "Go FISH!"
						)
						(2
							(gMessager say: 6 0 1) ; "Go FISH!"
						)
					)
				)
				(self init:)
			)
		)
	)
)

(instance dripSound of Sound
	(properties
		number 116
	)
)

(instance barSound of Sound
	(properties
		number 2044
	)
)

(instance barTune of Sound
	(properties
		flags -1
		number 127
		loop -1
	)
)

