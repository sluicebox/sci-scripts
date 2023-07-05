;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20400)
(include sci.sh)
(use Main)
(use ScrollExit)
(use oHandsOnWhenCued)
(use TPSound)
(use foEExit)
(use Talker)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	roDragonCave 0
)

(instance soTorinLeaveRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if ((ScriptID 64017 0) test: 71) ; oFlags
					(if ((ScriptID 64017 0) test: 72) ; oFlags
						(self setScript: soBoogleWormOut self)
					else
						(self setScript: soBoogleWormOutNoPoo self)
					)
				else
					(self cue:)
				)
			)
			(1
				(gCurRoom newRoom: 20100) ; roCliffScroller
				(self dispose:)
			)
		)
	)
)

(instance foToCliffExit of ExitFeature
	(properties)

	(method (init)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 3)) ; oEastCursor
		(= nsTop 0)
		(= nsBottom 314)
		(= nsLeft 920)
		(= nsRight 946)
	)

	(method (doVerb)
		(gCurRoom setScript: soTorinLeaveRoom)
	)
)

(instance foDarkness of Feature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 368 148 372 175 322 208 284 268 220 312 2 312 2 4 174 4 286 115 312 156 324 132 370 148
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Do
				(if (not ((ScriptID 64017 0) test: 71)) ; oFlags
					(gCurRoom setScript: soOpenPooDoor)
				)
			)
			(43 ; ioBoogleWorm
				(if (not ((ScriptID 64017 0) test: 71)) ; oFlags
					(if ((ScriptID 64017 0) test: 72) ; oFlags
						(gMessager say: 1 43 2 0) ; "(DON'T SEND ME BACK IN THERE!) Brawk!"
					else
						(gCurRoom setScript: soBoogleWormIn)
					)
				)
			)
			(45 ; ioBoogleLantern
				(if ((ScriptID 64017 0) test: 71) ; oFlags
					(if ((ScriptID 64017 0) test: 72) ; oFlags
						(voDarkness hide:)
						(poBoogle show:)
					else
						(gCurRoom setScript: soBoogleLamp)
					)
				)
			)
		)
	)
)

(instance voDarkness of View
	(properties
		priority 400
		fixPriority 1
		view 20403
	)

	(method (init)
		(super init: &rest)
		(foDarkness init: oDragonScrollPlane)
		(self show:)
	)

	(method (show)
		(super show:)
		(if (gEgo has: ((ScriptID 64001 0) get: 17)) ; oInvHandler, ioSmallDoorTile
			(if ((ScriptID 64017 0) test: 71) ; oFlags
				(foDarkness addHotspotVerb: 45)
				(foDarkness deleteHotspotVerb: 43)
				(foLight addHotspotVerb: 43)
				(foLight deleteHotspotVerb: 45 44)
			else
				(foDarkness deleteHotspotVerb: 45)
				(foDarkness addHotspotVerb: 43)
				(foLight deleteHotspotVerb: 43)
				(foLight addHotspotVerb: 45 44)
			)
		else
			(foDarkness deleteHotspotVerb: 43 45)
		)
		(foPoo dispose:)
	)

	(method (hide)
		(super hide:)
		(foDarkness deleteHotspotVerb: 45)
		(foPoo init: oDragonScrollPlane)
	)
)

(instance soBoogleWorm of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(voDarkness show:)
				(oDragonScrollPlane panTo: 316 0 self)
				(poBoogle
					setCel: 0
					setLoop: 3
					posn: 373 169
					show:
					setCycle: End self
				)
				(UpdateScreenItem poBoogle)
			)
			(1)
			(2
				(if register
					(register cue:)
				)
				(self cue:)
			)
			(3
				(goSound1 playSound: 60011 self)
				(gEgo get: ((ScriptID 64001 1) get: 1)) ; oBoogleHandler, ioBoogleWorm
			)
			(4
				((ScriptID 64018 0) ; oBoogle
					loop: 8
					cel: 0
					posn: 477 189
					show:
					setMotion: MoveTo 670 194 self
				)
				(poBoogle dispose:)
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance soBoogleWormOutNoPoo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 1 43 5 1 self) ; "Come on out of there, Boogle."
			)
			(1
				(self setScript: soBoogleWorm self self)
			)
			(2
				(gMessager say: 1 43 5 2 self) ; "Change back into yourself, buddy."
			)
			(3)
			(4
				((ScriptID 64017 0) clear: 71) ; oFlags
				(voDarkness show:)
				(self dispose:)
			)
		)
	)
)

(instance soBoogleBag of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poBoogle
					setCel: 0
					setLoop: 4
					posn: 900 205
					init:
					setCycle: CT 32 1 self
				)
			)
			(1
				(goSound1 playSound: 60012)
				(poBoogle setCycle: End self)
			)
			(2
				(poBoogle dispose:)
				(gEgo
					show:
					get: ((ScriptID 64001 1) get: 1) ; oBoogleHandler, ioBoogleWorm
					get: ((ScriptID 64001 0) get: 26) ; oInvHandler, ioDragonPoo
				)
				(self dispose:)
			)
		)
	)
)

(instance soBoogleWormOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 3 43 6 1 self) ; "Okay, Boogle. Turn back into a worm again and get out of there. But don't forget our "sample!""
				(oDragonScrollPlane panTo: 316 0 self)
			)
			(1)
			(2
				(gEgo setMotion: PolyPath 900 205 self)
			)
			(3
				(gEgo setHeading: 270 self)
			)
			(4
				(self setScript: soBoogleWorm self)
			)
			(5
				((ScriptID 64018 0) dispose:) ; oBoogle
				((ScriptID 64017 0) set: 232) ; oFlags
				(gEgo hide:)
				(self setScript: soBoogleBag self)
				(gMessager say: 3 43 6 2 self) ; "(HERE'S YOUR BAG, DAMMIT!) Bwark!"
			)
			(6)
			(7
				((ScriptID 64017 0) set: 58) ; oFlags
				((ScriptID 64017 0) clear: 71) ; oFlags
				(voDarkness show:)
				(self dispose:)
			)
		)
	)
)

(instance poBoogle of Prop
	(properties
		x 650
		y 204
		view 20401
	)
)

(instance soBoogleLamp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 3 45 5 1 self) ; "Boogle, turn into a lantern so we can see what's back there."
			)
			(1
				(poBoogle setLoop: 1 setCel: 0 posn: 256 180 setCycle: End)
				(UpdateScreenItem poBoogle)
				(goSound1 playSound: 20403)
				(voDarkness hide:)
				((ScriptID 64017 0) set: 74) ; oFlags
				(gMessager sayRange: 3 45 5 2 3 self) ; "Wow, Boogle! It looks brown and soft and smells terrible. We've just gotta have some of that!"
			)
			(2
				(gEgo get: ((ScriptID 64001 1) get: 4)) ; oBoogleHandler, ioBoogleLantern
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soBoogleWormIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(goSound1 preload: 20404)
				(gGame handsOff:)
				(oDragonScrollPlane panTo: 316 0 self)
				(gMessager say: 1 43 7 1 self) ; "Boogle, can you be a worm?"
			)
			(1)
			(2
				(if ((ScriptID 64017 0) test: 232) ; oFlags
					((ScriptID 64017 0) clear: 232) ; oFlags
					((ScriptID 64018 0) ; oBoogle
						normalize:
						posn: 940 216
						setHeading: 270
						setScalePercent: 85
						init:
					)
				)
				((ScriptID 64018 0) setWander: 0 setMotion: MoveTo 650 204 self) ; oBoogle
				(gMessager say: 1 43 7 2 self) ; "Check back inside there! I bet it's a way out of this land."
			)
			(3)
			(4
				((ScriptID 64018 0) setHeading: 270 self) ; oBoogle
			)
			(5
				((ScriptID 64018 0) hide:) ; oBoogle
				(poBoogle
					loop: 0
					cel: 0
					posn: 650 204
					init:
					setCycle: CT 9 1 self
				)
			)
			(6
				(goSound1 playSound: 20404)
				(poBoogle setCycle: CT 23 1 self)
			)
			(7
				(poBoogle setCel: 15 setCycle: CT 24 1 self)
			)
			(8
				(= ticks 60)
			)
			(9
				(poBoogle setCycle: End self)
			)
			(10
				(gMessager say: 1 43 7 3 self) ; "(IT'S DARK IN HERE) Bwark!"
				(oDragonScrollPlane panTo: 0 0 self)
			)
			(11)
			(12
				(gMessager say: 1 43 7 4 self) ; "Yeah, I bet it's dark in there. What are we gonna do?"
			)
			(13
				((ScriptID 64017 0) set: 73) ; oFlags
				((ScriptID 64017 0) set: 71) ; oFlags
				(voDarkness show:)
				(gEgo get: ((ScriptID 64001 1) get: 1)) ; oBoogleHandler, ioBoogleWorm
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance oBoogleBlech of TPSound
	(properties)
)

(instance soBoogleTakePoo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(goSound1 preload: 20403 20402 20405)
				(gGame handsOff:)
				(oDragonScrollPlane panTo: 0 0 self)
				(gMessager say: 3 44 4 1 self) ; "Uh, say Boogle, would you mind being a shovel?"
			)
			(1)
			(2
				(poBoogle setLoop: 2 setCel: 0 setCycle: End self)
				(UpdateScreenItem poBoogle)
			)
			(3
				(goSound1 playSound: 12006 self)
			)
			(4
				(gMessager say: 3 44 4 2 self) ; "I say, be a shovel."
			)
			(5
				(voDarkness show:)
				(poBoogle setLoop: 1 setCel: 1 hide:)
				(goSound1 playSound: 20403)
				(gMessager say: 3 44 4 3 self) ; "(YUCK!) Brawk!"
			)
			(6
				(goSound1 playSound: 20402 self)
				(oBoogleBlech playSound: 20405 self)
			)
			(7)
			(8
				(gEgo get: ((ScriptID 64001 1) get: 3)) ; oBoogleHandler, ioBoogleShovel
				((ScriptID 64017 0) set: 72) ; oFlags
				(voDarkness show:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance foPoo of Feature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					init: 308 313 269 254 216 227 215 217 185 202 171 209 160 202 157 178 140 170 115 182 101 176 85 188 69 161 37 171 31 201 45 222 58 225 78 243 97 258 96 276 145 303 164 299 165 313
					yourself:
				)
		)
		(super init: &rest)
		(self addHotspotVerb: 44)
	)

	(method (doVerb)
		(if ((ScriptID 64017 0) test: 71) ; oFlags
			(if ((ScriptID 64017 0) test: 72) ; oFlags
				(gMessager say: 3 44 2 0) ; "(ONCE IS ENOUGH!) Bwark!"
			else
				(gCurRoom setScript: soBoogleTakePoo)
			)
		)
	)
)

(instance poTorin of Prop
	(properties
		x 898
		y 214
		view 20400
	)
)

(instance soReachInside of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poTorin setCel: 0 setLoop: 1 setCycle: End self)
			)
			(1
				(poTorin setCel: 0 setLoop: 2 setCycle: End self)
			)
			(2
				(poTorin setCel: 0 setCycle: Fwd self)
				(self dispose:)
			)
		)
	)
)

(instance toTorin of Talker
	(properties
		x 898
		y 214
		view 20400
		loop 3
		priority 215
	)
)

(instance soOpenPooDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(goSound1 preload: 20401)
				(gGame handsOff:)
				(oDragonScrollPlane panTo: 316 0 self)
			)
			(1
				(gEgo hide:)
				(poTorin init: cycleSpeed: 10 setCycle: CT 14 1 self)
			)
			(2
				(gMessager say: 1 1 1 1 self) ; "Grunt. Strain. Groan."
				(poTorin cycleSpeed: 7 setCycle: CT 48 1 self)
			)
			(3)
			(4
				(voPooDoor dispose:)
				(gMessager say: 1 1 1 2 self) ; "I've got it!"
			)
			(5
				(poTorin setCycle: CT 56 1 self)
				(goSound1 playSound: 20401)
			)
			(6
				(gEgo get: ((ScriptID 64001 0) get: 17)) ; oInvHandler, ioSmallDoorTile
				((ScriptID 64017 0) set: 49) ; oFlags
				(poTorin setCycle: End self)
			)
			(7
				(= gtTorin toTorin)
				(gMessager say: 1 1 1 3 self) ; "PEEEEEEEUUU! What a stench!"
			)
			(8
				(= gtTorin 0)
				(self setScript: soReachInside self)
				(gMessager say: 1 1 1 4 self) ; "I wonder what's inside there?"
			)
			(9)
			(10
				(poTorin
					setCycle: 0
					setLoop: 0
					setCel: 46
					setCycle: CT 14 -1 self
				)
			)
			(11
				(poTorin cycleSpeed: 10 setCycle: Beg self)
			)
			(12
				(voDarkness show:)
				(gEgo show:)
				(poTorin dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance voPooDoor of View
	(properties
		x 376
		y 154
		view 20402
	)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1 43)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Do
				(gCurRoom setScript: soOpenPooDoor)
			)
			(43 ; ioBoogleWorm
				(gMessager say: 1 43 1 0) ; "I bet Boogle could fit through that door...if I could only open it!"
			)
		)
	)
)

(instance foLight of Feature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 348 136 262 96 158 0 934 0 934 316 218 316 286 259 306 252 326 199 374 168 376 148
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Do
				(if ((ScriptID 64017 0) test: 72) ; oFlags
					(gMessager say: 1 1 2 0) ; "There's nothing more for me to do here."
				else
					(gMessager say: 1 1 7 0) ; "(Struggling) There's just no way I can fit through that tiny opening! But I have a feeling there must be something back there."
				)
			)
			(43 ; ioBoogleWorm
				(if ((ScriptID 64017 0) test: 72) ; oFlags
					(gGame handsOff:)
					(gCurRoom setScript: soBoogleWormOut (ScriptID 64020 0)) ; oHandsOnWhenCued
				else
					(gGame handsOff:)
					(gCurRoom setScript: soBoogleWormOutNoPoo (ScriptID 64020 0)) ; oHandsOnWhenCued
				)
			)
			(45 ; ioBoogleLantern
				(gMessager say: 1 45 0 0) ; "It's already light enough in here to see that's a doorway."
			)
			(44 ; ioBoogleShovel
				(gMessager say: 1 44 0 0) ; "There's nothing there for Boogle to shovel."
			)
		)
	)
)

(instance oDragonScrollPlane of TorScrollPlane
	(properties
		priority 20
	)

	(method (init)
		(= oWScrollExit 0)
		(super init: &rest)
	)

	(method (addPics)
		(AddPicAt self 20400 0 0)
		(AddPicAt self 20401 474 0)
	)
)

(instance roDragonCave of TPRoom
	(properties
		picture -2
	)

	(method (init)
		(super init: &rest)
		(= plane (oDragonScrollPlane init: 948 (gThePlane getHeight:) yourself:))
		(goMusic1 relVolPercent: 180 setMusic: 20400)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 928 204 910 204 905 216 928 216
					yourself:
				)
		)
		((ScriptID 64017 0) clear: 71) ; oFlags
		(foLight init: oDragonScrollPlane)
		(voDarkness init: oDragonScrollPlane)
		(if (not ((ScriptID 64017 0) test: 49)) ; oFlags
			(voPooDoor init: oDragonScrollPlane)
		)
		(foToCliffExit init:)
		(gEgo normalize: setHeading: 225 posn: 915 216 init:)
		(if (!= gPrevRoomNum 20100) ; roCliffScroller
			((ScriptID 64017 0) set: 232) ; oFlags
		)
		(gGame handsOn:)
	)

	(method (dispose)
		(goMusic1 stop: relVolPercent: 100)
		(super dispose: &rest)
	)
)

